# Architecture Overview — Agentic Home

> **System architecture overview for the Agentic Home ecosystem.**

---

## 🏗️ High-Level Architecture

```
┌─────────────────────────────────────────────────────────────────┐
│                      AGENTIC HOME (This Repo)                   │
├─────────────────────────────────────────────────────────────────┤
│  ┌──────────────┐  ┌──────────────┐  ┌──────────────┐          │
│  │   Catalog    │  │   Skills     │  │  Templates   │          │
│  │  (projects)  │  │  (shared)    │  │  (handoff,   │          │
│  │              │  │              │  │   ADR, etc)  │          │
│  └──────┬───────┘  └──────┬───────┘  └──────┬───────┘          │
│         │                 │                 │                   │
│         ▼                 ▼                 ▼                   │
│  ┌─────────────────────────────────────────────────────────┐   │
│  │              AGENTS.md (Navigation Hub)                 │   │
│  └─────────────────────────────────────────────────────────┘   │
└─────────────────────────────────────────────────────────────────┘
                              │
                              ▼
        ┌─────────────────────────────────────────────────────┐
        │              PROJECT REPOSITORIES                   │
        │  ┌─────────────┐ ┌─────────────┐ ┌─────────────┐   │
        │  │  Project A  │ │  Project B  │ │  Project C  │   │
        │  │  (AGENTS.md)│ │  (AGENTS.md)│ │  (AGENTS.md)│   │
        │  └─────────────┘ └─────────────┘ └─────────────┘   │
        └─────────────────────────────────────────────────────┘
```

---

## 🎯 Core Principles

| Principle | Description |
|-----------|-------------|
| **Home discovers, projects execute** | Home is a map; projects are the territory |
| **Context is explicit** | Every handoff, ADR, and skill makes context explicit |
| **Human controls irreversible actions** | Merge, deploy, delete, spend — human approval required |
| **State lives in projects** | Home has no operational state |
| **Skills are shared, not imposed** | Projects choose which skills to adopt |
| **Context persists across sessions** | Handoffs + ADRs + catalog = session continuity |

---

## 🗂️ Component Responsibilities

### Agentic Home (This Repo)
| Responsibility | Description |
|----------------|-------------|
| **Catalog** | Central registry of all projects with metadata |
| **Skills** | Reusable skill definitions (discovery, architecture, development, quality) |
| **Templates** | Handoff, ADR, and other document templates |
| **Governance** | Permission matrix, approval flows, security policies |
| **Documentation** | Architecture, onboarding, governance docs |
| **Navigation** | AGENTS.md as entry point for agents |

### Project Repositories (Each Project)
| Responsibility | Description |
|----------------|-------------|
| **AGENTS.md** | Project-specific agent instructions |
| **Source Code** | Application code, tests, configs |
| **ADRs** | Architectural Decision Records |
| **Handoffs** | Task handoff logs (append-only) |
| **CI/CD** | Project-specific pipelines |
| **Secrets** | Managed via Vault (project-owned) |
| **Observability** | Logs, metrics, traces (project-owned) |

---

## 🔄 Data Flow

```
┌─────────────┐     discovers      ┌─────────────┐
│   Agent     │ ──────────────────► │   Catalog   │
└─────────────┘                     └──────┬──────┘
                                           │
                                           ▼
                              ┌─────────────────────┐
                              │   Project Repo      │
                              │  ┌───────────────┐  │
                              │  │   AGENTS.md   │  │
                              │  ├───────────────┤  │
                              │  │  Source Code  │  │
                              │  ├───────────────┤  │
                              │  │   ADRs        │  │
                              │  ├───────────────┤  │
                              │  │  Handoffs     │  │
                              │  └───────────────┘  │
                              └─────────────────────┘
```

---

## 🤖 Agent Interaction Model

### Agent Starts Session
1. **Load Home Context**: Read `AGENTS.md` in agentic-home
2. **Browse Catalog**: Read `projects/catalog.md` to find project
3. **Navigate to Project**: `cd <project-path>`
4. **Load Project Context**: Read project's `AGENTS.md`
5. **Load Skills**: `skill_view(name='skill-name')` as needed
6. **Check Handoff**: Read project's `handoff.md` if continuing task

### Agent Works on Task
1. **Follow Skill Process**: Use relevant skill (discovery/architecture/development/quality)
2. **Update Handoff**: Append to project's `handoff.md` (append-only)
3. **Create ADRs**: Document architectural decisions
4. **Run Quality Gates**: Execute project's validation pipeline

### Agent Ends Session
1. **Update Handoff**: Record progress, next action, blockers
2. **Commit Changes**: Push code, update handoff, update catalog if needed
3. **Document State**: Ensure next session can continue seamlessly

---

## 🔧 Technology Stack

| Layer | Technology |
|-------|------------|
| **Version Control** | Git + GitHub |
| **CI/CD** | Harness (primary), GitHub Actions (secondary) |
| **Container** | Docker, Kubernetes (EKS/GKE) |
| **Observability** | OpenTelemetry, Prometheus, Grafana, Datadog |
| **Secrets** | HashiCorp Vault |
| **Policy** | OPA/Rego |
| **Messaging** | Kafka, RabbitMQ |
| **Database** | PostgreSQL, Redis, EventStoreDB |
| **AI/ML** | Hermes Agent, OpenAI, Anthropic, Local models |

---

## 🔐 Security Boundaries

```
┌────────────────────────────────────────────────────────────┐
│                     TRUST BOUNDARIES                        │
├────────────────────────────────────────────────────────────┤
│  HOME (Shared)                    │  PROJECT (Autonomous)  │
│  ─────────────────────            │  ───────────────────── │
│  ✅ Reads project catalogs        │  ✅ Owns source code   │
│  ✅ Provides shared skills        │  ✅ Owns AGENTS.md     │
│  ✅ Defines governance            │  ✅ Owns secrets       │
│  ❌ No project secrets            │  ❌ No Home secrets    │
│  ❌ No project code               │  ❌ No cross-project   │
│  ❌ No operational state          │     state access       │
└────────────────────────────────────────────────────────────┘
```

---

## 📊 Observability Strategy

| Signal | Tool | Scope |
|--------|------|-------|
| **Metrics** | Prometheus + Grafana | Project + Home |
| **Logs** | Loki / Datadog | Project + Home |
| **Traces** | Tempo / Jaeger / Datadog | Project + Home |
| **SLOs** | Prometheus rules | Per-project SLOs |
| **Alerts** | Alertmanager / PagerDuty | Per-project + Home |
| **AI-DLC Metrics** | Custom dashboards | Drift, cost, quality, latency |

---

## 🔄 Evolution Strategy

| Phase | Focus |
|-------|-------|
| **v1 (Current)** | Catalog, Skills, Handoffs, Governance, Basic CI/CD |
| **v2** | Auto-discovery, Skill marketplace, Advanced AI-DLC |
| **v3** | Multi-agent orchestration, Self-healing, Predictive scaling |

---

*This architecture is intentionally minimal and extensible. It grows with the needs of the projects it serves.*