package com.maddenabbott.spdg.model;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.function.Function;

import lombok.Getter;
import lombok.Setter;

import static com.maddenabbott.spdg.util.CollectorUtils.toLinkedMap;
import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.groupingBy;

@Getter
@Setter
public class Metadata {
  private List<Group> groups;

  private List<Property> properties;

  public Map<Group, List<Property>> groupedProperties() {
    Map<String, Group> groupsByType = groups.stream()
        .sorted(comparing(Group::getName))
        .collect(toLinkedMap(Group::getType, Function.identity()));

    return properties.stream()
        .sorted(comparing(Property::getName))
        .collect(groupingBy((property) -> {
          Group group = groupsByType.get(property.getSourceType());
          if (group == null) {
            throw new NoSuchElementException("Invalid metadata file. Property "
                + property.getName() + " has source type " + property.getSourceType()
                + " but no group exists with that type.");
          }
          return group;
        }));
  }
}
