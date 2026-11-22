package com.agentic.home.interfaces.rest;

import com.agentic.home.application.command.ProjectCommandHandler;
import com.agentic.home.application.command.CreateProjectCommand;
import com.agentic.home.domain.model.valueobjects.AssessmentId;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/projects")
@Tag(name = "Project Management", description = "Project CRUD operations")
public class ProjectController {
    
    private final ProjectCommandHandler commandHandler;
    
    public ProjectController(ProjectCommandHandler commandHandler) {
        this.commandHandler = commandHandler;
    }
    
    @PostMapping
    @Operation(summary = "Create a new project")
    public ResponseEntity<ProjectResponse> createProject(@Valid @RequestBody CreateProjectRequest request) {
        var command = new CreateProjectCommand(
            new InvestorId(UUID.fromString(request.investorId())),
            new ProductId(UUID.fromString(request.productId())),
            request.idempotencyKey(),
            UUID.randomUUID().toString(),
            null
        );
        
        AssessmentId assessmentId = commandHandler.handle(command);
        
        return ResponseEntity.status(HttpStatus.CREATED)
            .body(new ProjectResponse(assessmentId.toString(), "CREATED"));
    }
    
    @PostMapping("/{assessmentId}/sign")
    @Operation(summary = "Sign project document")
    public ResponseEntity<ProjectResponse> signDocument(
            @PathVariable String assessmentId,
            @Valid @RequestBody SignDocumentRequest request) {
        
        // Implementation would call commandHandler.handle(new SignDocumentCommand(...))
        return ResponseEntity.ok(new ProjectResponse(assessmentId, "SIGNED"));
    }
    
    @GetMapping("/{assessmentId}")
    @Operation(summary = "Get project by ID")
    public ResponseEntity<ProjectDTO> getProject(@PathVariable String assessmentId) {
        // Implementation would call queryHandler
        return ResponseEntity.ok(new ProjectDTO());
    }
    
    @GetMapping("/investor/{investorId}")
    @Operation(summary = "List projects by investor")
    public ResponseEntity<java.util.List<ProjectDTO>> getByInvestor(@PathVariable String investorId) {
        return ResponseEntity.ok(java.util.List.of());
    }
    
    // Request/Response DTOs
    public record CreateProjectRequest(
        String investorId,
        String productId,
        String idempotencyKey
    ) {}
    
    public record SignDocumentRequest(
        String documentHash,
        String signedBy
    ) {}
    
    public record ProjectResponse(
        String assessmentId,
        String status
    ) {}
    
    public record ProjectDTO(
        String id,
        String investorId,
        String productId,
        String status,
        String createdAt
    ) {}
}