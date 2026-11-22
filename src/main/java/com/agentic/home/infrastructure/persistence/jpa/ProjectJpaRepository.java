package com.agentic.home.domain.model.project;

import com.agentic.home.domain.model.valueobjects.ProjectId;
import com.agentic.home.domain.model.valueobjects.ProjectStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProjectJpaRepository extends JpaRepository<Project, ProjectId> {
    
    Optional<Project> findByName(String name);
    
    List<Project> findByStatus(ProjectStatus status);
    
    @Query("SELECT p FROM Project p WHERE p.localPath = :localPath")
    Optional<Project> findByLocalPath(@Param("localPath") String localPath);
    
    @Query("SELECT p FROM Project p WHERE p.remoteUrl = :remoteUrl")
    Optional<Project> findByRemoteUrl(@Param("remoteUrl") String remoteUrl);
}