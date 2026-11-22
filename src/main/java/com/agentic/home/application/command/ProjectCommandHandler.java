package com.agentic.home.application.command;

import com.agentic.home.domain.model.project.Project;
import com.agentic.home.domain.model.project.ProjectRepository;
import com.agentic.home.domain.model.valueobjects.AssessmentId;
import com.agentic.home.domain.model.valueobjects.InvestorId;
import com.agentic.home.domain.model.valueobjects.ProductId;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProjectCommandHandler {
    
    private final ProjectRepository projectRepository;
    
    public ProjectCommandHandler(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }
    
    public AssessmentId handle(CreateProjectCommand command) {
        // Check idempotency
        var existing = projectRepository.findByIdempotencyKey(command.idempotencyKey());
        if (existing.isPresent()) {
            return existing.get().getId();
        }
        
        // Create new project
        var project = Project.create(
            command.investorId(),
            command.productId(),
            command.idempotencyKey()
        );
        
        projectRepository.save(project);
        
        return project.getId();
    }
}