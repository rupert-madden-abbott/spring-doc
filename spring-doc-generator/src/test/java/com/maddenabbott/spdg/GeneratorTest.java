package com.maddenabbott.spdg;

import com.maddenabbott.spdg.util.PathUtils;
import org.junit.jupiter.api.Test;

import java.nio.file.Paths;

import static org.assertj.core.api.Assertions.assertThat;

class GeneratorTest {
    private Generator generator = Generator.getDefault();

    @Test
    public void shouldGenerateDocs() {
        String expected = PathUtils.read(Paths.get("src/test/resources/CONFIG.MD"))
                .replace("\r\n", "\n");

        String actual = generator.generate("src/test/resources/spring-configuration-metadata.json");

        assertThat(actual).isEqualTo(expected);
    }

}