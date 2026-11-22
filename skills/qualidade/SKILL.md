---
name: qualidade
description: "Validação de critérios de aceite, execução de testes, identificação de regressões, registro de defeitos com evidências, avaliação objetiva de qualidade"
version: "1.0.0"
category: qualidade
---

# Skill Qualidade — Validação & Verificação

> **Objetivo**: Validar que implementação atende critérios de aceite, executar testes, identificar regressões, registrar defeitos com evidências e produzir avaliações objetivas de qualidade.

---

## 🎯 Quando Usar

- Após Desenvolvimento completar implementação
- Antes de qualquer merge em branches protegidas
- Antes de qualquer deploy para staging/produção
- Ao investigar problemas em produção
- Durante auditorias regulares de qualidade
- Ao avaliar dívida técnica

---

## 🔍 Processo

### 1. Validar Critérios de Aceite
- Revisar todos ACs da Descoberta
- Mapear cada AC para teste(s) específico(s)
- Verificar cada AC demonstrado como atendido
- Documentar evidência (screenshots, logs, output de testes)

### 2. Executar Suite de Testes
| Tipo de Teste | Execução | Gate |
|-----------|-----------|------|
| **Unit** | `make test` / `pytest` / `go test` | 100% pass |
| **Integração** | `make test-it` / `pytest -m integration` | 100% pass |
| **Contract** | `pact:verify` / provider verification | 0 breaking changes |
| **E2E** | `make test-e2e` / Cypress/Playwright | Caminhos críticos passam |
| **Performance** | `k6` / `locust` / `gatling` | Atende thresholds SLA |
| **Segurança** | SAST/SCA/Secrets scan | 0 HIGH/CRITICAL |

### 3. Identificar Regressões
- Comparar resultados atuais com baseline
- Rodar golden set evaluations (se IA/ML envolvido)
- Checar benchmarks de performance
- Comparar contratos de API (Pact verification)
- Validar integridade de dados (migrações, schemas)

### 4. Registrar Defeitos com Evidência
Cada registro de defeito deve incluir:
| Campo | Descrição |
|-------|-------------|
| **ID** | Identificador único (ex: DEF-001) |
| **Título** | Descrição concisa |
| **Severidade** | CRITICAL / HIGH / MEDIUM / LOW |
| **Passos para Reproduzir** | Passos exatos com dados |
| **Comportamento Esperado** | O que deveria acontecer |
| **Comportamento Real** | O que aconteceu |
| **Evidência** | Screenshots, logs, output de testes, traces |
| **Ambiente** | Versão, commit, ambiente |
| **Dono** | Dev atribuído |
| **Status** | OPEN / IN_PROGRESS / FIXED / VERIFIED / WONTFIX |

### 5. Produzir Avaliação de Qualidade
Resumo objetivo com:
- **Veredito Geral**: PASS / CONDITIONAL PASS / FAIL
- **Critérios Atendidos**: X/Y critérios de aceite
- **Testes Passados**: X/Y testes
- **Defeitos Encontrados**: Contagem por severidade
- **Cobertura**: Cobertura de código (linha, branch, function)
- **Performance**: Métricas-chave vs. SLA
- **Segurança**: Resumo de scans
- **Recomendação**: READY / NEEDS FIXES / BLOCKED

---

## 📋 Artefatos de Saída

| Artefato | Finalidade |
|----------|---------|
| **Test Report** | Resultados completos execução testes (JUnit XML, HTML) |
| **Defect Report** | Lista estruturada de defeitos com evidência |
| **Coverage Report** | Cobertura de código (linha, branch, function) |
| **Performance Report** | Latência, throughput, taxas de erro |
| **Security Report** | SAST/SCA/Secrets findings |
| **Quality Gate Report** | PASS/CONDITIONAL/FAIL com rationale |
| **Traceability Matrix** | AC ↔ Test ↔ Defect mapping |

---

## 🛠️ Ferramentas & Frameworks

| Categoria | Ferramentas |
|---------|-------|
| **Unit/Integração** | pytest, JUnit, Jest, Go test, xUnit |
| **Contract** | Pact, Spring Cloud Contract |
| **E2E** | Playwright, Cypress, Selenium |
| **Performance** | k6, Locust, Gatling, JMeter |
| **SAST** | SonarQube, CodeQL, SpotBugs, Semgrep |
| **SCA** | OWASP Dependency Check, Snyk, Trivy |
| **Secrets** | TruffleHog, GitLeaks, GitGuardian |
| **Container** | Trivy, Syft, Grype |
| **Coverage** | JaCoCo, Cobertura, Istanbul, coverage.py |
| **Performance** | k6, Locust, JMeter, Vegeta |

---

## ✅ Quality Gates

### Pre-Merge (Obrigatório)
- [ ] Todos testes unitários passam
- [ ] Todos testes de integração passam
- [ ] Testes de contract passam (consumer & provider)
- [ ] Cobertura código ≥ 80% (linha), ≥ 70% (branch)
- [ ] Linting/formatação passam
- [ ] Static analysis: 0 novos HIGH/CRITICAL
- [ ] SAST: 0 HIGH/CRITICAL
- [ ] SCA: 0 CVSS ≥ 7.0
- [ ] Secrets scan: 0 achados
- [ ] Container scan: 0 CRITICAL

### Pre-Deploy Staging (Obrigatório)
- [ ] Todos gates pre-merge passam
- [ ] E2E tests passam (caminhos críticos)
- [ ] Performance baseline atendida
- [ ] Security scans limpos
- [ ] Rollback testado e documentado

### Pre-Production (Obrigatório)
- [ ] Todos gates staging passam
- [ ] Canary validation passed
- [ ] Rollback automático < 30s
- [ ] Runbook atualizado
- [ ] On-call notificado
- [ ] Aprovação humana obtida

---

## 📋 Artefatos de Saída (Detalhados)

### Test Report (JUnit XML + HTML)
```xml
<testsuite name="project" tests="247" failures="0" errors="0" time="45.2">
  <testcase classname="EngineTest" name="testAssessConservativeProfile" time="0.12"/>
  ...
</testsuite>
```

### Defect Report (Markdown)
```markdown
# Defect Report - Deployment v1.2.3

## DEF-001: Suitability Assessment Returns Wrong Risk Level
**Severity**: HIGH
**Steps**: 1. Create investor with CONSERVADOR profile 2. Recommend ALTO risk product 3. Observe result
**Expected**: REJECTED with CVM_558_ART_12 violation
**Actual**: APPROVED with no violation
**Evidence**: [Screenshot](link), [Log trace](link), [Test output](link)
**Environment**: v1.2.3, staging, commit abc123
**Owner**: @dev-team
**Status**: OPEN
```

### Quality Gate Report
```markdown
# Quality Gate Report - v1.2.3

## Verdict: CONDITIONAL PASS

## Summary
- **Acceptance Criteria**: 14/15 met (1 blocked by DEF-001)
- **Tests**: 247/247 passed
- **Coverage**: 87% line, 78% branch
- **Performance**: P99 latency 450ms (SLA < 500ms) ✅
- **Security**: 0 CRITICAL, 0 HIGH, 2 MEDIUM (known, accepted)
- **Defects**: 1 HIGH (DEF-001), 2 MEDIUM, 3 LOW

## Recommendation
**NEEDS FIXES** — Block on DEF-001 resolution before production deploy.
```

---

## 🛠️ Automação no CI/CD

```yaml
# Exemplo GitHub Actions / Harness stage
quality_gates:
  - name: "Unit & Integration Tests"
    run: make test
  - name: "Contract Tests"
    identifier: contract_tests
    type: Run
    spec:
      command: ./mvnw test -Dtest=*PactConsumerTest,*PactProviderTest
  - name: "Security Scans"
    identifier: security_scans
    type: SecurityScan
    spec:
      scanner: HarnessSAST
      failOnSeverity: HIGH
  - name: "Coverage Check"
    identifier: coverage_check
    type: Run
    spec:
      command: make coverage-check  # fails if < 80%
  - name: "Quality Gate Report"
    identifier: quality_gate_report
    type: Run
    spec:
      command: python scripts/quality_gate_report.py
```

---

## ✅ Quality Gates Checklist

Quando invocado para validação de qualidade:
- [ ] Revisar todos critérios de aceite da Descoberta
- [ ] Executar suite completa (unit, integration, contract, E2E)
- [ ] Rodar todos security scans (SAST, SCA, Secrets, Container)
- [ ] Verificar thresholds de cobertura
- [ ] Comparar contra baselines de performance
- [ ] Checar regressões (golden sets, contract changes)
- [ ] Documentar todos defeitos com evidência
- [ ] Produzir quality gate report com veredito
- [ ] Comunicar veredito para stakeholders
- [ ] Bloquear merge/deploy se gates falharem

---

## ⚠️ Anti-Padrões a Evitar

| Anti-Padrão | Por Que Danoso | Abordagem Correta |
|--------------|----------------|-------------------|
| **Pular gates** | "Funcionou na minha máquina" | Gates são obrigatórios, não opcionais |
| **Sem evidência** | "Confia, funciona" | Todo defeito precisa evidência |
| **Ignorar testes flaky** | Falsa confiança | Corrigir ou quarantena testes flaky |
| **Cobertura teatro** | 80% cobertura, 0% significativo | Testar comportamento, não linhas |
| **Sem checagem regressão** | Quebra silenciosa | Golden sets + contract tests |
| **Veredito subjetivo** | "Parece bom pra mim" | Critérios objetivos + evidência |

---

## 📋 Checklist para Agentes

Quando invocado para validação de qualidade:
- [ ] Revisar todos critérios de aceite da Descoberta
- [ ] Executar suite completa (unit, integration, contract, E2E)
- [ ] Rodar todos security scans (SAST, SCA, Secrets, Container)
- [ ] Verificar thresholds de cobertura
- [ ] Comparar contra baselines de performance
- [ ] Checar regressões (golden sets, contract changes)
- [ ] Documentar todos defeitos com evidência
- [ ] Produzir quality gate report com veredito
- [ ] Comunicar veredito para stakeholders
- [ ] Bloquear merge/deploy se gates falharem

---

*Esta skill é reutilizável em todos os projetos. Carregue com `skill_view(name='qualidade')` no Hermes.*