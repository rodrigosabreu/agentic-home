# Agentic Home — Hub Central para Engenharia de Agentes de IA

> **Hub central para engenharia de agentes de IA. Catálogo de projetos, skills compartilhadas, governança, handoffs, templates e onboarding.**

---

## 🎯 Visão Geral

| Aspecto | Detalhes |
|--------|---------|
| **Domínio** | Engenharia de agentes de IA |
| **Stack** | **Tech-agnostic** — Java, Go, Python, Node, .NET, Polyglot |
| **Arquitetura** | Hexagonal + Event Sourcing + CQRS + Saga/Outbox |
| **AI-DLC** | Golden sets, Red teaming, Drift detection, Auto-retrain, Cost tracking |
| **Deploy** | Canary (segmentado) → Blue-Green → Rollout progressivo |

---

## 🏗️ Arquitetura (Tech-Agnostic)

```
domain/                    # 🎯 Núcleo puro (zero deps externas)
  ├── model/               # Entidades, Value Objects, Aggregates
  ├── service/             # Domain Services (lógica de negócio pura)
  ├── event/               # Domain Events
  ├── exception/
  └── repository/          # Repository Interfaces (Ports)

application/               # 🔄 Casos de uso
  ├── command/             # Commands (write)
  ├── query/               # Queries (read)
  ├── saga/                # Transações distribuídas
  └── event/

infrastructure/            # 🔌 Adapters (detalhes de impl)
  ├── persistence/         # Postgres, EventStore, Mongo, Redis
  ├── messaging/           # Kafka, RabbitMQ, NATS
  ├── external/            # APIs terceiras
  ├── marketdata/          # Provedores de dados de mercado
  ├── riskmodels/          # Python/R/QuantLib adapters
  └── security/            # Vault, KMS, Anonymizer

interfaces/                # 🌐 Entry Points
  ├── rest/                # REST API (OpenAPI 3.1)
  ├── grpc/                # gRPC (high-perf internal)
  ├── graphql/             # GraphQL (flexible queries)
  └── jobs/                # Scheduled (rebalance, pricing, etc.)
```

---

## ⚙️ Pipeline Harness (6 Stages)

| Stage | Gates | Tempo | Tech-Agnostic |
|-------|-------|-------|---------------|
| **1. Code Quality & Security** | Detect stack → Quality gates por linguagem → SAST/SCA/Secrets/OPA | ~5min | ✅ Auto-detect Java/Go/Python/Node/.NET |
| **2. AI Evaluation** | Golden sets (RAGAS+Investment), Red teaming, Pricing accuracy, Suitability, Chaos, Pact | ~10min | ✅ Language-specific test runners |
| **3. Build & Scan** | Multi-stage Docker → Distroless → SBOM → Cosign → Container scan | ~5min | ✅ Multi-stage Dockerfile auto-detect |
| **4. Deploy Staging** | Canary 5% (internal/advisors) → Smoke + Suitability + Pricing + Compliance → Progressive 25/50/100% | ~15min | ✅ K8s native |
| **5. Deploy Production** | 3 approvals (Tech/Compliance/Risk) → Blue-Green → Canary 1% → Progressive 5/25/100% → 30min monitoring | ~30min | ✅ K8s native |
| **6. Feedback Loop** | Metrics 24h → Drift (embeddings + pricing models) → Cost/portfolio → Feedback → Auto-retrain | Contínuo | ✅ Polyglot scripts |

---

## 🤖 Model Routing (Investment Tasks)

| Task Type | Models | Constraints |
|-----------|--------|-------------|
| **Portfolio Construction** | GPT-4o, Claude-3.5-Sonnet | Risk budgeting, CVM/ANBIMA compliance |
| **Suitability Assessment** | GPT-4o, Claude-3.5-Sonnet | Cite regulations, zero hallucination |
| **Pricing Analytics** | GPT-4o, Local Quant Model | ≤ 1 bp precision, air-gapped for pricing |
| **Risk Analytics** | Claude-3.5-Sonnet, Local Risk Model | VaR accuracy, stress test coverage |
| **Sensitive Data** | Local Llama-3.1-70B, Mistral-Large | Air-gapped, audit log, PII only |
| **Compliance Validation** | GPT-4o, Claude-3.5-Sonnet | Cite regulations, zero hallucination |

---

## 🔒 Compliance Gates (OPA/Rego)

| Regulation | Critical Policies |
|------------|-------------------|
| **CVM 558** | Suitability obrigatório, perfil × produto, termo assinado |
| **CVM 175** | Alavancagem, concentração ≤ 20%, liquidez, performance fee com hurdle |
| **ANBIMA** | TWR obrigatório, rebalancing policy, código de administração |
| **Bacen/AML** | KYC completo, screening > R$ 100k, liquidação D+0/D+1/D+2 |
| **LGPD** | Base legal, consentimento sensível, zero PII em logs |
| **SUSEP** | Previdência (VGBL/PGBL) - regras específicas |

---

## 🧪 Eval Gates (Thresholds)

| Métrica | Threshold | Bloqueador |
|---------|-----------|------------|
| Suitability Accuracy | 1.0 (100%) | ✅ |
| Pricing Accuracy | ≤ 1 bp | ✅ |
| TWR Calculation | 1.0 (100%) | ✅ |
| Risk Metrics (VaR, Stress) | ≥ 0.999 | ✅ |
| Suitability Violation Rate | 0% | ✅ |
| AML/KYC Compliance | 1.0 | ✅ |
| Settlement Accuracy | 1.0 | ✅ |
| Corporate Actions | 1.0 | ✅ |
| Rebalancing Deviation | ≤ 50 bps | ✅ |
| Cost per Portfolio/Day | ≤ $0.01 | ⚠️ |
| Model Drift (Wasserstein) | < 0.01 | ⚠️ |
| Rollback Time | < 30s | ✅ |

---

### 🚀 Quick Start

```bash
# 1. Ver skill
skill_view(name='agentic-home')

# 2. Ver pipeline template
skill_view(name='agentic-home', file_path='templates/harness-ci.yaml')

# 3. Ver compliance gates
skill_view(name='agentic-home', file_path='templates/compliance-gates.rego')

# 6. O agente vai:
#    - Detectar stack automaticamente (Java/Go/Python/Node/.NET)
#    - Aplicar quality gates por linguagem
#    - Rodar compliance gates OPA (CVM/ANBIMA/AML)
#    - Executar eval gates específicos
#    - Deploy canary segmentado (advisors → beta → retail)
#    - Feedback loop: drift + pricing model drift + suitability + cost → auto-retrain
```

---

### 📋 Checklist de Projeto Novo

- [ ] `git init` + `.gitignore` (polyglot: target/, build/, dist/, .venv/, node_modules/, bin/, obj/)
- [ ] Estrutura hexagonal (`domain/`, `application/`, `infrastructure/`, `interfaces/`)
- [ ] `policies/compliance-gates.rego` (compliance gates)
- [ ] `.harness/ci/harness-ci.yaml` (pipeline polyglot)
- [ ] `model-routing.yaml` (7 task types)
- [ ] `evals/` + golden sets + `thresholds.py`
- [ ] `scripts/` (drift_detection, model_drift, cost, retrain)
- [ ] `evals/thresholds.py` + golden sets
- [ ] Pipeline configurado + triggers
- [ ] Primeiro commit: `chore: bootstrap project with agentic-home`

---

### 📈 Métricas de Sucesso

| Métrica | Target | Criticidade |
|---------|--------|-------------|
| Suitability Violation Rate | 0% | Bloqueador |
| Pricing Accuracy | ≤ 1 bp | Bloqueador |
| TWR Calculation Accuracy | 100% | Bloqueador |
| Settlement Accuracy | 100% | Bloqueador |
| AML/KYC Compliance | 100% | Bloqueador |
| Rebalancing Deviation | ≤ 50 bps | Crítico |
| Latency P99 (Pricing) | < 100ms | Crítico |
| Latency P99 (Suitability) | < 500ms | Crítico |
| Cost per Portfolio/Day | < $0.01 | Importante |
| Model Drift (Wasserstein) | < 0.01 | Importante |
| Rollback Time | < 30s | Crítico |

---

*Skill versionada — atualize com nova regulamentação, novo produto, ou lição de produção.*