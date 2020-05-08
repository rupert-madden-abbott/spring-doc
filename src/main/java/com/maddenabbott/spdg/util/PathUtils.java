package com.maddenabbott.spdg.util;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class PathUtils {
    public static String read(final Path path) {
        try {
            return new String(Files.readAllBytes(path));
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
}
