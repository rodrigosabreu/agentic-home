# Template Project Description (project-description.json)

Este template define a estrutura do arquivo `project-description.json` — a descrição canônica do projeto (single source of truth).

---

## Formato

O arquivo deve conter uma **string JSON** (não um objeto) com a descrição completa do projeto em uma única linha (escaped).

---

## Template

```json
"<nome do projeto> — <descrição curta>. <propósito>. Stack: <backend stack> / <frontend stack>. <principais features>. <compliance>. Estado: <estado atual>."
```

---

## Exemplo (ContractAI)

```json
"ContractAI — Intelligent Contract Analysis Platform. Prova de conceito para apoiar a análise de contratos com inteligência artificial. A aplicação permite cadastrar uma organização, enviar um documento (PDF/DOCX/TXT) e solicitar uma análise estruturada de cláusulas e riscos. Stack: Backend FastAPI 0.109+ / Python 3.11+ / PostgreSQL 15+ com pgvector (produção) / SQLite (desenvolvimento) / SQLAlchemy 2.0 async / Alembic / Celery + Redis / JWT HS256 com token revocation (JTI blacklist) + MFA TOTP / LLM Providers: OpenAI (GPT-4), NVIDIA (Nemotron), Hermes (fallback desabilitado) / Document Processing: pdfplumber, pypdf, python-docx, Tesseract OCR / Vector Search: pgvector 1536-dim / Frontend Next.js 14+ App Router / TypeScript / Tailwind CSS / React Hook Form + Zod / Axios / Vitest + Playwright. Multi-tenancy por organization_id com roles admin/manager/analyst/viewer. LGPD compliance: export/delete endpoints, audit logging, retention policies. Estado: POC funcional, testes parciais, sem CI/CD, sem AI-DLC."
```

---

## Campos Obrigatórios na Descrição

| Campo | Obrigatório | Descrição |
|-------|-------------|-----------|
| Nome do projeto | Sim | Nome canônico |
| Propósito | Sim | O que o projeto faz em uma frase |
| Stack Backend | Sim | Framework, linguagem, DB, ORM, queue |
| Stack Frontend | Se houver | Framework, linguagem, styling |
| Features Principais | Sim | Funcionalidades core |
| Compliance | Se aplicável | LGPD, LGPD, SOX, PCI-DSS, etc. |
| Estado Atual | Sim | POC, MVP, produção, etc. |

---

## Exemplo Greenfield

```json
"MeuProjeto — Plataforma de gestão de tarefas colaborativa. Permite criar quadros, cartões, atribuir responsáveis, prazos e comentários. Stack: Backend FastAPI 0.109+ / Python 3.11+ / PostgreSQL 15+ / SQLAlchemy 2.0 async / Celery + Redis / JWT HS256 / Frontend Next.js 14+ / TypeScript / Tailwind CSS / React Hook Form + Zod. Estado: Greenfield — estrutura inicial, sem código."
```

---

## Exemplo Brownfield

```json
"SistemaLegado — Sistema de gestão financeira legado em migração. Permite conciliação bancária, emissão de relatórios, integração com bancos via Open Banking. Stack: Backend Java 17 / Spring Boot 3.2 / PostgreSQL 15 / JPA Hibernate / Frontend Angular 17 / TypeScript / Tailwind. Multi-tenancy por organization_id. LGPD compliance parcial. Estado: Brownfield — código legado em produção, sem testes automatizados, sem CI/CD, sem AI-DLC."
```

---

## Validação

O arquivo deve:
- [ ] Ser JSON válido (string escapada)
- [ ] Conter todos campos obrigatórios
- [ ] Ser uma única linha (sem quebras de linha não escapadas)
- [ ] Ser parsable: `json.loads(open('project-description.json').read())`

---

## Localização

```
/opt/data/projects/<projeto>/aidlc/spaces/default/intents/<intent-id>/project-description.json
```

---

## Exemplo Completo (ContractAI)

```json
"ContractAI — Intelligent Contract Analysis Platform. Prova de conceito para apoiar a análise de contratos com inteligência artificial. A aplicação permite cadastrar uma organização, enviar um documento (PDF/DOCX/TXT) e solicitar uma análise estruturada de cláusulas e riscos. Stack: Backend FastAPI 0.109+ / Python 3.11+ / PostgreSQL 15+ com pgvector (produção) / SQLite (desenvolvimento) / SQLAlchemy 2.0 async / Alembic / Celery + Redis / JWT HS256 com token revocation (JTI blacklist) + MFA TOTP / LLM Providers: OpenAI (GPT-4), NVIDIA (Nemotron), Hermes (fallback desabilitado) / Document Processing: pdfplumber, pypdf, python-docx, Tesseract OCR / Vector Search: pgvector 1536-dim / Frontend Next.js 14+ App Router / TypeScript / Tailwind CSS / React Hook Form + Zod / Axios / Vitest + Playwright. Multi-tenancy por organization_id com roles admin/manager/analyst/viewer. LGPD compliance: export/delete endpoints, audit logging, retention policies. Estado: POC funcional, testes parciais, sem CI/CD, sem AI-DLC."
```