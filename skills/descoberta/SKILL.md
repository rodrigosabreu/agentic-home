---
name: descoberta
description: "Exploração de problemas, levantamento de requisitos, mapeamento de cenários, identificação de ambiguidades, definição de critérios de aceite"
version: "1.0.0"
category: descoberta
---

# Skill Descoberta — Exploração de Problemas & Levantamento de Requisitos

> **Objetivo**: Explorar sistematicamente espaços de problema, coletar requisitos, mapear cenários, identificar ambiguidades e definir critérios de aceite claros antes de iniciar implementação.

---

## 🎯 Quando Usar

- Iniciando nova feature ou projeto
- Recebendo requisitos vagos ou incompletos
- Explorando espaços de problema desconhecidos
- Antes de escrever qualquer código de implementação
- Quando stakeholders têm necessidades conflitantes

---

## 🔬 Processo

### 1. Clarificar o Problema
- Qual é o problema real? (não a solução proposta)
- Quem experimenta este problema? (personas, papéis)
- Qual o impacto? (negócio, técnico, usuário)
- O que acontece se não resolvermos?

### 2. Identificar Requisitos
- **Funcionais**: O que o sistema deve fazer?
- **Não-funcionais**: Performance, segurança, conformidade, escalabilidade
- **Restrições**: Orçamento, prazo, tecnologia, regulatório
- **Dependências**: Outros sistemas, times, APIs externas

### 3. Mapear Cenários
- **Caminho feliz**: Jornada principal do usuário
- **Casos de borda**: Condições limite, estados de erro
- **Fluxos alternativos**: Variações, exceções
- **Modos de falha**: O que pode dar errado?

### 5. Identificar Ambiguidades
- Informações faltantes
- Requisitos conflitantes
- Terminologia não definida
- Suposições implícitas
- Tratamento de casos de borda faltante

### 6. Definir Critérios de Aceite
- **Específicos**: Não ambíguos, testáveis
- **Mensuráveis**: Quantificáveis quando possível
- **Alcançáveis**: Realistas dadas as restrições
- **Relevantes**: Ligados a valor de negócio
- **Temporais**: Definição clara de pronto

---

## 📋 Artefatos de Saída

| Artefato | Finalidade |
|----------|---------|
| **Problem Statement** | Definição do problema em uma página |
| **Requirements Spec** | Requisitos estruturados (funcionais/não-funcionais) |
| **Scenario Map** | Jornadas do usuário, casos de borda, modos de falha |
| **Ambiguity Log** | Ambiguidades rastreadas com donos & prazos |
| **Acceptance Criteria** | Critérios testáveis por feature/story |

---

## 🛠️ Ferramentas & Técnicas

| Técnica | Quando Usar |
|-----------|-------------|
| **5 Porquês** | Análise de causa raiz |
| **User Story Mapping** | Visualizar jornadas do usuário |
| **Event Storming** | Exploração de domínio complexo |
| **Impact Mapping** | Conectar entregáveis a objetivos |
| **Example Mapping** | Clarificar critérios com exemplos |
| **Pre-mortem** | Identificar riscos antes de iniciar |

---

## ✅ Quality Gates

Antes de ir para Arquitetura:
- [ ] Problem statement claro e acordado
- [ ] Todos requisitos funcionais documentados
- [ ] Requisitos não-funcionais definidos (SLA, segurança, conformidade)
- [ ] Cenários-chave mapeados (caminho feliz + 3 casos de borda mínimo)
- [ ] Ambiguidades logadas com donos e prazos
- [ ] Critérios de aceite definidos e testáveis
- [ ] Sign-off de stakeholders obtido
- [ ] Artefatos de descoberta produzidos
- [ ] Handoff para Arquitetura com artefatos claros

---

## 🔗 Skills Relacionadas

- **Arquitetura** — Recebe output da descoberta, produz design técnico
- **Desenvolvimento** — Implementa baseado na arquitetura
- **Qualidade** — Valida contra critérios de aceite

---

## 📋 Checklist para Agentes

Quando invocado para descoberta:
- [ ] Ler qualquer contexto existente (AGENTS.md, handoffs, ADRs)
- [ ] Identificar todos stakeholders
- [ ] Rodar clarificação do problema (5 Porquês)
- [ ] Documentar requisitos (funcionais + não-funcionais)
- [ ] Mapear cenários (caminho feliz + casos de borda)
- [ ] Logar todas ambiguidades com donos
- [ ] Escrever critérios de aceite (formato Gherkin preferido)
- [ ] Obter sign-off de stakeholders
- [ ] Produzir artefatos de descoberta
- [ ] Handoff para Arquitetura com artefatos claros

---

## 📋 Formato de Output Exemplo

```markdown
# Descoberta: <Feature Name>

## Problem Statement
<Problem statement claro e conciso>

## Stakeholders
- <Papel>: <Nome/Time> — <Interesse>

## Requisitos
### Funcionais
- REQ-001: <Descrição>
- REQ-002: <Descrição>

### Não-Funcionais
- NFR-001: Latência < 500ms (p99)
- NFR-002: Disponibilidade 99.99%

## Cenários
### Caminho Feliz
1. Usuário faz X
2. Sistema responde Y
3. Resultado Z

### Casos de Borda
- EC-001: <Descrição>
- EC-002: <Descrição>

## Ambiguidades
| ID | Ambiguidade | Dono | Prazo |
|----|-------------|------|-------|
| AMB-001 | <Descrição> | @pessoa | YYYY-MM-DD |

## Critérios de Aceite
- AC-001: Dado <contexto>, quando <ação>, então <resultado>
- AC-002: Dado <contexto>, quando <ação>, então <resultado>
```

---

## ⚠️ Anti-Padrões a Evitar

| Anti-Padrão | Por Que É Danoso | Abordagem Correta |
|-------------|------------------|-------------------|
| **Solution-first** | Pula para implementação antes de entender problema | Problem-first, solution-last |
| **Requisitos vagos** | "Rápido", "user-friendly", "seguro" | Quantificável: "< 500ms p99", "OWASP Top 10" |
| **Ignorar casos de borda** | Só considera caminho feliz | Mapear mínimo 3 casos de borda por fluxo |
| **Ambiguidades não resolvidas** | Prossegue com desconhecidos | Logar ambiguidades, definir prazos, escalar |
| **Sem critérios de aceite** | Sem definição de pronto | Toda story tem AC testável |

---

*Esta skill é reutilizável em todos os projetos. Carregue com `skill_view(name='descoberta')` no Hermes.*