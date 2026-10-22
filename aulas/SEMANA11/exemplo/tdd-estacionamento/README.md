# TDD — Estacionamento (Java 17 + Maven + JUnit 5)

Projeto de referência **com implementação concluída** para orientar a demonstração ao vivo. Na aula, comece com um projeto Maven vazio e escreva os testes antes de criar `Estacionamento`.

## Executar

```bash
mvn test
```

Abra a pasta do projeto no IntelliJ IDEA como projeto Maven. É necessário Java 17 e Maven (ou usar o Maven integrado da IDE).

## Requisitos e testes

| Regra | Comportamento | Testes |
|---|---|---|
| RN01 | Criar estacionamento com capacidade máxima informada | `deveArmazenarCapacidadeMaxima`, `deveArmazenarOutraCapacidadeMaxima` |
| RN02 | Iniciar com ocupação zero | `deveIniciarComZeroVeiculos` |
| RN03 | Cada entrada aumenta a ocupação em uma unidade | `deveAdicionarUmVeiculo`, `deveAcumularEntradas` |
| RN04 | Impedir entrada acima da capacidade | `naoDevePermitirEntradaQuandoLotado` |

## Roteiro de demonstração (RED → GREEN → REFACTOR)

1. **RN02:** escreva `deveIniciarComZeroVeiculos()` antes de existir a classe. Use `Alt+Enter` para gerar classe, construtor e `getOcupacao()`. Com método lançando `UnsupportedOperationException`, observe RED. Retorne `0` para GREEN.
2. **RN01:** escreva `deveArmazenarCapacidadeMaxima()`. Gere `getCapacidadeMaxima()` e retorne provisoriamente `0` (RED). Retorne `10` (GREEN apenas para esse cenário). Adicione teste com `25` (RED); armazene o argumento em um campo e retorne o campo (GREEN). Renomeie parâmetro `i` para `capacidadeMaxima` com `Shift+F6` (REFACTOR).
3. **RN03:** escreva teste que chama `adicionarVeiculo()`. Gere método vazio (RED: ocupação continua zero). Crie campo `ocupacao`, incremente com `ocupacao++` e retorne o campo em `getOcupacao()` (GREEN). Teste duas entradas.
4. **RN04:** escreva teste de estacionamento lotado. Preencha 3 vagas, tente quarta entrada e verifique `assertThrows(IllegalStateException.class, ...)` **e** ocupação preservada em 3 (RED). Valide antes de incrementar (GREEN). Opcional: extrair validação em método privado (REFACTOR).

**Correções de inconsistências nos slides fornecidos:** a entrada de um veículo aumenta a ocupação em **1**, não em 10; o código correto é `ocupacao++`, não `this.ocupacao += ocupacao`; o slide intitulado RN04 deve também mencionar RN04 no corpo (não RN05). A numeração de CTs deve ser padronizada conforme a aula.

## Estrutura

```text
pom.xml
src/main/java/br/uem/tdd/Estacionamento.java
src/test/java/br/uem/tdd/EstacionamentoTest.java
```

O exemplo cobre apenas criação, ocupação, entrada e lotação. Saída de veículos e validação de capacidade não fazem parte desta versão.
