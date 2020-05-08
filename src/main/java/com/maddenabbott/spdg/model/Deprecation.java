package com.maddenabbott.spdg.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Deprecation {
  private String level;
  private String reason;
  private String replacement;
}
