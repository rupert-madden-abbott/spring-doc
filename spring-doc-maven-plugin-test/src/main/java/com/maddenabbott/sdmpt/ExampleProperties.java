package com.maddenabbott.sdmpt;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Some example properties.
 */
@ConfigurationProperties("example")
public class ExampleProperties {
    /**
     * A property that can be set.
     */
    private String foo;

    public String getFoo() {
        return foo;
    }

    public void setFoo(String foo) {
        this.foo = foo;
    }
}
