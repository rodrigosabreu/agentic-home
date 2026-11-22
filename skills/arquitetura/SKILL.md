---
name: arquitetura
description: "Design técnico, análise de trade-offs, identificação de dependências, registro de decisões arquiteturais (ADRs), identificação de riscos técnicos"
version: "1.0.0"
category: arquitetura
---

# Skill Arquitetura — Design Técnico & Trade-offs

> **Objetivo**: Transformar requisitos descobertos em designs técnicos, analisar trade-offs, identificar dependências, registrar decisões arquiteturais (ADRs) e identificar riscos técnicos.

---

## 🎯 Quando Usar

- Após Descoberta produzir requisitos claros & critérios de aceite
- Antes de iniciar qualquer implementação significativa
- Ao enfrentar trade-offs técnicos (consistência vs disponibilidade, build vs buy)
- Ao introduzir novas tecnologias ou padrões
- Ao refatorar ou modernizar sistemas existentes
- Quando restrições de compliance/regulatório afetam arquitetura

---

## 🏗️ Processo

### 1. Analisar Requisitos
- Revisar output da Descoberta (requisitos, cenários, critérios de aceite)
- Identificar restrições técnicas (latência, throughput, consistência, compliance)
- Mapear requisitos funcionais para capacidades do sistema
- Identificar requisitos não-funcionais (NFRs) como drivers arquiteturais

### 2. Identificar Dependências
- **Internas**: Outros serviços, libs compartilhadas, bancos, message queues
- **Externas**: APIs terceiras, vendors, sistemas regulatórios
- **Infraestrutura**: Cloud provider, Kubernetes, message brokers, observabilidade stack
- **Time**: Limites de ownership, dependências cross-team

### 3. Avaliar Alternativas
Para cada decisão-chave:
- **Opção A**: Descrição, prós, contras, custo, risco
- **Opção B**: Descrição, prós, contras, custo, risco
- **Opção C**: Descrição, prós, contras, custo, risco
- **Recomendação**: Opção escolhida com justificativa

### 4. Registrar Decisões (ADRs)
Use o template ADR (`templates/adr.md`):
- **Status**: Proposto | Aceito | Substituído
- **Contexto**: Problema, restrições, suposições
- **Decisão**: O que foi decidido
- **Alternativas**: O que foi considerado e rejeitado
- **Consequências**: Positivas, negativas, riscos, mitigação
- **Compliance**: Impacto regulatório
- **AI-DLC Impact**: Eval gates, pipeline, observabilidade

### 5. Identificar Riscos Técnicos
| Risco | Probabilidade | Impacto | Mitigação | Dono |
|-------|---------------|---------|-----------|------|
| <Descrição> | Alta/Med/Baixa | Alta/Med/Baixa | <Mitigação> | @dono |

---

## 📋 Artefatos de Saída

| Artefato | Finalidade |
|----------|------------|
| **Diagrama de Arquitetura** | Visão sistêmica (modelo C4 recomendado) |
| **Component Design** | Limites de serviços, APIs, fluxos de dados |
| **ADRs** | Decisões arquiteturais registradas |
| **Risk Register** | Riscos técnicos com mitigações |
| **NFR Matrix** | Mapeamento de requisitos não-funcionais |
| **Dependency Graph** | Dependências serviço/dados/infra |

---

## 🛠️ Ferramentas & Frameworks

| Ferramenta | Finalidade |
|------------|------------|
| **Modelo C4** | Context, Container, Component, Code diagrams |
| **ADR Template** | `templates/adr.md` |
| **Trade-off Matrix** | Comparação estruturada de alternativas |
| **Threat Modeling** | STRIDE ou similar para segurança |
| **NFR Matrix** | Mapear NFRs para decisões arquiteturais |

---

## ✅ Quality Gates

Antes de ir para Desenvolvimento:
- [ ] Todos requisitos funcionais mapeados para componentes
- [ ] Todos NFRs endereçados na arquitetura
- [ ] Decisões-chave registradas como ADRs
- [ ] Dependências identificadas e com dono
- [ ] Riscos técnicos registrados com mitigações
- [ ] Diagramas de arquitetura criados (Context + Container mínimo)
- [ ] Requisitos de compliance mapeados para arquitetura
- [ ] Impacto AI-DLC assessado (eval gates, pipeline, observabilidade)
- [ ] Revisão com stakeholders concluída

---

## 🔗 Skills Relacionadas

- **Descoberta** → Fornece requisitos & critérios de aceite
- **Desenvolvimento** → Implementa a arquitetura
- **Qualidade** → Valida arquitetura através de testes & reviews

---

## 📋 Template ADR Referência

```markdown
# ADR-<number>: <Title>

## Status
[Proposto | Aceito | Substituído]

## Contexto
Qual o problema? Quais as restrições?

## Decisão
O que foi decidido.

## Alternativas Consideradas

| Opção | Descrição | Prós | Contras | Decisão |
|--------|-----------|------|---------|----------|
| 1. | | | | |
| 2. | | | | |
| 3. | | | | |

## Consequências

### Positivas
- 

### Negativas
- 

### Riscos
- 

### Mitigações
- 

## Impacto de Compliance
- [ ] Regulatório financeiro (CVM, Bacen, etc.)
- [ ] LGPD (Lei 13.709)
- [ ] SOX (Lei 11.941/2009)
- [ ] PCI-DSS
- [ ] ANBIMA
- [ ] CMN 4.658
- [ ] Outro: ___________

## Impacto AI-DLC
- **Eval gates afetados**: 
- **Pipeline changes**: 
- **Observabilidade needs**: 
- **Model routing changes**: 
- **Cost impact**: 

## Implementation Notes
- 

## References
- [Link to issue/PR]
- [Link to documentation]
- [Link to related ADR]

---

## History
| Date | Version | Author | Change |
|------|---------|--------|--------|
| YYYY-MM-DD | 1.0 | <author> | Initial proposal |
| YYYY-MM-DD | 1.1 | <author> | <change description> |

---

## Approval
| Role | Name | Date | Signature |
|------|------|------|-----------|
| Author | | | |
| Reviewer | | | |
| Approver | | | |
```

---

## ⚠️ Anti-Padrões a Evitar

| Anti-Padrão | Por Que Danoso | Abordagem Correta |
|-------------|----------------|-------------------|
| **Sem ADRs** | Decisões perdidas, não revisáveis | Toda decisão significativa = ADR |
| **Over-engineering** | Complexidade sem valor | Comece simples, evolua com evidência |
| **Ignorar NFRs** | Latência, consistência, compliance ignorados | NFRs como drivers de primeira classe |
| **Sem análise de trade-off** | Única opção considerada | Sempre avaliar ≥2 alternativas |
| **Ignorar compliance** | Violações regulatórias | Compliance como restrição de primeira classe |
| **Ignorar AI-DLC** | Eval gates, observabilidade não planejados | Arquitetura inclui necessidades AI-DLC |

---

## 📋 Checklist para Agentes

Quando invocado para arquitetura:
- [ ] Ler output da Descoberta completamente
- [ ] Identificar todos NFRs como drivers arquiteturais
- [ ] Mapear requisitos funcionais para componentes
- [ ] Identificar todas dependências (internas/externas)
- [ ] Criar diagramas Context + Container (C4)
- [ ] Para cada decisão-chave: escrever ADR
- [ ] Identificar riscos técnicos com mitigações
- [ ] Mapear requisitos de compliance para arquitetura
- [ ] Assessar impacto AI-DLC (eval gates, pipeline, observabilidade)
- [ ] Revisar com stakeholders
- [ ] Produzir artefatos de arquitetura
- [ ] Handoff para Desenvolvimento com artefatos claros

---

*Esta skill é reutilizável em todos os projetos. Carregue com `skill_view(name='arquitetura')` no Hermes.*