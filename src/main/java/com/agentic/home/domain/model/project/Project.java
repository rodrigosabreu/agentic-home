package com.agentic.home.domain.model.project;

import com.agentic.home.domain.model.events.SuitabilityAssessmentCreated;
import com.agentic.home.domain.model.valueobjects.*;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Project {
    
    private final ProjectId id;
    private final InvestorId investorId;
    private final ProductId productId;
    private final String idempotencyKey;
    private ProjectStatus status;
    private String agentsMdPath;
    private String cliInterface;
    private String remoteUrl;
    private String localPath;
    private Map<String, Object> metadata;
    private final Instant createdAt;
    private Instant updatedAt;
    private final List<DomainEvent> uncommittedEvents = new ArrayList<>();
    private int version = 0;
    
    private Project() {
        this.id = ProjectId.generate();
        this.idempotencyKey = UUID.randomUUID().toString();
        this.status = ProjectStatus.PROTOTYPE;
        this.createdAt = Instant.now();
        this.updatedAt = Instant.now();
        this.expiresAt = Instant.now().plusSeconds(24 * 30 * 60 * 60); // 24 months
    }
    
    public static Project create(InvestorId investorId, ProductId productId, String idempotencyKey) {
        Project project = new Project();
        project.investorId = investorId;
        project.productId = productId;
        project.idempotencyKey = idempotencyKey;
        return project;
    }
    
    public void registerEvent(DomainEvent event) {
        this.uncommittedEvents.add(event);
        this.version++;
    }
    
    public List<DomainEvent> getUncommittedEvents() {
        return List.copyOf(uncommittedEvents);
    }
    
    public void clearEvents() {
        this.uncommittedEvents.clear();
    }
    
    // Getters
    public ProjectId getId() { return id; }
    public InvestorId getInvestorId() { return investorId; }
    public ProductId getProductId() { return productId; }
    public String getIdempotencyKey() { return idempotencyKey; }
    public ProjectStatus getStatus() { return status; }
    public String getAgentsMdPath() { return agentsMdPath; }
    public String getCliInterface() { return cliInterface; }
    public String getRemoteUrl() { return remoteUrl; }
    public String getLocalPath() { return localPath; }
    public Map<String, Object> getMetadata() { return metadata; }
    public Instant getCreatedAt() { return createdAt; }
    public Instant getUpdatedAt() { return updatedAt; }
    public int getVersion() { return version; }
}