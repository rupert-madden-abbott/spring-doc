package com.maddenabbott.spdg;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.maddenabbott.spdg.model.Metadata;

public class Generator {

  private final ObjectMapper mapper;

  private final MetadataView view;

  public Generator(final ObjectMapper mapper, final MetadataView view) {
    this.mapper = mapper;
    this.view = view;
  }

  public String generate(final String filename) {
    Metadata metadata = getMetadata(read(filename));
    return view.render(metadata);
  }

  private Metadata getMetadata(final String metadata) {
    try {
      return mapper.readValue(metadata, Metadata.class);
    } catch (JsonProcessingException e) {
      throw new RuntimeException(e);
    }
  }

  private String read(final String filename) {
    String metadata;
    try {
      metadata = Files.readString(Path.of(filename));
    } catch (IOException e) {
      throw new UncheckedIOException(e);
    }
    return metadata;
  }
}
