---
name: desenvolvimento
description: "Implementação seguindo requisitos aprovados, padrões do projeto, criação de testes, documentação de mudanças, controle de escopo"
version: "1.0.0"
category: desenvolvimento
---

# Skill Desenvolvimento — Implementação & Entrega

> **Objetivo**: Implementar requisitos aprovados seguindo padrões do projeto, criar testes apropriados, documentar mudanças e manter disciplina de escopo.

---

## 🎯 Quando Usar

- Após Arquitetura produzir design aprovado & ADRs
- Implementando novas features, bug fixes, refactoring
- Qualquer mudança de código que afete comportamento ou contratos
- Trabalhando dentro de padrões estabelecidos do projeto

---

## 💻 Processo

### 1. Entender o Contexto
- Ler o `AGENTS.md` do projeto completamente
- Revisar ADRs relevantes para contexto
- Entender requisitos da feature (da Descoberta)
- Entender design técnico (da Arquitetura)
- Verificar padrões de código existentes no codebase

### 2. Planejar a Implementação
- Dividir trabalho em commits pequenos e incrementais
- Identificar pontos de toque (arquivos, serviços, bancos)
- Planejar estratégia de testes (unit, integração, contract, e2e)
- Identificar necessidades de migração (schema, config, dados)
- Estimar esforço e identificar riscos

### 3. Implementar Seguindo Padrões
- **Seguir estilo de código existente** (linting, formatação, naming)
- **Usar padrões existentes** (DI, error handling, logging, config)
- **Respeitar limites arquiteturais** (domain/application/infrastructure)
- **Seguir práticas de segurança** (sem segredos, validação de input, menor privilégio)
- **Considerar observabilidade** (logs, métricas, traces desde o dia um)

### 4. Criar Testes
| Tipo de Teste | Quando | Cobertura Alvo |
|---------------|--------|----------------|
| **Unit** | Toda função/classe com lógica | ≥ 80% |
| **Integração** | Interações serviço, DB, APIs externas | Caminhos críticos |
| **Contract** | Consumer/provider contracts (Pact) | Todas APIs públicas |
| **E2E** | Jornadas críticas do usuário | Caminho feliz + 1 caso crítico |

### 4. Documentar Mudanças
- Atualizar documentação relevante (README, API docs, ADRs se arquitetural)
- Adicionar/atualizar comentários de código para lógica complexa
- Atualizar CHANGELOG ou release notes
- Documentar nova configuração ou passos de migração

### 5. Controle de Escopo
- **NÃO** adicionar features não nos requisitos
- **NÃO** refatorar código não relacionado
- **NÃO** introduzir novas dependências sem justificativa
- **NÃO** pular testes para ir mais rápido
- **SIM** levantar mudanças de escopo como decisões explícitas

---

## 📋 Artefatos de Saída

| Artefato | Finalidade |
|----------|------------|
| **Code Changes** | Implementação em PRs pequenos e revisáveis |
| **Testes** | Unit, integração, contract, e2e conforme apropriado |
| **Documentação** | Docs atualizadas, API specs, comentários |
| **Migration Scripts** | DB schema, config, migrações de dados |
| **CHANGELOG Entry** | Resumo de mudanças para release |

---

## 🛠️ Ferramentas & Práticas

| Prática | Ferramenta/Método |
|----------|-------------------|
| **Code Style** | Linter/formatter do projeto (ruff, black, gofmt, prettier, etc.) |
| **Type Safety** | Type hints (Python), strict mode (TS), generics (Java/Go) |
| **Testing** | pytest, JUnit, Jest, Go test, etc. |
| **Contract Testing** | Pact (consumer-driven contracts) |
| **Static Analysis** | SonarQube, SpotBugs, ESLint, golangci-lint |
| **Security** | SAST/SCA no CI, dependency scanning |
| **Git Hygiene** | Conventional commits, PRs pequenos, mensagens descritivas |

---

## ✅ Quality Gates

Antes de considerar trabalho completo:
- [ ] Todos testes passam (unit, integração, contract)
- [ ] Cobertura de código atende threshold do projeto (≥ 80%)
- [ ] Linting/formatação passam
- [ ] Static analysis passa (zero novos issues high/critical)
- [ ] Security scans passam (SAST, SCA, secrets)
- [ ] Documentação atualizada
- [ ] CHANGELOG atualizado
- [ ] Sem scope creep (apenas requisitos aprovados implementados)
- [ ] Migration testada (se aplicável)
- [ ] Observabilidade verificada (logs, métricas, traces)

---

## 🔗 Skills Relacionadas

- **Descoberta** → Fornece requisitos & critérios de aceite
- **Arquitetura** → Fornece design & ADRs
- **Qualidade** → Valida implementação contra critérios

---

## 📋 Convenção de Commit Messages

Siga **Conventional Commits**:

```
<type>(<scope>): <description>

[optional body]

[optional footer]
```

**Tipos**: `feat`, `fix`, `refactor`, `test`, `docs`, `chore`, `perf`, `security`

**Exemplos**:
```
feat(auth): add JWT token refresh endpoint
fix(payment): handle idempotency key collision
refactor(order): extract pricing calculation service
test(payment): add contract tests for refund API
docs(api): update OpenAPI spec for v2 endpoints
```

---

## ⚠️ Anti-Padrões a Evitar

| Anti-Padrão | Por Que Danoso | Abordagem Correta |
|-------------|----------------|-------------------|
| **PRs grandes** | Difícil revisar, alto risco | PRs pequenos, focados (< 400 linhas) |
| **Pular testes** | Risco de regressão | Testes obrigatórios para toda mudança |
| **Scope creep** | Atrasos, features não testadas | Aderência estrita ao escopo |
| **Ignorar padrões** | Código inconsistente | Seguir padrões existentes do projeto |
| **Sem documentação** | Perda de conhecimento | Atualizar docs com cada mudança |
| **Refatoração grande em PR de feature** | Alto risco, difícil revisar | PRs de refatoração separados |

---

## 📋 Checklist para Agentes

Quando invocado para desenvolvimento:
- [ ] Ler `AGENTS.md` do projeto completamente
- [ ] Revisar ADRs relevantes
- [ ] Entender requisitos & critérios de aceite
- [ ] Revisar ADRs de Arquitetura para contexto
- [ ] Planejar implementação em passos pequenos
- [ ] Implementar seguindo padrões do projeto
- [ ] Escrever testes (unit + integração + contract conforme necessário)
- [ ] Rodar suite de testes completa localmente
- [ ] Rodar linting, formatação, static analysis
- [ ] Atualizar documentação
- [ ] Criar PR pequeno e focado
- [ ] Garantir CI passa
- [ ] Atualizar CHANGELOG

---

## 📋 Convenção de Commit Messages

Siga **Conventional Commits**:

```
<type>(<scope>): <description>

[optional body]

[optional footer]
```

**Tipos**: `feat`, `fix`, `refactor`, `test`, `docs`, `chore`, `perf`, `security`

**Exemplos**:
```
feat(auth): add JWT token refresh endpoint
fix(payment): handle idempotency key collision
refactor(order): extract pricing calculation service
test(payment): add contract tests for refund API
docs(api): update OpenAPI spec for v2 endpoints
```

---

## ⚠️ Anti-Padrões a Evitar

| Anti-Padrão | Por Que Danoso | Abordagem Correta |
|-------------|----------------|-------------------|
| **PRs grandes** | Difícil revisar, alto risco | PRs pequenos, focados (< 400 linhas) |
| **Pular testes** | Risco de regressão | Testes obrigatórios para toda mudança |
| **Scope creep** | Atrasos, features não testadas | Aderência estrita ao escopo |
| **Ignorar padrões** | Código inconsistente | Seguir padrões existentes do projeto |
| **Sem documentação** | Perda de conhecimento | Atualizar docs com cada mudança |
| **Refatoração grande em PR de feature** | Alto risco, difícil revisar | PRs de refatoração separados |

---

## 📋 Checklist para Agentes

Quando invocado para desenvolvimento:
- [ ] Ler `AGENTS.md` do projeto completamente
- [ ] Revisar ADRs relevantes
- [ ] Entender requisitos & critérios de aceite
- [ ] Revisar ADRs de Arquitetura para contexto
- [ ] Planejar implementação em passos pequenos
- [ ] Implementar seguindo padrões do projeto
- [ ] Escrever testes (unit + integração + contract conforme necessário)
- [ ] Rodar suite de testes completa localmente
- [ ] Rodar linting, formatação, static analysis
- [ ] Atualizar documentação
- [ ] Criar PR pequeno e focado
- [ ] Garantir CI passa
- [ ] Atualizar CHANGELOG

---

*Esta skill é reutilizável em todos os projetos. Carregue com `skill_view(name='desenvolvimento')` no Hermes.*