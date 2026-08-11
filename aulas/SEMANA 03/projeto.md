# Exercício: Criação de Casos de Teste

# Fluxo da Atividade

```text
Problema
   │
   ▼
Análise do requisito
   │
   ▼
IA gera os casos de teste (descrição)
   │
   ▼
Análise crítica dos casos
   │
   ▼
IA gera o código dos testes
   │
   ▼
Execução dos testes
   │
   ▼
Análise da cobertura
   │
   ▼
Refinamento dos testes
```

---

# Etapa 1 – Entendimento do Problema

- descrição do problema;
- regras de negócio;
- restrições;
- entradas e saídas esperadas.

---

# Etapa 2 - Construir Casos de Teste

Não escreva código. Apenas descreva os cenários de teste contendo:
>
> - entrada;
> - resultado esperado;
> - justificativa.
---

# Etapa 3 – Solicitar Casos de Teste para a IA

Peça à IA apenas a descrição dos casos de teste.

Exemplo:

> Gere os casos de teste para o seguinte problema. Não escreva código. Apenas descreva os cenários de teste contendo:
>
> - entrada;
> - resultado esperado;
> - justificativa.

---

# Etapa 3 – Revisão Crítica

Analise a resposta da IA.

Verifique se existem:

- casos faltando;
- casos redundantes;
- cenários inválidos;
- interpretação incorreta do requisito;
- casos de fronteira ausentes;
- entradas inválidas não contempladas.

Se necessário, refine os casos antes de prosseguir.

---

# Etapa 4 – Gerar o Código dos Testes

Somente após aprovar os casos de teste, solicite à IA a implementação.

Exemplo:

> Implemente os casos de teste em JUnit 5.

ou

> Implemente utilizando Jest.

---

# Etapa 5 – Executar os Testes

Execute todos os testes na IDE.

Observe:

- testes aprovados;
- testes falhando;
- erros de implementação;
- erros nos próprios testes.

---

# Etapa 6 – Medir a Cobertura

Utilize a ferramenta de cobertura da IDE.

Analisar:

- Statement Coverage
- Branch Coverage
- Condition Coverage (quando disponível)

Responder:

- A cobertura foi suficiente?
- Alguma parte do código não foi testada?

---

# Etapa 7 – Refinamento

Caso a cobertura seja baixa:

- identifique os trechos não executados;
- descubra quais cenários estão faltando;
- peça novos casos para a IA;
- implemente apenas os testes necessários.

Repita até obter uma cobertura satisfatória.

---

# O que será avaliado

Não será considerada apenas a cobertura.

Também serão avaliados:

- entendimento do problema;
- qualidade dos casos de teste;
- identificação de cenários importantes;
- capacidade de revisar criticamente a resposta da IA;
- organização dos testes;
- justificativas apresentadas.

---

# Resultado Esperado

Ao final da atividade, o aluno deverá ser capaz de:

- interpretar requisitos;
- elaborar casos de teste de forma estruturada;
- utilizar IA generativa como ferramenta de apoio;
- identificar limitações da IA;
- implementar testes automatizados;
- analisar cobertura de código;
- refinar testes com base nos resultados obtidos.