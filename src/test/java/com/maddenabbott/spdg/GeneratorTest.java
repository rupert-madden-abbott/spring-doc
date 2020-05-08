package com.maddenabbott.spdg;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class GeneratorTest {
  @Autowired
  private Generator generator;

  @Test
  public void shouldGenerateDocs() {
    String generate = generator.generate("src/test/resources/spring-configuration-metadata.json");

    System.out.println();

  }

}