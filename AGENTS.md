# Agentic Home — Hub Central para Engenharia de Agentes de IA

> **Objetivo**: Este repositório serve como hub central para descobrir, coordenar e manter projetos de engenharia de agentes de IA. Fornece skills compartilhadas, descoberta de projetos e mecanismos padronizados de handoff para desenvolvimento orientado a agentes.

---

## 🎯 Objetivo

O **Agentic Home** é o hub central para engenharia assistida por IA. Ele existe para:

1. **Descobrir** — Encontrar todos os projetos orientados a agentes e seus pontos de entrada
2. **Padronizar** — Compartilhar skills, padrões e governança entre projetos
4. **Coordenar** — Permitir transferência contínua de contexto entre sessões e agentes
5. **Governar** — Definir limites claros entre Home (compartilhado) e Projetos (autônomos)

---

## 🗺️ Como Navegar

### 📁 Estrutura do Repositório

```
agentic-home/
├── AGENTS.md                 # Este arquivo — ponto de entrada para agentes
├── README.md                 # Visão geral legível por humanos
├── .gitignore                # Ignores padrão
├── projects/
│   └── catalogo.md           # Registro de projetos com metadados de descoberta
├── skills/
│   ├── descoberta/           # Exploração de problemas & requisitos
│   ├── arquitetura/          # Design técnico & trade-offs
│   ├── desenvolvimento/      # Padrões de implementação
│   └── qualidade/            # Validação & verificação
├── templates/
│   └── handoff.md            # Template de handoff de tarefa
└── docs/
    ├── arquitetura.md        # Visão geral da arquitetura do sistema
    ├── governanca.md         # Matriz de permissões & fluxos de aprovação
    └── onboarding.md         # Onboarding self-service para agentes e humanos
```

---

## 🔍 Como Localizar Projetos

### 1. Verifique o Catálogo
Abra `projects/catalogo.md` — contém registro estruturado de todos os projetos conhecidos com:
- **Nome** & **Descrição**
- **Caminho local** (se nesta máquina)
- **URL remota** (GitHub/GitLab)
- **Localização do AGENTS.md** (ponto de entrada do projeto)
- **CLI/Interface** (como executar/iniciar o projeto)
- **Status** (ativo, arquivado, protótipo, etc.)

### 2. Acesse o AGENTS.md do Projeto
Cada projeto possui seu próprio `AGENTS.md` na raiz. Para trabalhar em um projeto:
```bash
cd <caminho-do-projeto>
cat AGENTS.md  # Leia primeiro — contém instruções específicas do projeto
```

### 3. Descubra Skills Compartilhadas
Skills compartilhadas ficam em `skills/` e são organizadas por domínio:
- `skills/descoberta/` — Exploração de problemas & levantamento de requisitos
- `skills/arquitetura/` — Design técnico, trade-offs, ADRs
- `skills/desenvolvimento/` — Padrões de implementação, testes, CI/CD
- `skills/qualidade/` — Validação, testes, revisão de código, observabilidade

Para usar uma skill:
```bash
skill_view(name='descoberta')  # No Hermes, carrega o contexto da skill
```

---

## 📋 Como Ler o Catálogo

O catálogo (`projects/catalogo.md`) usa este formato:

| Campo | Descrição |
|-------|-----------|
| **Nome** | Identificador único do projeto |
| **Descrição** | Propósito em uma linha |
| **Caminho Local** | Caminho absoluto nesta máquina (se disponível) |
| **URL Remota** | URL do GitHub/GitLab |
| **AGENTS.md** | Caminho relativo para o AGENTS.md do projeto |
| **CLI/Interface** | Como executar (ex: `make dev`, `docker-compose up`) |
| **Status** | `ativo` \| `arquivado` \| `protótipo` \| `manutenção` |

---

## 🎭 Como Acessar Skills Compartilhadas

### No Hermes Agent
```bash
# Listar skills disponíveis
skills_list()

# Carregar uma skill específica
skill_view(name='descoberta')

# Aplicar uma skill à tarefa atual
# As instruções da skill tornam-se parte do seu contexto
```

### Formato da Skill
Cada skill possui:
- `SKILL.md` — Definição principal com instruções
- Opcional `templates/`, `scripts/`, `references/` para arquivos de apoio

Skills **não são carregadas automaticamente**. Você deve carregá-las explicitamente quando necessário.

---

## 🔄 Como Continuar Tarefas Interrompidas

### 1. Encontre o Handoff
Cada tarefa cria um `handoff.md` na raiz do projeto (ou referencia um no tracker). Procure por:
```bash
cat <raiz-do-projeto>/handoff.md
```

### 2. Leia a Estrutura do Handoff
O handoff contém:
- **ID da Tarefa & Descrição**
- **Projeto** & **Responsável**
- **Status** (pendente, em-andamento, bloqueado, concluído)
- **Aprovado** (decisão, data, aprovador)
- **Aguardando** (dependências/bloqueadores)
- **Próxima Ação** (próximo passo explícito)
- **Artefatos** (caminhos para artefatos produzidos)
- **Histórico** (log append-only de ações)
- **Validação** (verificações realizadas, resultados, pendências)

### 3. Retome o Trabalho
1. Leia o handoff completamente
2. Carregue skills relevantes (`skill_view(name='...')`)
3. Navegue até a raiz do projeto
4. Execute a **Próxima Ação**
5. Atualize o handoff conforme progride

---

## 📝 Como Registrar Decisões & Pendências

### Decisões Arquiteturais (ADRs)
Cada projeto mantém seus ADRs em `docs/adr/`. Use o template em `templates/adr.md`:
```markdown
# ADR-<numero>: <Titulo>
## Status: Proposto | Aceito | Substituído
## Contexto: <problema & restrições>
## Decisão: <o que foi decidido>
## Consequências: <positivas/negativas/riscos>
```

### Handoffs de Tarefa
Atualize o `handoff.md` do projeto (append-only) com:
- Novas ações appendadas ao **Histórico**
- **Status** atualizado conforme progride
- **Próxima Ação** sempre explícita
- **Validação** atualizada com evidências

---

## 🛡️ Como Respeitar Limites dos Projetos

### Responsabilidades do Home (Este Repo)
✅ **FAÇA:**
- Manter o catálogo de projetos
- Hospedar skills & templates compartilhados
- Definir regras de governança
- Fornecer documentação de onboarding
- Hospedar templates (handoff, ADR, etc.)

❌ **NÃO FAÇA:**
- Modificar código fonte de projetos
- Commitar em repositórios de projetos
- Tomar decisões arquiteturais para projetos
- Deploy ou release de projetos
- Acessar segredos de projetos

### Responsabilidades dos Projetos (Cada Repo)
✅ **FAÇA:**
- Possuir seu `AGENTS.md` e estado
- Manter seus próprios ADRs & handoffs
- Executar seus próprios testes & CI/CD
- Gerenciar seus próprios segredos (via Vault)
- Definir seu próprio `SKILL.md` se necessário

❌ **NÃO FAÇA:**
- Modificar código de outros projetos
- Depender de estado interno de outros projetos
- Burlar o catálogo para descoberta

---

## 🔑 Princípios-Chave

| Princípio | Descrição |
|-----------|------------|
| **Home descobre, projetos executam** | Home é um mapa; projetos são o território |
| **Contexto é explícito** | Cada handoff, ADR e skill torna contexto explícito |
| **Humano controla ações irreversíveis** | Merge, deploy, delete, gasto — aprovação humana obrigatória |
| **Estado vive nos projetos** | Home não tem estado operacional |
| **Skills são compartilhadas, não impostas** | Projetos escolhem quais skills adotar |
| **Contexto persiste entre sessões** | Handoffs + ADRs + catálogo = continuidade de sessão |

---

## 🚀 Início Rápido para Novos Agentes

```bash
# 1. Clone este repo
git clone https://github.com/seuusuario/agentic-home.git
cd agentic-home

# 2. Leia este arquivo completamente
cat AGENTS.md

# 3. Navegue pelo catálogo
cat projects/catalogo.md

# 3. Carregue uma skill para testar
skill_view(name='descoberta')

# 4. Escolha um projeto do catálogo e comece
cd <caminho-do-projeto>
cat AGENTS.md
```

---

## 📚 Documentação Relacionada

| Documento | Finalidade |
|-----------|------------|
| `README.md` | Visão geral legível por humanos |
| `projects/catalogo.md` | Registro de projetos |
| `docs/arquitetura.md` | Arquitetura do sistema |
| `docs/governanca.md` | Matriz de permissões & fluxos de aprovação |
| `docs/onboarding.md` | Onboarding self-service para agentes e humanos |
| `templates/handoff.md` | Template de handoff de tarefa |
| `templates/adr.md` | Template de ADR |

---

*Este arquivo é a fonte única de verdade para como agentes interagem com o Agentic Home. Atualize-o quando governança, estrutura ou convenções mudarem.*