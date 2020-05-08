package com.maddenabbott.spdg;

import com.maddenabbott.spdg.model.Metadata;

public interface MetadataView {
  public String render(Metadata metadata);

  public String fileName();
}
