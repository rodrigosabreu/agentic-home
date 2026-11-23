# Template AI-DLC State (aidlc-state.md)

Este template define a estrutura padrão do arquivo `aidlc-state.md` para rastreamento do estado de execução do AI-DLC.

---

## Template

```markdown
# AI-DLC State Tracking

## Project Information
- **Project**: <nome do projeto>
- **Project Description Source**: project-description.json
- **Project Type**: greenfield | brownfield | existing-ai-dlc
- **Project Type Source**: workspace scan | manual analysis
- **Scope**: feature | project | platform
- **Start Date**: <ISO 8601>
- **Question Id**: <intent-id>
- **State Version**: <número>
- **Active Agent**: <nome do agente> (ex: atlas, polaris, nexus, sentinel)
- **Worktree Path**: <caminho absoluto do projeto>
- **Bolt Refs**: 
- **Practices Affirmed Timestamp**: 
- **Baseline Commit**: <hash> (<mensagem curta>)

## Scope Configuration
- **Stages to Execute**: <lista separada por vírgula, ex: 0.1, 0.2, 0.3, 1.1, 1.2...>
- **Stages to Skip**: <lista, ex: 0.1, 0.2 (ideation - brownfield, já possui escopo definido)>
- **Depth**: Standard | Deep
- **Test Strategy**: Standard | Comprehensive
- **Review Override**: 
- **Guard Policy**: on | off
- **Sensors**: on | off
- **Learnings**: on | off
- **Summary Confirmation**: on | off
- **Plan Approval**: on | off
- **Collaborators**: on | off

## Workspace State
- **Project Root**: <caminho absoluto>
- **Languages**: <linguagens, ex: Python, TypeScript>
- **Frameworks**: <frameworks, ex: FastAPI, Next.js>
- **Build System**: <sistema, ex: pip/uv (backend), npm (frontend)>

## Execution Plan Summary
- **Total Stages**: <número>
- **Completed**: <número>
- **In Progress**: <número> (<descrição>)

## Runtime State
- **Revision Count**: <número>
- **Construction Checkpoints**: enabled | disabled
- **Construction Iteration**: unit-major | unit-minor | integration
- **Construction Execution**: serial | parallel

## Phase Progress
<!-- Status values: Pending, Active, Verified, Skipped -->

### INITIALIZATION PHASE
- [ ] workspace-scaffold — EXECUTE
- [ ] workspace-detection — EXECUTE
- [ ] state-init — EXECUTE

### IDEATION PHASE
- [ ] intent-capture — EXECUTE
- [ ] market-research — EXECUTE
- [ ] feasibility — EXECUTE
- [ ] scope-definition — EXECUTE
- [ ] team-formation — EXECUTE
- [ ] rough-mockups — EXECUTE
- [ ] approval-handoff — EXECUTE

### INCEPTION PHASE
- [ ] reverse-engineering — EXECUTE
- [ ] requirements-analysis — EXECUTE
- [ ] domain-design — EXECUTE
- [ ] contract-design — EXECUTE
- [ ] delivery-planning — EXECUTE
- [ ] approval-handoff — EXECUTE

### CONSTRUCTION PHASE
- [ ] functional-design — EXECUTE
- [ ] code-generation — EXECUTE
- [ ] build-and-test — EXECUTE
- [ ] ci-pipeline — EXECUTE
- [ ] quality-gates — EXECUTE

### OPERATION PHASE
- [ ] deployment-pipeline — EXECUTE
- [ ] environment-provisioning — EXECUTE
- [ ] deployment-execution — EXECUTE
- [ ] observability-setup — EXECUTE
- [ ] incident-response — EXECUTE
- [ ] performance-validation — EXECUTE
- [ ] feedback-optimization — EXECUTE

## Current Status
- **Lifecycle Phase**: INITIALIZATION | IDEATION | INCEPTION | CONSTRUCTION | OPERATION
- **Current Stage**: <stage-name> (<descrição>)
- **Next Stage**: <stage-name>
- **Status**: <status description>
- **Last Updated**: <ISO 8601>

## Baseline Registration (Phase 3)
- **Baseline Commit**: <hash> (<mensagem>)
- **Git Status**: Clean | Dirty (<detalhes>)
- **Baseline Captured**: <ISO 8601>
- **Baseline Artifacts**: <lista de artefatos capturados>

## Session Resume Point
- **Last Completed Stage**: <stage-name>
- **Next Action**: <próxima ação concreta e executável>
- **Pending Artifacts**: <artefatos pendentes>
```

---

## Convenções de Status de Stage

| Símbolo | Significado |
|---------|-------------|
| `[ ]` | Not started |
| `[-]` | In progress |
| `[?]` | Awaiting approval (gate open) |
| `[R]` | Revising (user rejected gate) |
| `[x]` | Completed |
| `[S]` | Skipped |

## Convenções de Fase

| Fase | Prefixo Stage | Descrição |
|------|---------------|-----------|
| Initialization | 0.1, 0.2, 0.3 | Setup inicial do workspace |
| Ideation | 0.1-0.7 | Ideaçāo (pulável em brownfield) |
| Inception | 1.1-1.7 | Concepção: reverse-engineering → approval-handoff |
| Construction | 2.1-2.10 | Construção: functional-design → quality-gates |
| Operation | 3.1-3.7 | Operação: deployment → feedback-optimization |

## Exemplo de Uso

```markdown
# AI-DLC State Tracking

## Project Information
- **Project**: Meu Projeto
- **Project Description Source**: project-description.json
- **Project Type**: brownfield
- **Project Type Source**: workspace scan + manual analysis
- **Scope**: feature
- **Start Date**: 2026-11-23T10:00:00Z
- **Question Id**: 261123-meu-projeto-stabilize
- **State Version**: 1
- **Active Agent**: atlas (Tech Lead)
- **Worktree Path**: /opt/data/projects/meu-projeto
- **Baseline Commit**: abc1234 (docs: adiciona AI-DLC)

## Scope Configuration
- **Stages to Execute**: 0.1, 0.2, 0.3, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6, 1.7, 2.1, 2.2, 2.3, 2.4, 2.5, 2.6, 2.7, 2.8, 2.9, 2.10
- **Stages to Skip**: 0.1, 0.2 (ideation - brownfield, já possui escopo definido)
- **Depth**: Standard
- **Test Strategy**: Standard
- **Review Override**: 
- **Guard Policy**: on
- **Sensors**: on
- **Learnings**: on
- **Summary Confirmation**: on
- **Plan Approval**: on
- **Collaborators**: off

## Current Status
- **Lifecycle Phase**: INCEPTION
- **Current Stage**: reverse-engineering (baseline registration)
- **Next Stage**: requirements-analysis
- **Status**: Baseline registration in progress
- **Last Updated**: 2026-11-23T10:00:00Z
```