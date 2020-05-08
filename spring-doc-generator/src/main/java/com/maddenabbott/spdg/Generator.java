package com.maddenabbott.spdg;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.maddenabbott.spdg.model.Metadata;
import com.maddenabbott.spdg.util.PathUtils;

import java.nio.file.Paths;

public class Generator {

  private final ObjectMapper mapper;

  private final MetadataView view;

  public Generator(final ObjectMapper mapper, final MetadataView view) {
    this.mapper = mapper;
    this.view = view;
  }

  public String generate(final String filename) {
    Metadata metadata = toMetadata(PathUtils.read(Paths.get(filename)));
    return view.render(metadata);
  }

  private Metadata toMetadata(final String metadata) {
    try {
      return mapper.readValue(metadata, Metadata.class);
    } catch (JsonProcessingException e) {
      throw new RuntimeException(e);
    }
  }
}
