# Bubble Sort — Prática de TDD

## Objetivo

Implementar uma classe orientada a objetos responsável por ordenar um vetor de números inteiros utilizando o algoritmo **Bubble Sort**.

## Estrutura esperada

A classe `BubbleSort` possui:

- um vetor de números inteiros;
- um construtor que recebe o vetor;
- o método `ordenar()`;
- o método `getNumeros()` para consultar o vetor.

O método `ordenar()` deverá ser implementado pelos alunos.

---

## Requisito 1 — Ordenar um vetor desordenado

O sistema deve ordenar os números em ordem crescente.

### Exemplo

```text
Entrada:
[5, 3, 1, 4, 2]

Resultado esperado:
[1, 2, 3, 4, 5]
```

---

## Requisito 2 — Manter um vetor já ordenado

Caso o vetor já esteja em ordem crescente, sua ordem deve permanecer inalterada.

### Exemplo

```text
Entrada:
[1, 2, 3, 4, 5]

Resultado esperado:
[1, 2, 3, 4, 5]
```

---

## Requisito 3 — Ordenar valores repetidos

O algoritmo deve ordenar corretamente vetores que contenham valores repetidos, preservando todas as ocorrências.

### Exemplo

```text
Entrada:
[3, 1, 3, 2, 1]

Resultado esperado:
[1, 1, 2, 3, 3]
```

---

## Execução

Antes de implementar `ordenar()`, execute:

```bash
mvn test
```

Observe os testes que falham.

Implemente então o algoritmo progressivamente e execute novamente os testes até que todos estejam passando.

```text
TESTES
   ↓
RED
   ↓
IMPLEMENTAÇÃO
   ↓
GREEN
   ↓
REFACTOR
```

## Restrição

Não altere os casos de teste fornecidos para fazer a implementação passar.
