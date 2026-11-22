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

*Nenhum projeto registrado ainda. Adicione seu primeiro projeto abaixo.*

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
*Mantenedor: [Seu Nome]*