package com.agentic.home.domain.model.valueobjects;

import java.util.Objects;
import java.util.UUID;

public record ProjectId(UUID value) {
    
    public static ProjectId generate() {
        return new ProjectId(UUID.randomUUID());
    }
    
    public static ProjectId fromString(String value) {
        return new ProjectId(UUID.fromString(value));
    }
    
    @Override
    public String toString() {
        return value.toString();
    }
}