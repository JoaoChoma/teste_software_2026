# Lista prática — Testes de integração com Spring Boot e JUnit 5

**Tecnologias:** Java 17, Maven, Spring Boot 3.x, Spring Data JPA, H2, JUnit 5 e MockMvc.  
**Entrega:** repositório GitHub com o código e `README.md` descrevendo os testes executados.  
**Orientação:** usar o projeto-base fornecido; completar os métodos `TODO` das classes de teste. Não utilizar mocks para substituir `ProdutoRepository` ou `ProdutoService` nos exercícios.

## Exercício 1 — Integração entre Service, Repository e banco H2

**Objetivo:** verificar que as regras de cadastro e atualização se integram à persistência real.

**Cenário:** o serviço recebe dados de um produto, valida as regras e utiliza `ProdutoRepository` para armazenar os registros.

| Caso | Preparação / entrada | Verificação esperada |
|---|---|---|
| CT01 — Cadastro válido | Cadastrar `Teclado`, preço `150.0` | O produto recebe ID e é encontrado no repositório com nome e preço corretos. |
| CT02 — Nome inválido | Tentar cadastrar nome em branco e preço `80.0` | `IllegalArgumentException`; a contagem de registros não aumenta. |
| CT03 — Atualização (desafio) | Cadastrar `Mouse` por `80.0`, atualizar para `95.0` | A consulta posterior ao repositório retorna preço `95.0`. |

**Passos:**
1. Abrir `ProdutoServiceIntegrationTest` e completar CT01 e CT02; implementar CT03 como desafio.
2. Utilizar `@SpringBootTest`, `@Autowired` e `@Transactional` já presentes no projeto.
3. Usar `assertNotNull`, `assertEquals` e `assertThrows` quando apropriado.
4. Executar `mvn test` e registrar o resultado.

**Discussão:** por que a consulta com `repository.findById()` fornece uma evidência diferente de verificar apenas o objeto retornado pelo serviço? O que `@Transactional` faz ao término de cada teste?

## Exercício 2 — Integração HTTP com MockMvc

**Objetivo:** testar o fluxo Controller → Service → Repository → H2 por meio de requisições HTTP simuladas.

| Caso | Requisição | Verificação esperada |
|---|---|---|
| CT04 — Cadastro via API | `POST /produtos` com `{"nome":"Mouse","preco":80.0}` | HTTP `200`; resposta JSON com ID numérico, nome `Mouse` e preço `80.0`. |
| CT05 — Consulta via API | Cadastrar via POST; recuperar o ID; realizar `GET /produtos/{id}` | HTTP `200`; JSON da consulta corresponde ao produto cadastrado. |

**Passos:**
1. Abrir `ProdutoControllerIntegrationTest` e completar CT04 e CT05.
2. Utilizar `mockMvc.perform(...)`, `contentType(MediaType.APPLICATION_JSON)`, `status()` e `jsonPath()`.
3. Para CT05, capturar o corpo da resposta do POST e extrair o ID com `ObjectMapper` ou `JsonNode`.
4. Executar a suíte inteira com `mvn test`.

**Discussão:** quais componentes são efetivamente exercitados? Por que o MockMvc não precisa iniciar um servidor HTTP real? Qual é a diferença entre esse teste e um teste unitário do controller com dependências simuladas?


## Execução

```bash
mvn test
```

**Observações:** o projeto-base contém a aplicação funcional e os testes com espaços `TODO`, sem as asserções prontas. Os testes incompletos não falham automaticamente: os estudantes devem preenchê-los antes de interpretar o resultado da suíte. Em testes com `@Transactional`, o Spring normalmente desfaz a transação ao final de cada método de teste; o uso de `MockMvc` aqui ocorre na mesma aplicação e sem servidor HTTP real.
