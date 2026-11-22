package com.agentic.home.domain.model.project;

import com.agentic.home.domain.model.valueobjects.ProjectId;
import com.agentic.home.domain.model.valueobjects.ProjectStatus;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProjectRepository {
    
    void save(Project project);
    
    Optional<Project> findById(ProjectId id);
    
    Optional<Project> findByName(String name);
    
    List<Project> findByStatus(ProjectStatus status);
}