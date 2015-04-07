package com.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MyEntity {

    private String value;

    public MyEntity(String value) {
        this.setValue(value);
    }

    @JsonProperty
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
