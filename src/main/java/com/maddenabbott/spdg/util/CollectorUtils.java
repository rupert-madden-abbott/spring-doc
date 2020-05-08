package com.maddenabbott.spdg.util;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collector;

import static java.util.stream.Collectors.*;

public class CollectorUtils {
    public static <T, K, U> Collector<T, ?, Map<K, U>> toLinkedMap(
            Function<? super T, ? extends K> keyMapper,
            Function<? super T, ? extends U> valueMapper
    ) {
        return toMap(
                keyMapper,
                valueMapper,
                (u, v) -> {
                    throw new IllegalStateException(String.format("Duplicate key %s", u));
                },
                LinkedHashMap::new
        );
    }

    public static <T, K> Collector<T, ?, Map<K, List<T>>> orderedGroupingBy(
            Function<? super T, ? extends K> classifier
    ) {
        return groupingBy(classifier, LinkedHashMap::new, toList());
    }
}
