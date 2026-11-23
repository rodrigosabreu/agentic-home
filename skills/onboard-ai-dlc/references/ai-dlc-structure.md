# Estrutura Padrão do Workspace AI-DLC

Esta documentação define a estrutura padrão do workspace AI-DLC para projetos do ecossistema Agentic-Home.

---

## Estrutura de Diretórios

```
aidlc/
└── spaces/
    └── default/
        ├── intents/
        │   ├── intents.json                 # Índice de todos os intents
        │   └── <intent-id>/                 # Um diretório por intent
        │       ├── aidlc-state.md           # Estado de execução (fase, stage, next action)
        │       ├── project-description.json # Descrição canônica do projeto
        │       ├── ideation/                # Fase 0: Ideação
        │       │   ├── intent-capture/
        │       │   │   └── memory.md
        │       │   ├── scope-definition/
        │       │   │   └── memory.md
        │       │   └── approval-handoff/
        │       │       └── memory.md
        │       ├── inception/               # Fase 1: Concepção
        │       │   ├── reverse-engineering/
        │       │   │   └── memory.md
        │       │   ├── requirements-analysis/
        │       │   │   └── memory.md
        │       │   ├── domain-design/
        │       │   │   └── memory.md
        │       │   ├── contract-design/
        │       │   │   └── memory.md
        │       │   ├── delivery-planning/
        │       │   │   └── memory.md
        │       │   └── approval-handoff/
        │       │       └── memory.md
        │       ├── construction/            # Fase 2: Construção
        │       │   ├── functional-design/
        │       │   ├── code-generation/
        │       │   ├── build-and-test/
        │       │   ├── ci-pipeline/
        │       │   ├── quality-gates/
        │       │   └── ...
        │       └── audit/                   # Trilha de auditoria
        └── memory/
            ├── project.md                   # Memória do projeto (decisões, ADRs, contexto)
            └── phases/                      # Memória por fase (opcional)
                ├── ideation.md
                ├── inception.md
                ├── construction.md
                └── operation.md
```

---

## Descrição dos Componentes

### `intents.json`
Índice de todos os intents do workspace. Formato:
```json
{
  "intents": [
    {
      "id": "261122-contractai-stabilize",
      "name": "ContractAI Stabilization",
      "description": "Estabilizar e madurar o ContractAI através de governança AI-DLC",
      "projectRoot": "/opt/data/projects/contractai",
      "projectType": "brownfield",
      "scope": "feature",
      "startDate": "2026-11-22T23:50:00Z",
      "status": "inception",
      "activeStage": "reverse-engineering"
    }
  ]
}
```

### `aidlc-state.md`
Estado da execução do AI-DLC. Contém:
- Informações do projeto
- Configuração de escopo (stages, depth, test strategy)
- Progresso por fase e stage
- Status atual (fase, stage, next action)
- Baseline registration info
- Session resume point

### `project-description.json`
Descrição canônica do projeto (single source of truth). String JSON com descrição completa.

### `project.md`
Memória persistente do projeto:
- Contexto do projeto
- Decisões técnicas registradas (ADRs)
- Pendências e bloqueios
- Conflitos identificados
- Riscos residuais
- Métricas de baseline
- Próximas ações

### Stage Memories (`memory.md`)
Cada stage tem seu `memory.md` com:
- **Interpretations**: Decisões interpretativas
- **Deviations**: Desvios do plano original
- **Tradeoffs**: Tradeoffs decididos
- **Open questions**: Perguntas em aberto

### `intents.json`
Índice de todos os intents:
```json
{
  "intents": [
    {
      "id": "261122-contractai-stabilize",
      "name": "ContractAI Stabilization",
      "description": "Estabilizar e madurar o ContractAI através de governança AI-DLC",
      "projectRoot": "/opt/data/projects/contractai",
      "projectType": "brownfield",
      "scope": "feature",
      "startDate": "2026-11-22T23:50:00Z",
      "status": "inception"
    }
  ]
}
```

### `approval-handoff/memory.md`
Gate de aprovação humana entre fases:
- Stage gate status
- Approval request details
- Decisions requiring approval
- Risks and mitigations
- Approval record template

### `audit/`
Trilha de auditoria:
- Logs de execução
- Evidências de aprovações
- Logs de execução de stages

---

## Convenções de Nomenclatura

### Intent ID
Formato: `YYMMDD-<slug>`
Exemplo: `261122-contractai-stabilize`

### Stage Names (Padrão AI-DLC)
| Fase | Stages |
|------|--------|
| **Initialization** | workspace-scaffold, workspace-detection, state-init |
| **Ideation** | intent-capture, market-research, feasibility, scope-definition, team-formation, rough-mockups, approval-handoff |
| **Inception** | reverse-engineering, requirements-analysis, domain-design, contract-design, delivery-planning, approval-handoff |
| **Construction** | functional-design, code-generation, build-and-test, ci-pipeline, quality-gates |
| **Operation** | deployment-pipeline, environment-provisioning, deployment-execution, observability-setup, incident-response, performance-validation, feedback-optimization |

### Status de Stage
- `[ ]` — Not started
- `[-]` — In progress
- `[?]` — Awaiting approval (gate open)
- `[R]` — Revising (user rejected gate)
- `[x]` — Completed
- `[S]` — Skipped

---

## Integração com Agentic-Home

### Skills Carregamento
```bash
# Carregar skill
skill_view(name='onboard-ai-dlc')

# Skills relacionadas (carregar conforme necessário)
skill_view(name='descoberta')
skill_view(name='arquitetura')
skill_view(name='desenvolvimento')
skill_view(name='qualidade')
```

### Templates Referenciados
- `agentic-home/templates/handoff.md` — Base para handoff.md do projeto
- `agentic-home/templates/adr.md` — Base para ADRs (estendido com campos AI-DLC)

### Skills Carregamento
```bash
skill_view(name='descoberta')    # Para Diagnose
skill_view(name='arquitetura')   # Para Plan/Integrate
skill_view(name='desenvolvimento') # Para Integrate
skill_view(name='qualidade')     # Para Validate
```

---

## Padrões de Arquivos

### `aidlc-state.md` — Campos Obrigatórios
```markdown
# AI-DLC State Tracking

## Project Information
- **Project**: <nome>
- **Project Description Source**: project-description.json
- **Project Type**: greenfield | brownfield | existing-ai-dlc
- **Scope**: feature | project | platform
- **Start Date**: ISO 8601
- **Question Id**: <intent-id>
- **State Version**: <number>
- **Active Agent**: <agent-name>
- **Worktree Path**: <caminho>
- **Baseline Commit**: <hash> (<msg>)

## Scope Configuration
- **Stages to Execute**: <lista>
- **Stages to Skip**: <lista>
- **Depth**: Standard | Deep
- **Test Strategy**: Standard | Comprehensive
- **Guard Policy**: on | off
- **Sensors**: on | off
- **Learnings**: on | off
- **Summary Confirmation**: on | off
- **Plan Approval**: on | off
- **Collaborators**: on | off

## Phase Progress
- **Initialization**: Pending | Active | Verified
- **Ideation**: Pending | Active | Verified | Skipped
- **Inception**: Pending | Active | Verified
- **Construction**: Pending | Active | Verified
- **Operation**: Pending | Active | Verified

## Current Status
- **Lifecycle Phase**: INITIALIZATION | IDEATION | INCEPTION | CONSTRUCTION | OPERATION
- **Current Stage**: <stage-name>
- **Next Stage**: <stage-name>
- **Status**: <status>
- **Last Updated**: ISO 8601
```

### `project-description.json`
```json
"Descrição canônica do projeto em uma string JSON. Inclui: nome, propósito, stack, arquitetura, compliance, estado atual."
```

---

## Convenções de Commit

### Mensagens de Commit AI-DLC
```
docs: adiciona AI-DLC workspace ao projeto X
feat(ai-dlc): adiciona ADR-001 stack tecnológica
fix(ai-dlc): corrige aidlc-state.md fase atual
chore(ai-dlc): atualiza project.md com nova decisão
```

### Branches
- `feature/ai-dlc-<intent-id>-<descricao>`
- `fix/ai-dlc-<intent-id>-<descricao>`
- `chore/ai-dlc-<intent-id>-<descricao>`

---

## Checklist de Criação de Projeto AI-DLC

### Inicialização
- [ ] Criar estrutura `aidlc/` completa
- [ ] Criar `project-description.json`
- [ ] Criar `aidlc-state.md` inicial
- [ ] Criar `project.md` com contexto
- [ ] Criar `intents.json` com intent inicial
- [ ] Criar `handoff.md` inicial
- [ ] Atualizar `AGENTS.md` com seção AI-DLC
- [ ] Registrar no catálogo `agentic-home/projects/catalogo.md`

### Baseline (Brownfield)
- [ ] Capturar baseline commit
- [ ] Registrar decisões históricas como ADRs `Implemented`
- [ ] Documentar gaps e pendências
- [ ] Atualizar `aidlc-state.md` com baseline commit
- [ ] Atualizar `project.md` com decisões baseline

### Inception Phase
- [ ] Reverse-engineering memory.md
- [ ] Requirements-analysis memory.md
- [ ] Domain-design memory.md
- [ ] Contract-design memory.md
- [ ] Delivery-planning memory.md
- [ ] Approval-handoff memory.md (gate)

### Construction Phase
- [ ] Functional-design memory.md
- [ ] Code-generation memory.md
- [ ] Build-and-test memory.md
- [ ] CI-pipeline memory.md
- [ ] Quality-gates memory.md

### Operation Phase
- [ ] Deployment-pipeline memory.md
- [ ] Environment-provisioning memory.md
- [ ] Deployment-execution memory.md
- [ ] Observability-setup memory.md
- [ ] Incident-response memory.md
- [ ] Performance-validation memory.md
- [ ] Feedback-optimization memory.md