package com.maddenabbott.spdg;

import com.maddenabbott.spdg.util.PathUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.nio.file.Paths;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class GeneratorTest {
    @Autowired
    private Generator generator;

    @Test
    public void shouldGenerateDocs() {
        String expected = PathUtils.read(Paths.get("src/test/resources/CONFIG.MD"))
                .replace("\r\n", "\n");

        String actual = generator.generate("src/test/resources/spring-configuration-metadata.json");

        assertThat(actual).isEqualTo(expected);
    }

}