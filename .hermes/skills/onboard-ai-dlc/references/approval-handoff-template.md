# Template Approval Handoff (approval-handoff/memory.md)

Este template define a estrutura do arquivo `memory.md` para o stage `approval-handoff` — gate de aprovação humana entre fases.

---

## Template

```markdown
# Approval Handoff — Memory

> **Stage**: approval-handoff | **Phase**: <fase> | **Intent**: <intent-id>
> **Date**: <YYYY-MM-DD> | **Agent**: <agent-name>
> **Gate**: <fase origem> → <fase destino>

---

## Gate Status
- **Stage**: approval-handoff (<fase> phase)
- **Status**: **[?] AWAITING_HUMAN_APPROVAL**
- **Date**: <YYYY-MM-DD>
- **Approver**: <nome do aprovador> (<papel>)
- **Decision**: Pending

---

## Approval Request

### O que está sendo aprovado
<Descrição clara do que está sendo aprovado: transição de fase, ADRs, plano de entrega, etc.>

### O que foi completado na fase atual
1. ✅ <item completado 1>
2. ✅ <item completado 2>
3. ✅ <item completado 3>

### Artefatos Produzidos (Evidências)
| Artefato | Localização | Status |
|----------|-------------|--------|
| <nome> | <caminho> | ✅ |

---

## Decisões que Requerem Aprovação

### 1. <Título da Decisão 1>
**Decisão**: <descrição da decisão>

**Alternativas Consideradas**:
- <alternativa 1>: <prós/contras>
- <alternativa 2>: <prós/contras>

**Impactos**:
- <impacto 1>
- <impacto 2>

### 2. <Título da Decisão 2>
**Decisão**: <descrição da decisão>

**Alternativas Consideradas**:
- <alternativa 1>: <prós/contras>
- <alternativa 2>: <prós/contras>

**Impactos**:
- <impacto 1>
- <impacto 2>

---

## Riscos e Mitigações (Para Aprovação)

| Risco | Probabilidade | Impacto | Mitigação Proposta |
|-------|---------------|---------|-------------------|
| <risco> | <prob> | <impacto> | <mitigação> |

---

## Perguntas para Aprovação

1. **APROVA** <decisão 1>?
2. **APROVA** <decisão 2>?
3. **APROVA** prosseguir para <próxima fase>?

---

## Approval Record

| Field | Value |
|-------|-------|
| **Stage** | <fase>/approval-handoff |
| **Date** | YYYY-MM-DD |
| **Approver** | <nome do aprovador> |
| **Decision** | [ ] Approved  [ ] Rejected  [ ] Conditional |
| **Conditions** | _______________________________________________ |
| **Signature** | _______________________________________________ |

---

## Next Actions (Se Aprovado)

1. <próxima ação 1>
2. <próxima ação 2>

---

## Conditions (Se Conditional)

| Condição | Responsável | Prazo |
|----------|-------------|-------|
| | | |

---

*Approval handoff documentado. Aguardando decisão humana para prosseguir.*
```