# Estoque — Exemplo de TDD

Projeto Maven com Java 17 e JUnit 5 para demonstração de TDD.

## Executar

```bash
mvn test
```

## Casos de teste

1. Produto inicia com estoque zero.
2. Adicionar unidades ao estoque.
3. Acumular várias entradas.
4. Retirar unidades do estoque.
5. Não permitir retirada maior que o estoque disponível.
6. Não permitir entrada com quantidade negativa.

A proposta didática é construir a implementação incrementalmente, executando
os testes durante os ciclos RED → GREEN → REFACTOR.
