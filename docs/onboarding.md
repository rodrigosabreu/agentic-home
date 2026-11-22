# Onboarding — Agentic Home

> **Self-service onboarding para novos agentes e projetos ingressando no ecossistema Agentic Home.**

---

## 🎯 Bem-vindo ao Agentic Home

Bem-vindo ao **Agentic Home** — o hub central para engenharia assistida por IA. Este guia vai te deixar produtivo rapidamente, seja você um engenheiro humano ou um agente de IA.

---

## 🤖 Para Agentes de IA (Hermes)

### 1. Setup Inicial (Primeira Sessão)

```bash
# 1. Clone o Home repository
git clone https://github.com/seuusuario/agentic-home.git
cd agentic-home

# 2. Leia o ponto de entrada do agente completamente
cat AGENTS.md

# 3. Navegue pelo catálogo de projetos
cat projects/catalogo.md

# 4. Verifique se Hermes consegue carregar skills
skill_view(name='descoberta')
skill_view(name='arquitetura')
skill_view(name='desenvolvimento')
skill_view(name='qualidade')
```

### 2. Entendendo Seu Papel

| Aspecto | Descrição |
|---------|-------------|
| **Identidade** | Você é um agente de IA operando no ecossistema Agentic Home |
| **Autoridade** | Executa tarefas dentro de limites definidos (veja `docs/governanca.md`) |
| **Memória** | Possui memória persistente via `SOUL.md`, `USER.md`, e handoffs de projeto |
| **Ferramentas** | Acesso a: terminal, browser, git, gh, skills, OPA, Hermes APIs |
| **Accountability** | Toda ação é logada; você é accountable por seus outputs |

### 2.1 Suas Capacidades

| Capacidade | Descrição |
|------------|-------------|
| **Terminal Access** | Acesso total ao shell via ferramenta `terminal` |
| **File Operations** | Leitura/escrita arquivos via `read_file`, `write_file`, `patch` |
| **Git/GitHub** | Git completo + `gh` CLI |
| **Browser** | Automação web via `browser_exec` |
| **Skills** | Carregar skills compartilhadas via `skill_view(name='...')` |
| **Delegation** | Spawn subagents via `delegate_task()` |
| **Research** | Web search via `web_search`, `web_extract` |
| **Hermes APIs** | Acesso a internals do Hermes |

### 2.2 Seus Limites

| ✅ Você PODE | ❌ Você NÃO PODE |
|--------------|------------------|
| Ler qualquer documentação | Modificar projetos sem PR/aprovação |
| Carregar e usar skills compartilhadas | Acessar secrets de projetos diretamente |
| Criar arquivos em projetos atribuídos | Deploy em produção sem aprovação |
| Rodar testes e validações | Merge em branches protegidas sem aprovação |
| Carregar e usar skills compartilhadas | Deploy em produção sem aprovação humana |
| Spawn subagents para trabalho paralelo | Armazenar credenciais no Git/Repo |
| Ler toda documentação | Executar operações destrutivas sem aprovação |

---

## 🚀 Checklist Rápido

### Primeira Sessão (30 minutos)

```
[ ] 1. Clone o Home repository
git clone https://github.com/seuusuario/agentic-home.git
cd agentic-home

# 2. Leia o ponto de entrada do agente
cat AGENTS.md

# 3. Navegue pelo catálogo de projetos
cat projects/catalogo.md

# 4. Carregue cada skill compartilhada
skill_view(name='descoberta')
skill_view(name='arquitetura')
skill_view(name='desenvolvimento')
skill_view(name='qualidade')

# 5. Escolha um projeto do catálogo e explore
cd <caminho-do-projeto>
cat AGENTS.md
```

### Início de Sessão Diário (5 minutos)

```
[ ] 1. git pull origin main (no agentic-home)
[ ] 2. Verifique skills atualizadas: skill_list()
[ ] 3. Revise catálogo de projetos por mudanças
[ ] 4. Verifique handoff da tarefa atribuída
[ ] 5. Carregue skills necessárias para o dia
```

---

## 👥 Para Engenheiros Humanos

### 1. Setup Inicial (15 minutos)

```bash
# 1. Clone o repositório
git clone https://github.com/seuusuario/agentic-home.git
cd agentic-home

# 2. Revise a estrutura
ls -la
cat README.md

# 3. Verifique projetos existentes
cat projects/catalogo.md

# 4. Revise governança
cat docs/governanca.md
```

### 2. Adicionando Novo Projeto

```bash
# 1. Garanta que seu projeto tem:
#    - AGENTS.md na raiz
#    - README claro com setup, execução
#    - CI/CD configurado (Harness, GitHub Actions, ou documentado)
#    - AGENTS.md ou SKILL.md para contexto de agente

# 2. Adicione ao catálogo
# Edite projects/catalogo.md seguindo o formato

# 3. Commit e push
git add projects/catalogo.md
git commit -m "catalogo: adiciona <nome-projeto>"
git push origin main
```

### 2.1 Checklist de Requisitos do Projeto

Antes de adicionar ao catálogo, garanta que o projeto tem:

- [ ] `AGENTS.md` na raiz com instruções específicas para agentes
- [ ] `README.md` claro com propósito, setup, comandos execução
- [ ] Comandos build/test/run documentados (Makefile, scripts, ou docs)
- [ ] CI/CD configurado (Harness, GitHub Actions, ou documentado)
- [ ] `AGENTS.md` ou `SKILL.md` para contexto de agente
- [ ] Secrets gerenciados via Vault (nenhum secret no repo)
- [ ] Licença/header compliance (se aplicável)

---

## 🔧 Setup do Ambiente

### Ferramentas Obrigatórias

| Tool | Versão | Install |
|------|--------|---------|
| **Git** | ≥ 2.40 | `apt-get install git` |
| **GitHub CLI (gh)** | ≥ 2.65 | Ver abaixo |
| **Docker** | ≥ 24.0 | `apt-get install docker.io` |
| **Docker Compose** | ≥ 2.20 | `apt-get install docker-compose` |
| **Python** | 3.11+ | `apt-get install python3.11` |
| **Node.js** | 20+ (LTS) | `nvm install 20` |
| **Go** | 1.22+ | `go install golang.org/dl/go1.22@latest` |
| **Java** | 21 (LTS) | SDKMAN ou apt |
| **Maven** | 3.9+ | `apt-get install maven` |

### GitHub CLI Setup

```bash
# Install gh (se não presente)
curl -sL https://github.com/cli/cli/releases/latest/download/gh_linux_amd64.tar.gz | tar -xz
sudo mv gh_*/bin/gh /usr/local/bin/

# Autenticar
gh auth login
# Siga prompts interativos

# Verificar
gh auth status
```

### Git Configuration

```bash
# Obrigatório para commits
git config --global user.name "Seu Nome"
git config --global user.email "seu.email@dominio.com"

# Aliases úteis
git config --global alias.co checkout
git config --global alias.br branch
git config --global alias.ci commit
git config --global alias.st status
git config --global alias.lg "log --oneline --graph --decorate -20"
```

### Docker & Compose

```bash
# Verificar
docker --version
docker-compose --version

# Testar
docker run --rm hello-world
```

---

## 🔐 Secrets & Acesso

### Acessos Necessários

| Sistema | Finalidade | Como Obter |
|---------|------------|------------|
| **GitHub** | Código, PRs, Actions | `gh auth login` + SSO |
| **Harness** | CI/CD pipelines | Perguntar time Platform |
| **Vault** | Secrets management | Perguntar time Security |
| **Datadog** | Observabilidade | Perguntar time Platform |
| **Harness/ArgoCD** | Deploys | Perguntar time Platform |
| **Kubernetes** | Acesso cluster | Perguntar time Platform |
| **AWS/GCP/Azure** | Recursos cloud | Perguntar time Cloud |

### Vault Access (para secrets)

```bash
# Login via Kubernetes auth (no cluster)
vault login -method=kubernetes role=seu-role

# Ou via token (dev local)
export VAULT_ADDR=https://vault.seudominio.com
export VAULT_TOKEN=<seu-token>
vault kv get secret/seu-projeto/db
```

---

## 🛠️ Ambiente de Desenvolvimento

### IDE Recomendado

| Editor | Extensions |
|--------|------------|
| **VS Code** | GitLens, GitHub Actions, Docker, YAML, Markdown, Checkstyle, PMD, SonarLint |
| **IntelliJ** | GitToolBox, GitHub Actions, Docker, Kubernetes, Checkstyle, SpotBugs |
| **Neovim** | LSP, Telescope, GitSigns, Conform, Lint |

### Pre-commit Hooks (Recomendado)

```bash
# Install pre-commit
pip install pre-commit

# Install hooks
pre-commit install

# Run manually
pre-commit run --all-files
```

### .pre-commit-config.yaml (adicionar na raiz do projeto)

```yaml
repos:
  - repo: https://github.com/pre-commit/pre-commit-hooks
    rev: v4.6.0
    hooks:
      - id: trailing-whitespace
      - id: end-of-file-fixer
      - id: check-yaml
      - id: check-added-large-files
      - id: check-merge-conflict
      - id: debug-logger
      - id: detect-private-key

  - repo: https://github.com/psf/black
    rev: 24.4.2
    hooks:
      - id: black

  - repo: https://github.com/astral-sh/ruff-pre-commit
    rev: v0.4.4
    hooks:
      - id: ruff
        args: [--fix, --exit-non-zero-on-fix]
      - id: ruff-format

  - repo: https://github.com/pre-commit/mirrors-mypy
    rev: v1.10.0
    hooks:
      - id: mypy
        additional_dependencies: [types-requests, types-PyYAML]
```

---

## 🧪 Testando Seu Setup

```bash
# 1. Verificar Git
git config --global user.name
git config --global user.email

# 2. Verificar GitHub CLI
gh auth status

# 3. Verificar Docker
docker run --rm hello-world

# 4. Testar GitHub CLI
gh repo view seuusuario/agentic-home

# 5. Testar Skills
skill_view(name='descoberta')

# 6. Testar Git
git -C /opt/data/projects/agentic-home status
```

---

## 🆘 Troubleshooting

### Problemas Comuns

| Issue | Solução |
|-------|---------|
| `gh auth status` falha | Rode `gh auth login` novamente |
| `skill_view` not found | Garanta que Hermes tem skills carregadas; cheque `skills_list()` |
| `git push` falha | Verifique `gh auth status`, garanta SSH key ou PAT |
| Docker permission denied | `sudo usermod -aG docker $USER` depois relogin |
| Port 8080 in use | `lsof -i :8080` depois kill ou mude porta |
| `skill_view` not found | Cheque `skills_list()`, garanta skill existe em `/opt/data/skills/` |

### Obtendo Ajuda

| Canal | Finalidade |
|---------|------------|
| `#agentic-home` | Perguntas gerais, anúncios |
| `#agentic-home-help` | Ajuda técnica, troubleshooting |
| `#agentic-home-dev` | Discussões desenvolvimento |
| `#oncall` | Incidentes produção |

---

## 📚 Próximos Passos Após Onboarding

1. **Explore um Projeto**: Escolha um de `projects/catalogo.md` e explore
2. **Rode uma Skill**: Tente `skill_view(name='descoberta')` num problema real
3. **Crie um Handoff**: Pratique com `templates/handoff.md`
4. **Escreva um ADR**: Use `templates/adr.md` para decisão real
4. **Rode um Pipeline**: Trigger Harness CI/CD para um projeto

---

## 📞 Contatos de Suporte

| Área | Contato |
|------|---------|
| **Platform/Infra** | #platform-support |
| **Security/Compliance** | #security-compliance |
| **Harness CI/CD** | #harness-support |
| **Vault/Secrets** | #vault-support |
| **Kubernetes** | #k8s-support |
| **Geral** | #agentic-home-help |

---

*Bem-vindo ao Agentic Home! Você agora faz parte do ecossistema de engenharia assistida por IA. O Home existe para amplificar suas capacidades — use-o bem.*