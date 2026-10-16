# Teste de Integração — Maven + JUnit 5

Exemplo didático para comparar teste unitário e teste de integração.

- `EstoqueServiceTest`: testa `EstoqueService` isoladamente.
- `PedidoServiceIntegrationTest`: testa a integração real entre `PedidoService` e `EstoqueService`.

## Executar

```bash
mvn test
```
# ATIVIDADE

1. Implementar uma classe ProdutoEntity;
2. Substituir int quantidade por uma lista de Pedidos ProdutoEntity;
3. Refatorar todo o código para garantir o funcionamento do novo requisito;
4. Testar o relacionamento de todas as classes;
5. Alcançar 100 % de cobertura dos testes de integração;
