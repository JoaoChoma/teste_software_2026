# Boletim simples — primeiros testes unitários e cobertura

Projeto pequeno para a SEMANA06: **duas classes, quatro métodos e um teste de exemplo**. Usa Java 17, Maven, JUnit 5 e JaCoCo. O código utiliza variáveis, operações aritméticas, `if/else`, um array e um `for`.

## Executar

Com JDK 17 ou superior e Maven 3.9+ instalados, abra esta pasta como projeto Maven na IDE. A primeira execução precisa de internet para baixar as dependências.

```sh
cd aulas/SEMANA06/boletim-simples
mvn clean test
```

Abra `target/site/jacoco/index.html` no navegador. O relatório é gerado automaticamente após os testes. Não é necessário criar `main`: o JUnit executa os métodos anotados com `@Test`.

## O problema

Um professor quer calcular médias, classificar alunos, contar aprovações e atribuir pontos de participação. Os pontos de participação são uma contagem separada: não alteram a média.

| Classe e método | Regra |
| --- | --- |
| `Boletim.calcularMedia` | Média aritmética de duas notas, sem arredondamento |
| `Boletim.verificarSituacao` | Média ≥ 7: `APROVADO`; média ≥ 4 e < 7: `RECUPERACAO`; média < 4: `REPROVADO` |
| `Boletim.contarAprovados` | Conta quantas médias do array são ≥ 7; array vazio retorna zero |
| `Participacao.calcularPontos` | Entregou atividade: +2; participou da aula: +1; os pontos se acumulam |

Para este exercício introdutório, considere somente notas e médias de 0 a 10 e arrays não nulos. A validação de entradas está fora do escopo. Os alunos devem escrever testes em `src/test/java`, sem modificar as regras de produção.

## Comece pelo exemplo

Abra `BoletimTest.java`. O teste fornecido contém apenas três passos:

```java
Boletim boletim = new Boletim();
String resultado = boletim.verificarSituacao(8);
assertEquals("APROVADO", resultado);
```

Explique: criamos o objeto, chamamos o método e conferimos a resposta. No `assertEquals`, o primeiro argumento é o esperado; o segundo é o obtido. O teste falha se os valores forem diferentes.

Esse teste verifica **uma unidade e um caminho**: média maior ou igual a sete. Ele não passa por recuperação ou reprovação e não chama os outros métodos.

## Sequência sugerida para a aula

1. Execute o teste fornecido. Abra o JaCoCo, entre no pacote e clique em `Boletim` para ver o código colorido.
2. Identifique o trecho executado e os trechos ainda descobertos. Mostre que executar uma classe não significa executar todos os seus métodos.
3. Peça um teste para recuperação e outro para reprovação. Execute novamente e observe a mudança nos ramos e linhas de `verificarSituacao`.
4. Peça um teste de `calcularMedia`. Use também notas cuja média tenha parte decimal. Para `double`, explique `assertEquals(esperado, obtido, 0.0001)`: o terceiro argumento é a tolerância.
5. Abra `Participacao`, que ainda não foi executada. Peça testes variando seus dois booleanos e observe a cobertura da segunda classe.
6. Por último, apresente o `for` de `contarAprovados`. Trabalhe com array vazio, um elemento e vários elementos, incluindo aprovados e não aprovados. Um array pode ser escrito como `new double[] {8, 5, 7}`; o vazio é `new double[] {}`.

Sempre use métodos anotados com `@Test` nas classes cujo nome termina em `Test`. Após acrescentar testes, rode `mvn clean test` e atualize a página do relatório. Para demonstrar uma falha, mude temporariamente o resultado esperado do exemplo e depois restaure-o.

## O que observar no JaCoCo

| Elemento | Explicação para a turma |
| --- | --- |
| Classe | Algum método dessa classe foi executado? |
| Método | Esse método foi chamado durante os testes? |
| Linha | As instruções dessa linha foram executadas? |
| Branch ou ramo | As alternativas verdadeira e falsa de cada decisão foram exercitadas? |
| Complexidade ciclomática (`Cxty`) | Medida de McCabe associada à base de caminhos independentes |

No código colorido, vermelho indica instruções não cobertas, verde indica cobertas e amarelo indica cobertura parcial. Os losangos ao lado das decisões mostram a cobertura dos branches. Construtores também podem aparecer entre os métodos, mesmo sem terem sido escritos explicitamente.

### Uma explicação pequena sobre caminhos

Em `verificarSituacao`, há três caminhos: aprovação, recuperação e reprovação. Desenhe os dois `if` e os três retornos; a complexidade ciclomática é 3.

Em `Participacao.calcularPontos`, também há duas decisões e complexidade 3, mas são decisões independentes. Existem quatro combinações de entrada: verdadeiro/verdadeiro, verdadeiro/falso, falso/verdadeiro e falso/falso. Peça à turma que percorra o código com cada combinação.

Dois testes, um com ambos verdadeiros e outro com ambos falsos, já cobrem todos os ramos de `calcularPontos`. Mesmo assim, deixam duas combinações sem execução. O JaCoCo deriva a complexidade coberta/perdida dos branches; não registra uma lista de caminhos completos para comprovar que uma base independente foi executada.

Referência para os contadores: [documentação do JaCoCo](https://www.jacoco.org/jacoco/trunk/doc/counters.html).

## Exercícios para os alunos

- Completar os testes dos quatro métodos.
- Verificar os limites 4 e 7 da classificação.
- Exercitar o laço com zero, uma e várias iterações.
- Buscar 100% de linhas, branches, métodos e classes e explicar o que cada percentual significa.
- Mostrar quais entradas correspondem a cada caminho de `calcularPontos`.

A cobertura mostra o que foi executado. As asserções verificam se a resposta está correta; precisamos dos dois.
