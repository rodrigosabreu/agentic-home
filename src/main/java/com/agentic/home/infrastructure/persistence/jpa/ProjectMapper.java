package com.agentic.home.infrastructure.persistence.jpa;

import com.agentic.home.domain.model.project.Project;
import com.agentic.home.domain.model.valueobjects.*;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.stream.Collectors;

@Component
public class ProjectMapper {
    
    public ProjectEntity toEntity(Project project) {
        ProjectEntity entity;
        
        if (project.getId() != null) {
            // Existing entity - update
            entity = new ProjectEntity();
            entity.setId(project.getId());
        } else {
            entity = new ProjectEntity(
                project.getId(),
                project.getName(),
                project.getDescription(),
                project.getLocalPath(),
                project.getRemoteUrl(),
                project.getAgentsMdPath(),
                project.getCliInterface(),
                project.getStatus(),
                project.getMetadata(),
                project.getCreatedAt(),
                project.getUpdatedAt(),
                project.getVersion()
            );
        }
        
        entity.setName(project.getName());
        entity.setDescription(project.getDescription());
        entity.setLocalPath(project.getLocalPath());
        entity.setRemoteUrl(project.getRemoteUrl());
        entity.setAgentsMdPath(project.getAgentsMdPath());
        entity.setCliInterface(project.getCliInterface());
        entity.setStatus(project.getStatus());
        entity.setMetadata(project.getMetadata());
        entity.setUpdatedAt(project.getUpdatedAt());
        entity.setVersion(project.getVersion());
        
        return entity;
    }
    
    public Project toDomain(ProjectEntity entity) {
        var project = new Project();
        
        // This is a simplified reconstruction - in production you'd use a proper mapping library
        // or add package-private setters
        
        return null; // Placeholder - would need proper implementation
    }
}