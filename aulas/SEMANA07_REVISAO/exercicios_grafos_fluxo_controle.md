# Exercícios — Grafo de Fluxo de Controle

Os exercícios a seguir abordam a construção de **Grafos de Fluxo de Controle (CFG)** a partir de código-fonte.

Para cada exercício, represente:

- os blocos básicos do programa;
- as decisões e suas saídas verdadeira e falsa;
- as arestas que conectam os blocos;
- o retorno dos laços, quando houver;
- o início e o fim do fluxo.

Depois, use o grafo para calcular a complexidade ciclomática e identificar uma base de caminhos independentes.

---

## Exercício 1 — Classificação de pedido

Considere o método Java abaixo:

```java
public String classificarPedido(
        double valor,
        boolean clienteVip,
        boolean pagamentoAprovado) {

    double desconto = 0;

    if (valor >= 500) {
        desconto = 10;
    }

    if (clienteVip) {
        desconto += 5;
    }

    if (!pagamentoAprovado) {
        return "PAGAMENTO RECUSADO";
    }

    double valorFinal = valor - (valor * desconto / 100);
    return "PEDIDO APROVADO: " + valorFinal;
}
```

### Tarefas

1. Divida o método em **blocos básicos**.
2. Identifique todas as **decisões** presentes no código.
3. Desenhe o **Grafo de Fluxo de Controle**.
4. Represente no grafo o encerramento antecipado causado pelo primeiro `return`.
5. Numere os nós e conte:
   - o número de nós `N`;
   - o número de arestas `E`.
6. Calcule a complexidade ciclomática utilizando:

   ```text
   V(G) = E - N + 2
   ```

7. Confira o resultado utilizando:

   ```text
   V(G) = número de decisões + 1
   ```

8. Identifique uma base com **pelo menos quatro caminhos independentes**.
9. Para cada caminho, proponha valores para:
   - `valor`;
   - `clienteVip`;
   - `pagamentoAprovado`.
10. Informe o resultado esperado para cada conjunto de entradas.

### Questões para discussão

- Quantas combinações entre as três condições são possíveis?
- O número de combinações possíveis é igual à complexidade ciclomática? Explique.
- Como o `return` dentro da terceira condição altera o grafo?
- É possível executar o cálculo de `valorFinal` quando o pagamento não foi aprovado?

> **Verificação mínima:** o código possui três decisões. Portanto, o CFG deve permitir a identificação de uma base com, no mínimo, quatro caminhos independentes.

---

## Exercício 2 — Análise de leituras de temperatura

Considere o método Java abaixo:

```java
public int contarAlertas(double[] temperaturas) {
    int alertas = 0;
    int i = 0;

    while (i < temperaturas.length) {
        if (temperaturas[i] < 0) {
            alertas += 2;
        } else if (temperaturas[i] > 35) {
            alertas++;
        }

        i++;
    }

    return alertas;
}
```

### Tarefas

1. Divida o método em **blocos básicos**.
2. Identifique as decisões associadas:
   - à condição do `while`;
   - ao primeiro `if`;
   - ao `else if`.
3. Desenhe o **Grafo de Fluxo de Controle**.
4. Indique claramente no grafo:
   - a entrada no laço;
   - as três possibilidades de classificação da temperatura;
   - o incremento de `i`;
   - a aresta de retorno para a condição do `while`;
   - a saída do laço.
5. Numere os nós e conte `N` e `E`.
6. Calcule a complexidade ciclomática pelas duas fórmulas:

   ```text
   V(G) = E - N + 2
   ```

   ```text
   V(G) = número de decisões + 1
   ```

7. Identifique uma base com **pelo menos quatro caminhos independentes**.
8. Proponha vetores de entrada capazes de exercitar:
   - a saída do laço sem nenhuma iteração;
   - o ramo de temperatura negativa;
   - o ramo de temperatura superior a 35;
   - o ramo em que a temperatura está entre 0 e 35, inclusive.
9. Determine o valor retornado para cada vetor proposto.
10. Explique por que o retorno do laço precisa aparecer no CFG.

### Questões para discussão

- Um vetor com várias temperaturas percorre um único caminho ou pode repetir partes do grafo?
- Qual entrada permite sair do método sem acessar uma posição do vetor?
- Os testes dos valores `0` e `35` ajudam a avaliar quais fronteiras?
- Por que o `else if` deve ser representado como uma nova decisão?

> **Verificação mínima:** o código possui três decisões — uma no laço e duas na seleção interna. Portanto, sua complexidade ciclomática esperada é, no mínimo, quatro.

---

## Critérios para avaliar os grafos

Antes de entregar, confira se:

- cada sequência sem desvio foi agrupada em um bloco básico;
- cada decisão possui as saídas verdadeira e falsa;
- todos os ramos voltam ao fluxo correto;
- o laço apresenta uma aresta de retorno;
- todos os `return` conduzem ao encerramento do método;
- todos os nós são alcançáveis;
- `V(G) = E - N + 2` coincide com `decisões + 1`;
- cada caminho independente acrescenta pelo menos uma aresta ainda não incluída nos caminhos anteriores;
- há dados de teste capazes de executar cada caminho proposto.
