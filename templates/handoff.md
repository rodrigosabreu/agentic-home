# Task: <identificador e descrição>

- **Project**: <projeto responsável>
- **Owner**: <agente ou responsável>
- **Status**: <pending | in-progress | blocked | done>
- **Approved**: <decisão, data e aprovador>
- **Waiting**: <pendência ou dependência>
- **Next action**: <próxima ação concreta e executável>

---

## Artifacts
- <caminho real do artefato 1>
- <caminho real do artefato 2>
- <caminho real do artefato N>

---

## History
- **YYYY-MM-DD HH:MM** | <etapa> | <ação executada e resultado obtido>
- **YYYY-MM-DD HH:MM** | <etapa> | <ação executada e resultado obtido>

---

## Validation
- **Checks executed**: <lista de verificações executadas>
- **Results**: <resultados de cada verificação>
- **Pending**: <itens pendentes de validação>

---

## Notes
- <observações adicionais, bloqueios, decisões tomadas>

---

## Rules (Reference)

1. **Task state lives in the responsible project** — not in the Home
2. **History is append-only** — never rewrite previous entries
3. **Record real artifact paths** — not placeholders
3. **Do not mark as approved without evidence** — link to PR, test results, approval record
4. **On blockage** — record the reason, update Status to `blocked`, and stop execution safely
5. **New session continuity** — a new session must be able to continue from this handoff alone