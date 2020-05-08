package com.maddenabbott.spdg;

import com.maddenabbott.spdg.model.Metadata;

public interface MetadataView {
    String render(Metadata metadata);

    String fileName();
}
