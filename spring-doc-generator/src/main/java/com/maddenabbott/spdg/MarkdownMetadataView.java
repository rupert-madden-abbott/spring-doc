package com.maddenabbott.spdg;

import com.maddenabbott.spdg.model.Group;
import com.maddenabbott.spdg.model.Metadata;
import com.maddenabbott.spdg.model.Property;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.maddenabbott.spdg.util.StringUtils.isBlank;

public class MarkdownMetadataView implements MetadataView {
    @Override
    public String render(final Metadata metadata) {
        return metadata.groupedProperties().entrySet().stream()
                .map(this::render)
                .collect(Collectors.joining("\n\n"));
    }

    private String render(final Map.Entry<Group, List<Property>> entry) {
        return render(entry.getKey(), entry.getValue());
    }

    private String render(final Group group, final List<Property> properties) {
        StringBuilder stringBuilder = new StringBuilder()
                .append("##")
                .append(group.getName())
                .append("\n");

        if (group.getDescription() != null && !isBlank(group.getDescription())) {
            stringBuilder.append(group.getDescription());
        }

        stringBuilder.append("|Key|Default Value|Description|\n")
                .append("|---|---|---|\n");

        stringBuilder.append(properties.stream()
                .map(property -> "|"
                        + property.getName() + "|"
                        + property.getDefaultValue() + "|"
                        + property.getDescription() + "|"
                )
                .collect(Collectors.joining("\n")));
        return stringBuilder.toString();
    }
}
