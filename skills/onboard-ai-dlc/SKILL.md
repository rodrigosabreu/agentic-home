---
name: onboard-ai-dlc
description: "Automatiza a integração do AI-DLC em projetos novos ou existentes, incluindo diagnóstico, planejamento, baseline, implementação e validação com stage gates e aprovação humana."
version: "1.0.0"
category: onboarding
---

# Skill Onboard AI-DLC — Integração Automatizada do AI-DLC em Projetos

> **Objetivo**: Automatizar a integração do AI-DLC em projetos novos (greenfield) ou existentes (brownfield), respeitando mecanismos de governança, memória persistente, auditoria, stage gates e aprovação humana. A skill suporta projetos greenfield, brownfield e projetos que já possuem AI-DLC.

---

## 🎯 Objetivo

Capacitar agentes a integrar o AI-DLC em projetos do ecossistema Agentic-Home de forma padronizada, respeitando:
- Governança compartilhada no Agentic-Home
- Estado, decisões e evidências específicos de cada projeto
- Stage gates com aprovação humana obrigatória
- Integração com skills, templates e governança do Agentic-Home
- Compatibilidade com projetos greenfield, brownfield e com AI-DLC existente

---

## 🎯 Quando Usar

- Iniciando AI-DLC em projeto greenfield (novo)
- Adicionando AI-DLC a projeto brownfield (existente)
- Validando/atualizando AI-DLC em projeto que já o possui
- Onboarding de novos projetos no ecossistema Agentic-Home
- Auditoria de conformidade AI-DLC em projetos existentes

---

## 📋 Pré-requisitos

Antes de executar a skill, o agente deve:
- Ter acesso ao repositório Agentic-Home (`/opt/data/projects/agentic-home`)
- Ter acesso ao projeto-alvo
- Ter lido o `AGENTS.md` do Agentic-Home e do projeto-alvo
- Ter identificado o tipo de projeto: greenfield, brownfield ou com AI-DLC existente
- Para brownfield: ter feito diagnóstico prévio (skill descoberta) se necessário

---

## 📋 Workflows

A skill possui 5 workflows sequenciais, cada um com entradas, saídas e validações:

```
┌─────────────┐    ┌─────────────┐    ┌─────────────┐    ┌─────────────┐    ┌─────────────┐
│  1. Diagnose │───▶│  2. Plan    │───▶│  3. Baseline │───▶│  4. Integrate │───▶│  5. Validate │
└─────────────┘    └─────────────┘    └─────────────┘    └─────────────┘    └─────────────┘
```

Cada workflow produz artefatos que alimentam o próximo. Nenhum workflow deve ser pulado.

---

## 📋 Workflow 1: Diagnose

### Objetivo
Analisar o projeto-alvo e identificar seu estado atual, arquitetura, decisões técnicas e mecanismos de governança.

### Entradas
- Caminho do projeto-alvo
- Tipo de projeto: greenfield | brownfield | existing-ai-dlc

### Processo
1. **Inspecionar estrutura do projeto**
   - Verificar existência de `AGENTS.md`, `README.md`, `.gitignore`
   - Identificar stack tecnológica (linguagens, frameworks, banco de dados)
   - Verificar se há `aidlc/` workspace existente

2. **Analisar arquitetura e decisões**
   - Ler `AGENTS.md` e `README.md` do projeto
   - Inspecionar estrutura de pastas (backend/, frontend/, docs/, etc.)
   - Identificar padrões arquiteturais (Clean Architecture, Hexagonal, etc.)
   - Listar tecnologias: linguagens, frameworks, bancos, ferramentas

3. **Identificar mecanismos de governança existentes**
   - Verificar se há `handoff.md`, ADRs, ADR templates
   - Verificar se há CI/CD configurado
   - Verificar testes (unit, integration, e2e)
   - Verificar documentação de arquitetura (diagramas, ADRs)

4. **Identificar mecanismos de memória/continuidade**
   - Verificar se há `handoff.md`, `PROGRESSO.md`, `CHANGELOG.md`
   - Verificar se há documentação de onboarding
   - Verificar se há ADRs ou decisões documentadas

5. **Classificar projeto**
   - **Greenfield**: Sem código, sem histórico, estrutura vazia
   - **Brownfield**: Código existente, sem AI-DLC
   - **Existing AI-DLC**: Já possui `aidlc/` workspace

### Saídas (Artefatos)
- `diagnose-report.md` — Relatório de diagnóstico com:
  - Classificação do projeto
  - Stack tecnológica identificada
  - Arquitetura e padrões identificados
  - Governança existente
  - Gaps em relação ao AI-DLC padrão
  - Riscos identificados
  - Recomendação de estratégia (greenfield/brownfield/existing)

### Critérios de Aceite
- [ ] Relatório completo gerado
- [ ] Classificação correta do projeto
- [ ] Stack tecnológica documentada
- [ ] Gaps em relação ao AI-DLC padrão identificados
- [ ] Riscos documentados

---

## 📋 Workflow 2: Plan

### Objetivo
Definir a estratégia de integração, arquivos necessários, riscos, critérios de aceite e plano de rollback.

### Entradas
- Relatório de diagnóstico (`diagnose-report.md`)
- Tipo de projeto confirmado

### Processo
1. **Definir estratégia de integração**
   - **Greenfield**: Criar estrutura AI-DLC completa do zero
   - **Brownfield**: Integrar AI-DLC preservando código/histórico existente
   - **Existing AI-DLC**: Validar/atualizar estrutura existente

3. **Definir arquivos a criar/modificar**
   - Lista de arquivos a criar (estrutura `aidlc/`, ADRs, handoff, etc.)
   - Lista de arquivos a modificar (`AGENTS.md`, `handoff.md`, `README.md`)
   - Arquivos a preservar (não modificar código funcional)

3. **Definir stage gates e aprovações**
   - Mapear gates necessários (Ideation→Inception, Inception→Construction, Construction→Operation)
   - Identificar aprovadores por gate
   - Definir critérios de aprovação por gate

4. **Definir critérios de aceite**
   - Critérios por fase (Diagnose, Plan, Baseline, Integrate, Validate)
   - Critérios de validação final (recuperação de contexto, stage gates, etc.)

5. **Definir plano de rollback**
   - Procedimento para reverter cada fase
   - Arquivos a restaurar
   - Comandos de rollback Git

6. **Identificar riscos e mitigações**
   - Riscos técnicos, de governança, de dados
   - Planos de mitigação
   - Plano de contingência

### Saídas (Artefatos)
- `integration-plan.md` — Plano de integração com:
  - Estratégia escolhida
  - Lista de arquivos a criar/modificar/preservar
  - Stage gates e aprovadores
  - Critérios de aceite por fase
  - Plano de rollback
  - Riscos e mitigações
  - Cronograma estimado

### Critérios de Aceite
- [ ] Plano completo e acionável
- [ ] Stage gates definidos com aprovadores
- [ ] Critérios de aceite mensuráveis
- [ ] Plano de rollback testável
- [ ] Riscos mapeados com mitigações

---

## 📋 Workflow 3: Baseline

### Objetivo
Preservar o histórico existente e registrar decisões comprovadas como baseline, sem inventar aprovações retroativas.

### Entradas
- Plano de integração (`integration-plan.md`)
- Projeto com código/histórico existente

### Processo
1. **Capturar baseline Git**
   - Identificar commit HEAD atual (`git rev-parse HEAD`)
   - Verificar status Git (`git status`)
   - Capturar branch atual
   - Registrar baseline commit no `aidlc-state.md`

2. **Registrar decisões históricas como baseline**
   - Para projetos brownfield: extrair decisões do código/histórico
   - Criar ADRs com status `Implemented` para decisões já implementadas
   - **Não atribuir aprovação retroativa** — marcar como baseline histórico
   - Documentar: "Decisão implementada em [data/commit], registrada como baseline"

3. **Registrar gaps e pendências**
   - Documentar gaps conhecidos (testes, CI/CD, docs, etc.)
   - Registrar como pendências para fases futuras
   - Não criar ADRs para decisões não tomadas

4. **Capturar baseline de métricas**
   - Cobertura de testes atual
   - Status de CI/CD
   - Métricas de qualidade atuais
   - Status de documentação

5. **Registrar baseline no `aidlc-state.md`**
   - `baseline-commit`: hash do commit
   - `baseline-captured`: timestamp
   - `baseline-artifacts`: lista de artefatos capturados

### Saídas (Artefatos)
- `baseline-report.md` — Relatório de baseline
- ADRs baseline criados/atualizados (status `Implemented`)
- `aidlc-state.md` atualizado com baseline commit
- `project.md` atualizado com decisões baseline

### Critérios de Aceite
- [ ] Baseline Git capturado corretamente
- [ ] ADRs históricos criados com status `Implemented`
- [ ] Nenhuma aprovação retroativa inventada
- [ ] Gaps e pendências documentados
- [ ] `aidlc-state.md` atualizado com baseline commit

---

## 📋 Workflow 4: Integrate

### Objetivo
Criar e configurar os componentes AI-DLC: estado, memória, auditoria, handoffs, stage gates, integração com AGENTS.md.

### Entradas
- Baseline report (`baseline-report.md`)
- Plano de integração (`integration-plan.md`)

### Processo
1. **Criar estrutura `aidlc/` workspace**
   ```
   aidlc/
   └── spaces/
       └── default/
           ├── intents/
           │   ├── intents.json
           │   └── <intent-id>/
           │       ├── aidlc-state.md
           │       ├── project-description.json
           │       ├── ideation/
           │       │   ├── intent-capture/
           │       │   ├── scope-definition/
           │       │   └── approval-handoff/
           │       ├── inception/
           │       │   ├── reverse-engineering/
           │       │   ├── requirements-analysis/
           │       │   ├── domain-design/
           │       │   ├── contract-design/
           │       │   ├── delivery-planning/
           │       │   └── approval-handoff/
           │       ├── construction/
           │       └── audit/
           └── memory/
               ├── project.md
               └── phases/
   ```

2. **Criar arquivos principais**
   - `project-description.json` — Descrição canônica do projeto
   - `aidlc-state.md` — Estado execução (fase, stage, next action)
   - `project.md` — Memória do projeto (decisões, ADRs, contexto)
   - `intents.json` — Índice de intents

3. **Criar stage memories (por fase/estágio)**
   - Para cada stage: criar `memory.md` com:
     - Observações, tradeoffs, desvios, perguntas abertas
     - Formato padronizado (Interpretations, Deviations, Tradeoffs, Open questions)

3. **Criar/atualizar ADRs**
   - Usar template AI-DLC (`agentic-home/templates/adr.md` estendido)
   - Incluir campos: Compliance Impact, AI-DLC Impact
   - Status: `Implemented` (baseline) ou `Proposed` (novas)

4. **Criar/atualizar handoff.md**
   - Usar template `agentic-home/templates/handoff.md` estendido
   - Adicionar campos AI-DLC: phase, stage, gate status, phase gate status
   - Preencher com task atual (ex: "Implantar AI-DLC")

4. **Atualizar AGENTS.md do projeto**
   - Adicionar seção AI-DLC Workspace
   - Referenciar `aidlc/`, skills, templates, stage gates
   - Instruções de recuperação de contexto
   - Referenciar templates Agentic-Home

5. **Configurar stage gates**
   - Criar `approval-handoff/memory.md` para gates
   - Definir gates obrigatórios com aprovadores
   - Template de aprovação com assinatura

5. **Configurar auditoria**
   - Criar diretório `audit/`
   - Documentar trilha de execução

### Saídas (Artefatos)
- Estrutura `aidlc/` completa
- `aidlc-state.md` inicializado
- `project-description.json` criado
- `project.md` com decisões/ADRs
- `intents.json` com intent registrado
- Stage memories criados
- ADRs criados/atualizados
- `handoff.md` criado/atualizado
- `AGENTS.md` atualizado
- Stage gates configurados

### Critérios de Aceite
- [ ] Estrutura `aidlc/` criada completa
- [ ] Todos arquivos principais criados
- [ ] ADRs criados/atualizados
- [ ] `handoff.md` e `AGENTS.md` atualizados
- [ ] Stage gates configurados
- [ ] Nenhum arquivo funcional do projeto modificado
- [ ] Idempotência: executar duas vezes não duplica arquivos

---

## 📋 Workflow 5: Validate

### Objetivo
Verificar a integridade da implantação, recuperação de contexto, funcionamento dos gates e idempotência.

### Entradas
- Todos os artefatos criados na integração

### Processo
1. **Teste de recuperação de contexto (Nova Sessão)**
   - Simular nova sessão: ler apenas artefatos persistidos
   - Verificar se consegue identificar:
     - Fase atual, stage atual, next action
     - Decisões/ADRs registradas
     - Bloqueios/pendências
     - Próxima ação executável

3. **Verificar integridade dos artefatos**
   - Todos arquivos AI-DLC existem e são válidos
   - `aidlc-state.md` consistente com `project.md`
   - ADRs têm status correto
   - `handoff.md` aponta para next action correta

3. **Testar stage gates**
   - Verificar se gates pendentes bloqueiam ações
   - Verificar se aprovações são registradas corretamente
   - Verificar se gates impedem ações não autorizadas

4. **Testar idempotência**
   - Executar workflow Integrate novamente
   - Verificar: nenhum arquivo duplicado, nenhum conteúdo alterado indevidamente
   - Estrutura `aidlc/` permanece idêntica

4. **Testar recuperação de contexto (Nova Sessão)**
   - Simular nova sessão sem histórico de conversa
   - Recuperar contexto apenas lendo artefatos
   - Verificar se identifica corretamente: fase, stage, next action, bloqueios

4. **Testar rollback**
   - Simular falha em Integrate
   - Executar procedimento de rollback
   - Verificar: estado anterior restaurado corretamente

5. **Verificar integração com Agentic-Home**
   - Skills carregáveis via `skill_view()`
   - Templates referenciam Home corretamente
   - Catálogo sincronizado

### Saídas (Artefatos)
- `validation-report.md` — Relatório de validação com:
  - Resultado de cada teste (PASS/FAIL)
  - Evidências de recuperação de contexto
  - Evidências de idempotência
  - Evidências de rollback
  - Gaps identificados
  - Status final: APROVADO / REPROVADO

### Critérios de Aceite
- [ ] Recuperação de contexto 100% funcional
- [ ] Idempotência comprovada (execução dupla idêntica)
- [ ] Rollback funcional
- [ ] Stage gates bloqueiam corretamente
- [ ] Integração Agentic-Home funcional
- [ ] Relatório de validação completo

---

## 🛠️ Templates e Referências

A skill utiliza os seguintes templates do Agentic-Home (não duplicar, referenciar):

| Template | Localização | Uso |
|----------|-------------|-----|
| Handoff Template | `agentic-home/templates/handoff.md` | Base para `handoff.md` do projeto |
| ADR Template | `agentic-home/templates/adr.md` | Base para ADRs (estendido com campos AI-DLC) |
| Skills | `agentic-home/skills/*` | Carregar via `skill_view()` |
| Governança | `agentic-home/docs/governanca.md` | Referenciar para stage gates |
| Onboarding | `agentic-home/docs/onboarding.md` | Referenciar para onboarding |

### Arquivos de Apoio (Criados pela Skill)
A skill pode criar arquivos de apoio em `references/` dentro da skill:
- `references/ai-dlc-structure.md` — Estrutura padrão do workspace AI-DLC
- `references/ai-dlc-state-template.md` — Template para `aidlc-state.md`
- `references/project-description-template.json` — Template para `project-description.json`
- `references/intent-capture-template.md` — Template para intent capture
- `references/approval-handoff-template.md` — Template para approval handoff

---

## 🧪 Testes da Skill

Antes de usar em projeto real, a skill deve passar pelos seguintes testes:

### 1. Validação Estrutural
- [ ] Skill segue padrão SKILL.md do Agentic-Home
- [ ] Frontmatter YAML válido
- [ ] Referências a templates/skills do Home corretas
- [ ] Frontmatter YAML válido (name, description, version, category)

### 2. Testes em Ambiente Temporário
- [ ] Criar projeto temporário greenfield
- [ ] Executar Diagnose → Plan → Baseline → Integrate → Validate
- [ ] Verificar todos artefatos criados
- [ ] Verificar nenhum arquivo funcional modificado

### 3. Testes em Projeto Brownfield (Fixture)
- [ ] Usar fixture de projeto brownfield (ex: crivo-credito-demo)
- [ ] Executar workflows completos
- [ ] Verificar preservação de código/histórico existente
- [ ] Verificar ADRs baseline criados corretamente

### 4. Teste de Idempotência
- [ ] Executar Integrate duas vezes consecutivas
- [ ] Verificar: nenhum arquivo duplicado
- [ ] Verificar: conteúdo idêntico
- [ ] Estrutura `aidlc/` idêntica

### 4. Testes de Rollback
- [ ] Simular falha em Integrate (interromper no meio)
- [ ] Executar rollback
- [ ] Verificar: estado anterior restaurado
- [ ] Verificar: arquivos criados removidos, modificados restaurados

### 5. Testes de Gates
- [ ] Verificar se gate pendente bloqueia avanço
- [ ] Verificar se aprovação registrada permite avanço
- [ ] Verificar se gate rejeitado bloqueia corretamente

### 5. Testes de Recuperação de Contexto
- [ ] Simular nova sessão (sem histórico)
- [ ] Recuperar contexto apenas dos artefatos
- [ ] Verificar: fase, stage, next action, bloqueios identificados corretamente

---

## 📦 Integração com Agentic-Home

### Registro no Catálogo
A skill deve ser registrada no catálogo de skills do Agentic-Home (se houver catálogo formal) ou disponibilizada em `skills/onboard-ai-dlc/`.

### Integração com Workflows Existentes
- **Diagnose** → usa **skill `descoberta`** para explorar problema, levantar requisitos, mapear cenários e definir critérios de aceite
- **Plan** → usa **skill `arquitetura`** para design técnico, trade-offs, ADRs, identificação de dependências e riscos técnicos
- **Baseline** → usa **skill `descoberta`** para levantamento histórico e **skill `arquitetura`** para registrar decisões técnicas como ADRs
- **Integrate** → usa **skill `arquitetura`** (design técnico), **skill `desenvolvimento`** (padrões de implementação, testes, CI/CD) e **skill `qualidade`** (validação, testes, revisão de código)
- **Validate** → usa **skill `qualidade`** para validação, testes, revisão de código, observabilidade

> **Como carregar**: `skill_view(name='descoberta')`, `skill_view(name='arquitetura')`, `skill_view(name='desenvolvimento')`, `skill_view(name='qualidade')` — carregue no início de cada workflow conforme necessário.

### Handoffs
A skill produz/consome handoffs no formato do Agentic-Home (template `handoff.md`).

### Skills Carregamento
```bash
# No Hermes Agent
skill_view(name='onboard-ai-dlc')  # Carrega esta skill
skill_view(name='descoberta')       # Para Diagnose
skill_view(name='arquitetura')      # Para Plan/Integrate
skill_view(name='desenvolvimento')  # Para Integrate
skill_view(name='qualidade')        # Para Validate
```

---

## 📋 Parâmetros de Execução

A skill aceita os seguintes parâmetros (passados via contexto ou CLI):

| Parâmetro | Tipo | Obrigatório | Descrição |
|-----------|------|-------------|-----------|
| `project_path` | string | Sim | Caminho absoluto do projeto-alvo |
| `project_type` | enum | Sim | `greenfield`, `brownfield`, `existing-ai-dlc` |
| `intent_id` | string | Não | ID do intent (auto-gerado se não informado) |
| `skip_diagnose` | boolean | Não | Pular Diagnose (para projetos com diagnóstico prévio) |
| `skip_plan` | boolean | Não | Pular Plan (para projetos com plano prévio) |
| `dry_run` | boolean | Não | Simular sem criar arquivos |
| `force` | boolean | Não | Forçar sobrescrita (cuidado!) |

### Exemplo de Invocação
```bash
# No Hermes Agent
skill_view(name='onboard-ai-dlc')
# Depois invocar com parâmetros:
# project_path: /opt/data/projects/crivo-credito-demo
# project_type: brownfield
```

---

## ⚠️ Limitações e Riscos Residuais

| Risco | Probabilidade | Impacto | Mitigação |
|-------|---------------|---------|-----------|
| Conflito AGENTS.md vs AI-DLC state | Média | Médio | Unificar referências na documentação |
| Templates ADR/handoff divergentes | Baixa | Baixo | Estender templates Home, não copiar |
| Stage gates não respeitados | Baixa | Alto | Validação automática em Validate |
| Perda de contexto entre sessões | Baixa | Alto | Teste de recuperação obrigatório em Validate |
| Dependências não aprovadas | Média | Bloqueador | Verificação em Plan/Integrate |
| Conflito de skills (namespace) | Baixa | Baixo | Namespace `agentic-home:` vs projeto |
| Perda de histórico Git | Baixa | Crítico | Rollback testado, Git history preservado |

---

## 📋 Checklist de Entrega da Skill

- [ ] Skill `onboard-ai-dlc` criada em `skills/onboard-ai-dlc/`
- [ ] `SKILL.md` com 5 workflows definidos
- [ ] Arquivos de referência criados em `references/`
- [ ] Testes de estrutura validados
- [ ] Testes em ambiente temporário executados
- [ ] Testes em fixture brownfield executados
- [ ] Idempotência comprovada (2 execuções idênticas)
- [ ] Rollback testado e funcional
- [ ] Gates de aprovação respeitados
- [ ] Integração com Agentic-Home validada
- [ ] Handoff persistente produzido
- [ ] Documentação de uso atualizada
- [ ] Registrada no catálogo de skills (se aplicável)

---

## 📋 Como Invocar a Skill no Hermes

```bash
# 1. Carregar a skill
skill_view(name='onboard-ai-dlc')

# 2. Invocar workflow desejado (ex: diagnose)
# Parâmetros passados via contexto:
# {
#   "project_path": "/opt/data/projects/meu-projeto",
#   "project_type": "brownfield",
#   "intent_id": "261122-meu-projeto-stabilize"
# }

# 3. A skill guiará pelos workflows sequenciais:
# diagnose → plan → baseline → integrate → validate

# 4. Em cada stage gate, aguardar aprovação humana registrada
```

---

## 📋 Próximos Passos para Adoção no Crivo Crédito

1. **Executar Diagnose** no `crivo-credito-demo`:
   ```bash
   skill_view(name='onboard-ai-dlc')
   # project_path: /opt/data/projects/crivo-credito-demo
   # project_type: brownfield
   ```

2. **Revisar Diagnose Report** — Confirmar classificação e gaps

3. **Executar Plan** — Revisar plano de integração proposto

4. **Aprovação Humana** — Aprovar Baseline e Plan

4. **Executar Baseline** — Registrar decisões históricas como baseline

5. **Executar Integrate** — Criar estrutura AI-DLC completa

5. **Executar Validate** — Validar recuperação, idempotência, rollback

6. **Gate Inception → Construction** — Aprovação humana para prosseguir

---

*Esta skill é reutilizável em todos os projetos do ecossistema Agentic-Home. Carregue com `skill_view(name='onboard-ai-dlc')` no Hermes.*