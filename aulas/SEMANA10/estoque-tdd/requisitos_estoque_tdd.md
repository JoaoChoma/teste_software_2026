# Estoque de Produtos --- Prática de TDD

A classe `Produto` deverá armazenar o nome do produto e sua quantidade
disponível em estoque.

Para cada novo requisito, siga o ciclo:

``` text
REQUISITO
    ↓
ESCREVER O TESTE
    ↓
EXECUTAR
    ↓
RED
    ↓
IMPLEMENTAR O MÍNIMO NECESSÁRIO
    ↓
EXECUTAR
    ↓
GREEN
    ↓
REFACTOR
```

------------------------------------------------------------------------

## Requisito 1 --- Estoque inicial

Ao criar um novo produto, sua quantidade inicial em estoque deve ser
**zero**.

### Exemplo

``` text
Produto: Teclado
Quantidade esperada: 0
```

Crie um teste que verifique esse comportamento.

------------------------------------------------------------------------

## Requisito 2 --- Adicionar unidades ao estoque

O sistema deve permitir adicionar unidades ao estoque de um produto.

### Exemplo

``` text
Produto: Teclado
Estoque inicial: 0
Adicionar: 10 unidades

Estoque esperado: 10 unidades
```

Escreva o teste antes de implementar o comportamento.

------------------------------------------------------------------------

## Requisito 3 --- Acumular entradas no estoque

Quando novas unidades forem adicionadas mais de uma vez, a quantidade
deve ser acumulada.

### Exemplo

``` text
Estoque inicial: 0

Adicionar: 10 unidades
Adicionar: 5 unidades

Estoque esperado: 15 unidades
```

Crie primeiro um teste que represente esse comportamento.

------------------------------------------------------------------------

## Requisito 4 --- Retirar unidades do estoque

O sistema deve permitir retirar unidades do estoque quando houver
quantidade disponível.

### Exemplo

``` text
Estoque disponível: 10 unidades
Retirar: 3 unidades

Estoque esperado: 7 unidades
```

Escreva o teste antes de implementar o método responsável pela retirada.

------------------------------------------------------------------------

## Requisito 5 --- Não permitir estoque negativo

O sistema não deve permitir a retirada de uma quantidade maior do que o
estoque disponível.

### Exemplo

``` text
Estoque disponível: 10 unidades
Tentativa de retirada: 15 unidades

Estoque esperado: 10 unidades
```

A operação inválida não deve alterar a quantidade disponível.

------------------------------------------------------------------------

## Requisito 6 --- Não permitir entrada negativa

Não deve ser possível adicionar ao estoque uma quantidade negativa ou
igual a zero.

### Exemplo

``` text
Estoque inicial: 0
Tentativa de adicionar: -10 unidades

Estoque esperado: 0
```

A operação inválida não deve alterar o estoque.