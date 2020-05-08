package com.maddenabbott.spdg;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GeneratorAutoConfiguration {
  @Bean
  public Generator generator(final ObjectMapper objectMapper, final MetadataView view) {
    return new Generator(objectMapper, view);
  }

  @Bean
  @ConditionalOnMissingBean
  public MetadataView view() {
    return new MarkdownMetadataView();
  }
}
