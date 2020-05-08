package com.maddenabbott.spdg.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Property {
  private String name;
  private String type;
  private String description;
  private String sourceType;
  private String defaultValue;
  private Deprecation deprecation;

}
