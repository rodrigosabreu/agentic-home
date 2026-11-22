# Governança — Agentic Home

> **Matriz de permissões, fluxos de aprovação e políticas operacionais para o Agentic Home e seus projetos.**

---

## 🎯 Princípios de Governança

| Princípio | Descrição |
|-----------|-------------|
| **Home descobre, projetos executam** | Home é um mapa; projetos são o território |
| **Contexto é explícito** | Cada handoff, ADR e skill torna contexto explícito |
| **Humano controla ações irreversíveis** | Merge, deploy, delete, gasto — aprovação humana obrigatória |
| **Estado vive nos projetos** | Home não tem estado operacional |
| **Skills são compartilhadas, não impostas** | Projetos escolhem quais skills adotar |

---

## 📋 Matriz de Operações

### ✅ Operações Permitidas (Sem Aprovação)

| Operação | Quem | Condições |
|-----------|-----|-----------|
| Ler documentação (AGENTS.md, catálogo, skills, ADRs) | Qualquer agente/humano | Sempre |
| Navegar catálogo de projetos | Qualquer agente/humano | Sempre |
| Carregar e usar skills compartilhadas | Qualquer agente | `skill_view()` explícito |
| Preparar artefatos (código, docs, testes, ADRs) | Agente atribuído | Dentro do escopo da tarefa |
| Executar validações autorizadas | Agente atribuído | Dentro do pipeline CI do projeto |
| Atualizar handoff de tarefa (append-only) | Dono da tarefa | No handoff.md do projeto |
| Criar PRs em rascunho | Agente atribuído | Para revisão, não auto-merge |
| Rodar testes & validações locais | Agente atribuído | Antes de push |

### ⚠️ Operações Requerendo Aprovação Humana

| Operação | Aprovadores Necessários | Evidência Necessária |
|-----------|------------------------|---------------------|
| **Merge em branch protegida** (main, release/*) | 2 aprovações: 1 Tech Lead + 1 Compliance/Segurança | Descrição PR, CI passando, issue linkado |
| **Deploy em Produção** | 3 aprovações: Tech Lead + Risk/Compliance + Business Owner | Plano de deploy, plano rollback, resultados testes, confirmação SLA |
| **Deploy em Staging** | 1 aprovação: Tech Lead ou Release Manager | Plano smoke test, config feature flags |
| **Gasto Financeiro** (cloud, APIs, licenças) | Finance + Tech Lead | Estimativa custo, referência orçamento, ROI |
| **Deleção de Dados / Mudança Retenção** | Legal/Compliance + Data Owner | Avaliação impacto, plano rollback, log auditoria |
| **Mudança de Permissões** (IAM, Vault, RBAC) | Security + Platform Owner | Justificativa, análise impacto, rollback |
| **Mudança Config Sensível** (rotação secrets, TLS, chaves) | Security + Platform Owner | Plano rotação, passos validação, contato emergência |
| **Mudança Schema/Destrutiva DB** | DBA + Tech Lead + App Owner | Plano migração, script rollback, evidência teste |
| **Novas Dependências Externas** (vendors, APIs, SaaS) | Security + Legal + Finance | Avaliação vendor, contrato, fluxo dados |
| **Mudança Política/Regra** (OPA, regras compliance) | Compliance + Legal + Tech Lead | Impacto regulatório, casos teste, rollback |

---

## 🔐 Modelo de Permissões

### Papéis & Responsabilidades

| Papel | Escopo | Pode Aprovar |
|------|-------|-------------|
| **Tech Lead** | Decisões técnicas do projeto | PR merges, deploys staging, dívida técnica |
| **Security Engineer** | Postura segurança, secrets, compliance | Configs segurança, rotação secrets, resposta vuln |
| **Compliance Officer** | Adesão regulatória (CVM, LGPD, SOX, PCI) | Mudanças política, trilhas auditoria, retenção dados |
| **Risk Manager** | Risco operacional, BC/DR | Planos deploy, rollback, resposta incidente |
| **Finance** | Orçamento, gastos, contratos vendors | Gastos cloud, custos APIs, contratos |
| **Legal** | Contratos, processamento dados, IP | Contratos vendors, DPAs, termos serviço |
| **Product/Business Owner** | Prioridade feature, risco negócio | Escopo feature, timing release, impacto usuário |
| **Platform/Infra Owner** | Kubernetes, networking, Vault, CI/CD | Mudanças infra, capacidade, permissões |

### Thresholds de Aprovação

| Ação | Mínimo Aprovadores | Papéis Necessários |
|--------|-------------------|-------------------|
| Merge em `main` | 2 | Tech Lead + (Security \| Compliance \| QA) |
| Deploy Staging | 1 | Tech Lead |
| Deploy Produção | 3 | Tech Lead + Compliance + Business Owner |
| Hotfix Emergencial | 2 | Tech Lead + (Security \| Compliance) |
| Mudança Política | 3 | Tech Lead + Compliance + Legal |
| Rotação Secret | 2 | Security + Platform Owner |

---

## 🛡️ Security Boundaries

### Princípios Zero Trust

| Boundary | Rule |
|----------|------|
| **Home → Project** | Home lê catálogo apenas; sem secrets projeto, sem acesso código |
| **Project → Home** | Projeto registra no catálogo; sem acesso secrets Home |
| **Project ↔ Project** | Sem acesso direto estado; comunicação via APIs/eventos |
| **Agent → Project** | Agente lê AGENTS.md, usa skills, executa tarefas autorizadas |
| **Agent → Home** | Agente lê catálogo, usa skills compartilhadas; sem modificação estado Home |

### Secrets Management

| Tipo Secret | Storage | Rotação | Acesso |
|-------------|---------|----------|--------|
| **DB Credentials** | Vault (project path) | 90 dias | App apenas via Vault Agent |
| **API Keys** | Vault (project path) | 90 dias | App apenas via Vault Agent |
| **TLS Certs** | Vault (PKI) | 365 dias | Automático via cert-manager |
| **SSH Keys** | Vault (SSH CA) | 90 dias | Humano via Vault CLI |
| **Service Accounts** | Vault (K8s auth) | 30 dias | Workload Identity |

### Classificação de Dados

| Classificação | Exemplos | Tratamento |
|---------------|----------|------------|
| **Público** | Documentação, APIs públicas | Sem criptografia obrigatória |
| **Interno** | Docs arquitetura, APIs internas | Criptografado em repouso |
| **Confidencial** | Lógica negócio, configs | Criptografado repouso + trânsito |
| **Restrito** | PII, credenciais, dados financeiros | Criptografado repouso + trânsito + field-level |
| **Regulado** | Dados CVM/SOX/PCI | Field-level encryption + audit trail + retention policy |

---

## 🔄 Change Management

### Fluxo Padrão

```
1. Create Issue/Ticket          → 2. Design/Plan (ADR se arquitetural)
                                    │
                                    ▼
3. Implement (small PRs)          → 4. CI Pipeline (all gates)
                                    │
                                    ▼
5. Code Review (2 approvals)      → 6. Staging Deploy (canary)
                                    │
                                    ▼
7. Validation (smoke + regression) → 8. Production Deploy (approval)
                                    │
                                    ▼
9. Post-Deploy Monitoring         → 10. Update Docs/ADRs
```

### Emergency Change Flow

```
1. Incident Declaration           → 2. Emergency Fix (escopo mínimo)
                                    │
                                    ▼
3. Expedited Review (2 approvals) → 4. Deploy com Monitoramento Aumentado
                                    │
                                    ▼
3. Post-Incident Review (48h)     → 4. Root Cause + Prevention ADR
```

---

## 🚨 Incident Response

### Severity Levels

| Level | Definition | Response Time | Escalation |
|-------|------------|---------------|------------|
| **SEV-1** | Produção down, perda dados, breach segurança | < 15 min | Tech Lead + Security + Compliance + On-call |
| **SEV-2** | Feature major degradada, performance crítica | < 1 hour | Tech Lead + On-call |
| **SEV-3** | Feature menor degradada, workaround existe | < 4 hours | On-call |
| **SEV-4** | Cosmético, documentação, baixo impacto | Next sprint | Team |

### Communication Channels

| Channel | Purpose |
|---------|---------|
| **#incident-sev1** | Coordenação SEV-1 (all hands) |
| **#incident-sev2** | Coordenação SEV-2 |
| **#oncall** | Handoffs on-call, pages |
| **#deployments** | Notificações deploy |

---

## 📊 Compliance & Audit

### Required Audit Trails

| Activity | Retention | Format |
|----------|-----------|--------|
| Git commits & PRs | 7 years | Git history + GitHub archive |
| PR reviews & approvals | 7 years | GitHub PR records |
| Deployments | 7 years | Harness deployment history |
| Infrastructure changes | 7 years | Terraform state + GitOps repo |
| Secret rotations | 7 years | Vault audit logs |
| Access grants/revokes | 7 years | IAM/Vault audit logs |
| Compliance decisions | 10 years | ADR + meeting records |

### Regular Audits

| Audit | Frequency | Owner |
|-------|-----------|-------|
| Access Review (IAM, Vault, GitHub) | Quarterly | Security |
| Secret Rotation Verification | Monthly | Security |
| Dependency Vulnerability Scan | Weekly (CI) + Monthly (report) | Security |
| Compliance Policy Review | Semi-annual | Compliance |
| DR/BCP Test | Semi-annual | Platform + Risk |
| Penetration Test | Annual | Security + External |

---

## 🚫 Prohibited Actions

| Action | Reason |
|--------|--------|
| Storing secrets in Git (even encrypted) | Source control is not a secret store |
| Sharing credentials via chat/email | Use Vault or secure sharing |
| Bypassing CI gates | Gates protect everyone |
| Direct production DB access | Use approved tooling with audit trail |
| Modifying another project's code without PR | Project autonomy |
| Deploying without rollback plan | Irreversible risk |
| Sharing on-call credentials | Individual accountability |
| Using personal accounts for production | Accountability & audit trail |

---

## 📝 Exception Process

Se operação requer desvio desta governança:

1. **Document** a exceção com justificativa business
2. **Assess** risco e mitigação
3. **Obtain** aprovação de todos papéis requeridos
4. **Time-bound** a exceção (máx 30 dias)
5. **Track** no exception register
6. **Review** na próxima reunião de governança

---

## 📝 Governance Review Cadence

| Review | Frequency | Participants |
|--------|-----------|--------------|
| Policy Review | Semi-annual | All roles |
| Permission Audit | Quarterly | Security + Platform |
| Exception Register Review | Monthly | Tech Lead + Security |
| Incident Retrospective | Post-SEV1/2 | All involved |
| Architecture Review | Quarterly | Tech Leads + Architects |

---

*Este documento de governança é vinculante para todos agentes e humanos operando no ecossistema Agentic Home. Exceções requerem aprovação documentada conforme Exception Process.*