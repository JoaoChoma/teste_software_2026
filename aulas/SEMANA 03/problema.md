# Exercício – Geração de Casos de Teste

## Contexto

Uma locadora de veículos deseja automatizar o cálculo do valor final da locação de um carro.

O sistema recebe algumas informações sobre a locação e retorna o valor total a ser pago pelo cliente.

Seu objetivo será utilizar IA para auxiliar na criação dos casos de teste e, posteriormente, implementar os testes automatizados.

---

# Requisitos

## R1 – Valor da diária

O sistema recebe:

- quantidade de dias de locação
- valor da diária

O valor das diárias é calculado por:

```
valorDiarias = dias × valorDiaria
```

---

## R2 – Quilometragem

A locação possui uma franquia de **100 km por dia**.

Caso o cliente ultrapasse essa franquia, deverá pagar:

```
R$ 0,50 por quilômetro excedente
```

Exemplo:

- 3 dias
- franquia = 300 km
- percorreu 340 km

Excedente = 40 km

Valor adicional = R$ 20,00

---

## R3 – Seguro

O cliente pode contratar seguro.

Caso contrate:

Adicionar:

```
R$ 35,00 por dia
```

Caso contrário:

Adicionar:

```
R$ 0,00
```

---

## R4 – Desconto por tempo de locação

Quando o período de locação for:

| Dias | Desconto |
|-------|-----------|
| até 6 dias | nenhum |
| de 7 a 14 dias | 5% sobre o valor das diárias |
| acima de 14 dias | 10% sobre o valor das diárias |

O desconto incide **somente sobre o valor das diárias**.

Não incide sobre:

- seguro
- quilometragem excedente

---

## R5 – Idade do motorista

Caso o motorista tenha menos de **21 anos** deverá ser cobrada uma taxa adicional de:

```
R$ 150,00
```

Caso contrário:

```
R$ 0,00
```

---

## R6 – Entradas inválidas

O sistema deve lançar uma exceção quando ocorrer qualquer uma das situações abaixo:

- dias ≤ 0
- valor da diária ≤ 0
- idade ≤ 17
- quilometragem negativa

---

## R7 – Resultado

O sistema retorna o valor final da locação.

---

# Assinatura do método

```java
double calcularValorLocacao(
        int dias,
        double valorDiaria,
        int quilometrosPercorridos,
        boolean possuiSeguro,
        int idadeMotorista
)
```

---

# Exemplo

### Entrada

```text
dias = 10
valorDiaria = 120
quilometros = 1200
seguro = true
idade = 30
```

### Cálculo

Diárias

```
10 × 120 = 1200
```

Desconto

```
5%

1200 × 0,05 = 60
```

Valor das diárias

```
1140
```

Seguro

```
10 × 35 = 350
```

Franquia

```
10 × 100 = 1000 km
```

Excedente

```
1200 − 1000 = 200 km
```

Valor excedente

```
200 × 0,50 = 100
```

Taxa por idade

```
0
```

Valor final

```
1140 + 350 + 100 = R$ 1.590,00
```

---

# Tarefa

Etapa 01:

1. Produzir os casos de teste (sem código).
2. Revisar criticamente os casos gerados.
3. Solicitar à IA a implementação dos testes em **JUnit 5**.
4. Executar os testes.
5. Avaliar a cobertura de código.
6. Criar novos testes caso a cobertura seja insuficiente.

---

Etapa 02 - Utilize uma IA generativa para:

1. Produzir os casos de teste (sem código).
2. Revisar criticamente os casos gerados.
3. Solicitar à IA a implementação dos testes em **JUnit 5**.
4. Executar os testes.
5. Avaliar a cobertura de código.
6. Criar novos testes caso a cobertura seja insuficiente.