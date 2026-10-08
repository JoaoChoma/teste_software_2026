# Carrinho de Compras — Prática de TDD

## Classes iniciais

O projeto possui inicialmente:

- `Produto`: representa um produto com nome e preço.
- `Carrinho`: classe que deverá ser desenvolvida durante a atividade.
- `CarrinhoTest`: classe onde deverão ser escritos os testes.

A relação esperada será:

```text
Carrinho ──────> Produto
```

O carrinho deverá armazenar e manipular objetos do tipo `Produto`.

---

# Como trabalhar cada requisito

Para **cada requisito**, siga obrigatoriamente o ciclo:

```text
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
    ↓
PRÓXIMO REQUISITO
```

Não implemente antecipadamente funcionalidades dos requisitos seguintes.

---

# Requisito 1 — Carrinho vazio

Um carrinho recém-criado deve possuir **valor total igual a R$ 0,00**.

Antes de implementar a funcionalidade:

1. crie um teste que instancie um `Carrinho`;
2. obtenha o valor total;
3. verifique se o resultado é `0`;
4. execute o teste;
5. somente depois implemente o necessário.

---

# Requisito 2 — Adicionar um produto

O carrinho deve permitir adicionar um produto.

Exemplo de comportamento esperado:

```text
Produto: Teclado
Preço: R$ 100,00

Total esperado do carrinho: R$ 100,00
```

Escreva o teste antes de implementar o método responsável pela adição.

---

# Requisito 3 — Adicionar vários produtos

O carrinho deve permitir adicionar vários produtos e calcular corretamente
a soma de seus preços.

Exemplo:

```text
Teclado ........ R$ 100,00
Mouse .......... R$  50,00
---------------------------
Total .......... R$ 150,00
```

Crie primeiro um teste que represente esse comportamento.

---

# Requisito 4 — Remover produto

Um produto adicionado ao carrinho deve poder ser removido.

Exemplo:

```text
Carrinho inicial:

Teclado ........ R$ 100,00
Mouse .......... R$  50,00
Total .......... R$ 150,00

Remover: Mouse

Total esperado: R$ 100,00
```

Antes de criar o método de remoção, escreva um teste que especifique esse
comportamento.

---

# Requisito 5 — Produto com preço inválido

Produtos com **preço negativo** não devem ser permitidos.

Exemplo inválido:

```text
Produto: Teclado
Preço: R$ -100,00
```

Defina por meio de um teste qual deve ser o comportamento do sistema diante
dessa situação.

> Discuta com o professor se o sistema deve ignorar a operação ou lançar uma
> exceção.

---

# Requisito 6 — Desconto

Compras cujo valor total seja **igual ou superior a R$ 500,00** devem receber
**10% de desconto**.

Exemplo:

```text
Subtotal ........ R$ 600,00
Desconto (10%) .. R$  60,00
----------------------------
Total ........... R$ 540,00
```

Antes de implementar a condição de desconto:

1. escreva um teste;
2. execute-o;
3. confirme que ele falha;
4. implemente somente o necessário;
5. execute novamente.

Considere também testar valores próximos à fronteira:

```text
R$ 499,99
R$ 500,00
R$ 500,01
```

---