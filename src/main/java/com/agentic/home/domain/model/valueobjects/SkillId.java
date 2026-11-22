package com.agentic.home.domain.model.valueobjects;

import java.util.Objects;
import java.util.UUID;

public record SkillId(UUID value) {
    
    public static SkillId generate() {
        return new SkillId(UUID.randomUUID());
    }
    
    public static SkillId fromString(String value) {
        return new SkillId(UUID.fromString(value));
    }
    
    @Override
    public String toString() {
        return value.toString();
    }
}