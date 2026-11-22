package com.agentic.home.infrastructure.persistence.jpa;

import com.agentic.home.domain.model.project.Project;
import com.agentic.home.domain.model.project.ProjectRepository;
import com.agentic.home.domain.model.valueobjects.ProjectId;
import com.agentic.home.domain.model.valueobjects.ProjectStatus;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class ProjectRepositoryImpl implements ProjectRepository {
    
    private final ProjectJpaRepository jpaRepository;
    private final ProjectMapper mapper;
    
    public ProjectRepositoryImpl(ProjectJpaRepository jpaRepository, ProjectMapper mapper) {
        this.jpaRepository = jpaRepository;
        this.mapper = mapper;
    }
    
    @Override
    public void save(Project project) {
        var entity = mapper.toEntity(project);
        jpaRepository.save(entity);
    }
    
    @Override
    public Optional<Project> findById(ProjectId id) {
        return jpaRepository.findById(id).map(mapper::toDomain);
    }
    
    @Override
    public Optional<Project> findByName(String name) {
        return jpaRepository.findByName(name).map(mapper::toDomain);
    }
    
    @Override
    public List<Project> findByStatus(ProjectStatus status) {
        return jpaRepository.findByStatus(status).stream()
            .map(mapper::toDomain)
            .collect(Collectors.toList());
    }
}