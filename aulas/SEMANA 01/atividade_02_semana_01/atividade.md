# Atividade prática 02 — Dos artefatos ao teste de login

## Questão central

Um login parece ter apenas duas saídas:

- **true:** acesso concedido;
- **false:** acesso negado.

Entretanto, usuário e senha pertencem a classes diferentes e podem formar várias
combinações. Nesta atividade, a equipe usará artefatos de teste para selecionar um
conjunto pequeno, justificável e reproduzível de casos.

## Objetivos

Ao final, a equipe deverá ser capaz de:

- transformar requisitos em classes de equivalência;
- distinguir classe de entrada de resultado do teste;
- combinar classes sem testar todas as possibilidades;
- elaborar plano, matriz de partições e casos de teste;
- executar casos em um microprojeto real;
- registrar resultado observado, evidência e defeito.

## Sistema sob teste

Abra `index.html`. O microprojeto **LoginLab** possui três contas conhecidas:

| Usuário | Senha | Estado |
|---|---|---|
| `aluno01` | `Teste@123` | ativo |
| `professor01` | `Aula@2026` | ativo |
| `bloqueado01` | `Segura@456` | bloqueado |

## Requisitos

- **RN-LOGIN-01:** usuário e senha são obrigatórios.
- **RN-LOGIN-02:** usuário ativo com a senha correspondente deve autenticar.
- **RN-LOGIN-03:** senha incorreta não deve autenticar.
- **RN-LOGIN-04:** usuário inexistente não deve autenticar.
- **RN-LOGIN-05:** usuário bloqueado não deve autenticar, mesmo com senha correta.
- **RN-LOGIN-06:** credencial inválida deve exibir a mensagem genérica
  `Usuário ou senha inválidos`.
- **RN-LOGIN-07:** conta bloqueada deve exibir `Conta bloqueada. Procure o suporte`.
- **RN-LOGIN-08:** a comparação da senha diferencia maiúsculas e minúsculas.
- **RN-LOGIN-09:** falhas de autenticação não devem criar sessão.

## Parte 1 — Produzir os artefatos antes de testar

### 1. Plano de teste

Use `modelos/plano_de_teste.md` para definir:

- objetivo e decisão apoiada;
- escopo e fora de escopo;
- riscos e prioridades;
- estratégia e técnica;
- ambiente e massa de dados;
- critérios de entrada, saída, suspensão e retomada.

### 2. Classes de equivalência

Use `modelos/classes_de_equivalencia.md`.

#### Campo usuário

Considere ao menos:

- usuário cadastrado e ativo;
- usuário cadastrado e bloqueado;
- usuário inexistente;
- usuário vazio.

#### Campo senha

Considere ao menos:

- senha correta para o usuário informado;
- senha incorreta com formato válido;
- senha com diferença de maiúsculas/minúsculas;
- senha vazia.

> “Senha correta” não é uma propriedade isolada: ela depende do usuário com o qual
> foi combinada.

### 3. Matriz de combinações

Nem todo cruzamento precisa virar um caso. Escolha representantes que:

- cubram cada classe pelo menos uma vez;
- isolem o motivo da rejeição;
- priorizem riscos de segurança;
- evitem combinações redundantes.

Exemplo conceitual:

| Classe de usuário | Classe de senha | Resultado |
|---|---|---|
| ativo | correspondente | true |
| ativo | incorreta | false |
| inexistente | qualquer não vazia | false |
| bloqueado | correspondente | false |
| vazio | qualquer | false |

### 4. Casos de teste

Use `modelos/casos_de_teste.md` e escreva entre **8 e 10 casos**.

Cada caso deve ter:

- ID e título;
- requisitos e riscos relacionados;
- pré-condições;
- usuário e senha concretos;
- passos;
- resultado esperado observável;
- prioridade.

Resultado real e status permanecem vazios até a execução.

## Parte 2 — Executar o microprojeto

Para cada caso:

1. selecione **Limpar sessão**;
2. informe usuário e senha;
3. selecione **Entrar**;
4. registre mensagem, estado da sessão e status;
5. capture evidência se houver divergência.

Use `modelos/registro_de_execucao.md`.

## Parte 3 — Interpretar

Ao final, responda:

1. Quantas classes de usuário foram identificadas?
2. Quantas classes de senha foram identificadas?
3. Por que não basta criar um caso `true` e um caso `false`?
4. Quais combinações diferentes produziram `false`?
5. A mensagem exibida revela se um usuário está cadastrado?
6. Alguma divergência deve bloquear a liberação?

Se houver falha, preencha `modelos/defeito.md`.

## Entregáveis

1. plano de teste;
2. tabela de classes de equivalência;
3. matriz de combinações selecionadas;
4. 8 a 10 casos de teste;
5. registro de execução;
6. evidências das divergências;
7. relatório de defeito, se aplicável;
8. conclusão de liberação.

## Tempo sugerido

- 20 minutos: requisitos, riscos e plano;
- 20 minutos: partições e combinações;
- 20 minutos: casos de teste;
- 25 minutos: execução e evidências;
- 15 minutos: revisão e decisão.

## Critérios de avaliação

| Critério | Peso |
|---|---:|
| Classes derivadas dos requisitos | 25% |
| Seleção não redundante de combinações | 20% |
| Clareza e reprodutibilidade dos casos | 20% |
| Registro do observado e evidências | 20% |
| Rastreabilidade e decisão final | 15% |

