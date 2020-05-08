package com.maddenabbott.spdg.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Group {
    private String name;
    private String type;
    private String description;
    private String sourceType;
    private String sourceMethod;
}
