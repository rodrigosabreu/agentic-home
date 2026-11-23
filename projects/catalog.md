# Catálogo de Projetos — Agentic Home

> **Fonte única de verdade para todos os projetos de engenharia de agentes de IA.**  
> Este catálogo é a fonte única de verdade para descobrir e acessar projetos de engenharia de agentes de IA.

---

## 📋 Formato do Catálogo

Cada entrada de projeto segue esta estrutura:

| Campo | Descrição |
|-------|-------------|
| **Nome** | Identificador único do projeto |
| **Descrição** | Propósito em uma linha |
| **Caminho Local** | Caminho absoluto nesta máquina (se disponível) |
| **URL Remota** | URL GitHub/GitLab |
| **AGENTS.md** | Caminho relativo para o AGENTS.md do projeto |
| **CLI/Interface** | Como executar (ex: `make dev`, `docker-compose up`) |
| **Status** | `ativo` \| `arquivado` \| `protótipo` \| `manutenção` |

---

## 📚 Projetos Registrados

### 1. Crivo Crédito Demo
| Campo | Valor |
|-------|-------|
| **Nome** | crivo-credito-demo |
| **Descrição** | POC de análise de crédito com simulação, motor de decisão e API REST — modo simulado |
| **Caminho Local** | `/opt/data/projects/crivo-credito` |
| **URL Remota** | https://github.com/rodrigosabreu/crivo-credito-demo |
| **AGENTS.md** | `AGENTS.md` |
| **CLI/Interface** | `python3 run.py` / `curl -X POST http://localhost:8000/api/execucoes -d '{"cenario":"completo"}'` |
| **Status** | `protótipo` |

### 2. ContractAI
| Campo | Valor |
|-------|-------|
| **Nome** | contractai |
| **Descrição** | Agente de análise de contratos com IA — extração de cláusulas, riscos e compliance |
| **Caminho Local** | `/opt/data/projects/contractai` |
| **URL Remota** | https://github.com/rodrigosabreu/contractai |
| **AGENTS.md** | `AGENTS.md` |
| **CLI/Interface** | `make dev` / `docker-compose up` |
| **Status** | `protótipo` |

### 3. Sistema Condomínio QR
| Campo | Valor |
|-------|-------|
| **Nome** | sistema-condominio-qr |
| **Descrição** | Sistema de gestão de condomínios com QR Code para acesso, reservas e comunicados |
| **Caminho Local** | `/opt/data/projects/sistema-condominio-qr` |
| **URL Remota** | https://github.com/rodrigosabreu/sistema-condominio-qr |
| **AGENTS.md** | `AGENTS.md` |
| **CLI/Interface** | `docker-compose up` |
| **Status** | `protótipo` |

---

## 📝 Adicionando Novos Projetos

Para adicionar um novo projeto a este catálogo:

1. **Garanta que o projeto tenha:**
   - Um `AGENTS.md` na raiz
   - Descrição e propósito claros
   - CLI/interface documentada para execução
   - Um remote Git (GitHub/GitLab) ou caminho local documentado

2. **Adicione uma entrada neste catálogo** seguindo o formato acima

3. **Commit e push** para manter o catálogo sincronizado

```bash
git add projects/catalogo.md
git commit -m "catalogo: adiciona <nome-do-projeto>"
git push origin main
```

---

## 📝 Manutenção do Catálogo

| Ação | Quando |
|--------|------|
| **Adicionar projeto** | Novo projeto criado com AGENTS.md |
| **Atualizar status** | Projeto transiciona (ativo → manutenção → arquivado) |
| **Atualizar caminho/URL** | Projeto movido ou publicado |
| **Remover entrada** | Projeto descontinuado (manter em seção de arquivo) |

---

*Última atualização: 2024*  
*Mantenedor: Rodrigo Abreu*