package com.agentic.home.infrastructure.persistence.jpa;

import com.agentic.home.domain.model.valueobjects.ProjectId;
import com.agentic.home.domain.model.valueobjects.ProjectStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.Instant;
import java.util.Map;
import java.util.UUID;

@Entity
@Table(name = "projects")
@Getter
@Setter
public class ProjectEntity {
    
    @Id
    @Column(name = "id", columnDefinition = "uuid")
    private ProjectId id;
    
    @Column(name = "name", nullable = false, length = 255)
    private String name;
    
    @Column(name = "description", columnDefinition = "TEXT")
    private String description;
    
    @Column(name = "local_path", length = 500)
    private String localPath;
    
    @Column(name = "remote_url", length = 500)
    private String remoteUrl;
    
    @Column(name = "agents_md_path", nullable = false, length = 100)
    private String agentsMdPath;
    
    @Column(name = "cli_interface", length = 500)
    private String cliInterface;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false, length = 20)
    private ProjectStatus status;
    
    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "metadata", columnDefinition = "jsonb")
    private Map<String, Object> metadata;
    
    @Column(name = "created_at", nullable = false)
    private Instant createdAt;
    
    @Column(name = "updated_at", nullable = false)
    private Instant updatedAt;
    
    @Version
    @Column(name = "version", nullable = false)
    private int version = 0;
    
    // Constructors
    public ProjectEntity() {}
    
    public ProjectEntity(
            ProjectId id, String name, String description, String localPath,
            String remoteUrl, String agentsMdPath, String cliInterface,
            ProjectStatus status, Map<String, Object> metadata,
            Instant createdAt, Instant updatedAt, int version) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.localPath = localPath;
        this.remoteUrl = remoteUrl;
        this.agentsMdPath = agentsMdPath;
        this.cliInterface = cliInterface;
        this.status = status;
        this.metadata = metadata;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.version = version;
    }
}