# Central de pedidos — laboratório de teste estrutural

Projeto Java 17, Maven, JUnit **5** e JaCoCo. A implementação está pronta; sua tarefa é redigir os testes. Não há banco, rede, interface gráfica nem necessidade de Mockito. O domínio amplia o exemplo OO do material `aula_teste_estrutural_mccabe_grafos_v3.pdf`.

## Começar

Requisitos: JDK 17 ou superior e Maven 3.9+. Abra esta pasta como projeto Maven na IDE e aguarde a importação das dependências (a primeira execução precisa de internet).

```sh
cd aulas/SEMANA06/central-pedidos
mvn test
```

Escreva os testes nas classes já criadas em `src/test/java/br/edu/ifpr/pedidos`. Use métodos com `@Test` ou `@ParameterizedTest` e asserções do JUnit Jupiter. Os nomes devem terminar em `Test`. `junit-jupiter` inclui suporte a testes parametrizados.

Para executar o exemplo e os testes que você acrescentar:

```sh
mvn clean test
```

Abra `target/site/jacoco/index.html` no navegador. XML e CSV ficam na mesma pasta; resultados dos testes ficam em `target/surefire-reports`. `mvn clean verify` também executa os testes e gera o relatório. Não há limite mínimo automático de cobertura, para permitir evolução gradual.

**Estado inicial:** `PedidoServiceTest` contém um teste de exemplo; as demais classes de teste ficam como exercícios. O exemplo verifica cliente comum, item disponível, entrega normal no PR, ausência de desconto e pagamento aprovado, incluindo uma única cobrança de R$ 112,00.

### Abertura da aula

1. Leia o teste em `PedidoServiceTest` e identifique preparação, execução e verificação.
2. Execute `mvn -Dtest=PedidoServiceTest clean test` e abra o relatório JaCoCo.
3. Siga o caminho do teste em `PedidoService.fechar` e entre nas classes colaboradoras.
4. Observe que várias classes foram executadas, mas alternativas continuam descobertas. Peça à turma que escolha o próximo caminho e derive seu resultado esperado antes de escrever o teste.

O exemplo é um ponto de partida, não uma suíte completa nem uma base de caminhos independentes.

## Problema e contrato

Uma loja precisa fechar pedidos, aplicar descontos e frete, analisar risco e tentar cobrar. Todos os valores monetários são inteiros em **centavos**, com divisões percentuais truncadas para baixo. Os objetos de entrada são imutáveis; não há reserva de estoque nem alteração do histórico do cliente. Cada fechamento é uma simulação independente, sem idempotência.

### Entradas

- `Cliente(vip, bloqueado, comprasAnteriores)`: histórico não negativo.
- `ItemPedido(sku, precoCentavos, quantidade, estoque, pesoGramas, fragil)`: SKU não nulo/nem branco; preço de 1 a 1.000.000 centavos; quantidade de 0 a 100; estoque não negativo; peso unitário de 1 a 100.000 gramas. Zero unidades representa uma linha inativa.
- `Pedido(itens, uf, expresso, cupom)`: lista não nula, até 100 linhas, copiada defensivamente. Elementos nulos causam `NullPointerException`. UF deve conter exatamente duas letras ASCII maiúsculas; qualquer código desse formato é aceito e usa a tarifa padrão se não for PR/SP/RJ. Cupom pode ser nulo ou branco.
- Demais violações acima causam `IllegalArgumentException`. Dependências e argumentos obrigatórios nulos em `PedidoService`/`PagamentoService` causam `NullPointerException`. Nos métodos auxiliares, forneça objetos não nulos. Valores monetários negativos são rejeitados. Para cálculos isolados, mantenha os valores dentro do domínio de pedidos (subtotal até 10 bilhões de centavos).
- Estoque é avaliado por linha, independentemente de SKUs repetidos. Item inativo não soma valor, peso nem fragilidade. Lista vazia é válida na construção, mas não no fechamento de cliente desbloqueado.

### Desconto (`PoliticaDesconto`)

1. VIP recebe 10%; cliente comum recebe 5% se subtotal ≥ R$ 500,00; demais recebem zero.
2. Cupom nulo/branco mantém esse desconto. Cupons são normalizados com `trim` e maiúsculas.
3. `BEMVINDO` soma R$ 20,00 somente se não houver compras anteriores e subtotal ≥ R$ 100,00.
4. `EXTRA10` soma 10% se subtotal ≥ R$ 200,00.
5. Cupom conhecido sem elegibilidade não acrescenta desconto. Cupom desconhecido lança `IllegalArgumentException`.
6. O desconto combinado é limitado a 20% do subtotal.

### Frete (`CalculadoraFrete`)

Nesta ordem:

1. Base: PR R$ 12,00; SP/RJ R$ 20,00; demais R$ 30,00.
2. Acima de 2 kg, acrescentar R$ 3,00 por kg adicional **ou fração**, usando laço.
3. Valor líquido (subtotal menos desconto) ≥ R$ 300,00 e entrega normal zeram base e adicional de peso.
4. VIP paga metade desse valor.
5. Expresso acrescenta R$ 15,00; presença de item frágil ativo acrescenta R$ 5,00 uma única vez. Esses adicionais também incidem quando a base foi zerada.

### Risco (`AnaliseRisco`)

- Bloqueado: `RECUSADO`.
- Sem compras anteriores: `REVISAO` se total > R$ 1.000,00 **ou** entrega expressa.
- Com compras anteriores: `REVISAO` se total > R$ 5.000,00 **e** cliente não VIP.
- Demais: `APROVADO`.

### Pagamento (`PagamentoService`)

`ProcessadorPagamento.autorizar(total)` é a única dependência externa, substituída por lambda ou stub escrito pelo aluno. Retorno `true` aprova; `false` recusa imediatamente, sem repetir. `IllegalStateException` simula indisponibilidade temporária e permite repetir até o limite. Esgotar tentativas retorna `false`; outras exceções propagam. Total deve ser positivo; limite deve estar entre 1 e 3. Não há espera nem aleatoriedade.

Para instanciar o serviço sem integração real, `new PedidoService(total -> true)` simula aprovação. Para sequências de falhas/sucesso, crie um stub com contador; confira número de chamadas e valor recebido.

### Fechamento (`PedidoService`)

A ordem é parte do contrato: validar referências → cliente bloqueado → subtotal ativo → estoque → desconto → frete → risco → pagamento (até três tentativas).

- Bloqueado retorna `BLOQUEADO` com todos os valores zero, antes de avaliar itens e cupom.
- Subtotal zero lança `IllegalArgumentException`.
- Falta de estoque retorna `SEM_ESTOQUE` com valores zero, antes do cupom.
- Risco pendente retorna `REVISAO`, com valores calculados e nenhuma cobrança.
- Após análise aprovada, pagamento produz `PAGO` ou `PAGAMENTO_RECUSADO`, ambos com os valores calculados.
- Exceções não tratadas interrompem o fechamento. Valide também que o processador não foi chamado quando a execução terminou antes do pagamento.

## Roteiro de trabalho (sem gabarito)

1. Desenhe o relacionamento entre classes e o grafo de chamadas de `fechar`.
2. Construa CFGs de `calcular` nas duas calculadoras, `avaliar`, `pagar` e `fechar`. Identifique blocos, decisões, retornos e tratamento de exceções. Declare se cada condição de curto-circuito é um nó separado e como unificou as saídas.
3. Conte nós/arestas e calcule `V(G) = E − N + 2` para cada grafo conectado com saída unificada. Use decisões + 1 apenas quando o modelo permitir; um switch com várias saídas exige contagem adequada.
4. Proponha uma base de caminhos independentes, indicando dados que realizam cada caminho. Se um caminho for inviável, explique a restrição; não altere a implementação para forçá-lo.
5. Escreva testes unitários por classe, depois testes de colaboração pelo serviço. Verifique resultados e efeitos observáveis, não apenas ausência de exceção.
6. Evolua a cobertura e registre o que cada novo teste acrescentou. Faça uma pequena alteração proposital numa regra, confirme que um teste falha e desfaça a alteração antes de entregar.

| Recurso | Onde investigar | Variações a justificar |
| --- | --- | --- |
| Linhas, métodos e classes | Todas as classes concretas | Métodos auxiliares e construtores também importam |
| Ramos/branches | Desconto, frete e risco | Verdadeiro/falso, cases e default |
| Curto-circuito `&&`/`||` | Validações, cupons e risco | Operando direito avaliado ou não |
| Decisões independentes | Frete | Combinações de gratuidade, VIP, expresso e fragilidade |
| `for`, `continue`, `break` | Pedido | Zero/uma/várias linhas; inativos; falta de estoque no início/fim |
| `while` | Peso excedente no frete | Zero/uma/várias iterações; kg exato e fração |
| `do/while`, `try/catch` | Pagamento | Uma/várias tentativas; sucesso, recusa, esgotamento e propagação |
| Retornos antecipados | Serviço e risco | Regras posteriores não executadas |
| Estado entre chamadas | Stub do processador | Ordem, quantidade de tentativas e argumentos |

Explore limites imediatamente abaixo, iguais e acima de cada limiar; valores inválidos; cupons com espaços/minúsculas; cópia da lista; e centavos que causem truncamento. Construa resultados esperados a partir das regras, sem chamar a própria implementação para produzir o oráculo.

### Como interpretar a cobertura

**Branches e ramos são o mesmo critério neste exercício.** O JaCoCo apresenta instruções, branches, linhas, complexidade, métodos e classes. Cobertura de classe significa que ao menos um método foi executado, não que toda a classe foi testada. Não excluímos classes de domínio do relatório; código gerado pode ser filtrado pelo próprio JaCoCo.

O JaCoCo **não mede cobertura de caminhos completos** nem garante MC/DC. Cobrir todos os ramos não equivale a exercitar todas as combinações; laços multiplicam caminhos. Use caminhos básicos e limites de iteração justificados, sem exigir enumeração exaustiva. Tratamento de exceções não é contado como branch pelo JaCoCo; teste-o mesmo assim. Um caminho possível em `AnaliseRisco` pode não ser alcançável via `PedidoService`, devido a um retorno anterior: compare teste unitário e colaboração.

Meta: executar todas as classes concretas e métodos de negócio e buscar 100% das linhas e branches alcançáveis. Documente lacunas e caminhos inviáveis; percentuais não substituem asserções nem comprovam ausência de defeitos.

## Entrega

- Testes JUnit 5 em `src/test/java`, sem alterar as regras de produção.
- Relatório JaCoCo gerado após `mvn clean test` e resumo de linhas, branches, métodos e classes.
- CFGs, cálculos de McCabe, base de caminhos e matriz preenchida em `RELATORIO.md`.
- Discussão de um caso em que cobertura de ramos não demonstra cobertura de caminhos e de uma exceção não representada no contador de branches.

Referências: [JUnit 5](https://junit.org/junit5/docs/5.11.1/user-guide/index.html), [contadores JaCoCo](https://www.jacoco.org/jacoco/trunk/doc/counters.html), [análise de fluxo JaCoCo](https://www.jacoco.org/jacoco/trunk/doc/flow.html).
