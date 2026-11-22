package com.agentic.home.application.command;

import com.agentic.home.domain.model.valueobjects.InvestorId;
import com.agentic.home.domain.model.valueobjects.ProductId;
import java.time.Instant;
import java.util.UUID;

public record CreateProjectCommand(
    InvestorId investorId,
    ProductId productId,
    String idempotencyKey,
    String correlationId,
    String causationId
) {
    public static CreateProjectCommand of(InvestorId investorId, ProductId productId) {
        return new CreateProjectCommand(
            investorId, 
            productId, 
            UUID.randomUUID().toString(),
            UUID.randomUUID().toString(),
            null
        );
    }
}