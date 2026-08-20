# Exemplo funcional com Playwright

Projeto executável associado à apresentação `aula05_playwright.md`.

## O que ele demonstra

- login válido e inválido;
- asserções de URL, conteúdo e estado da sessão;
- classes de equivalência e valores-limite para idade;
- atividade de cálculo de frete, com spec-gabarito;
- atividade de validação de senha, com spec-gabarito;
- execução em Chromium, Firefox e WebKit;
- servidor iniciado automaticamente pelo Playwright;
- relatório HTML, screenshot em falha e trace na primeira repetição.


## Executar o projeto manual

```bash
npm install
npm run start
```

Acesse:

- http://127.0.0.1:3000/login
- http://127.0.0.1:3000/idade
- http://127.0.0.1:3000/frete
- http://127.0.0.1:3000/senha

## Instalação

```bash
npm install
npm run browsers
```

## Executar

```bash
npm test
```

Somente Chromium, mostrando o navegador:

```bash
npm run test:headed
```

Interface de execução e depuração:

```bash
npm run test:ui
```

Depurador passo a passo:

```bash
npm run test:debug
```

Abrir o último relatório:

```bash
npm run report
```

Para instalar todos os navegadores e executar os projetos:

```bash
npm run browsers:all
npm run test:all
```



## Prática propostas

1. Clonar o repositório e acessar a pasta do projeto `aulas/SEMANA04/exemplo-playwright`

2. Consultar o gabarito e analisar como o teste é executado;

Os exemplos estão em:

- `tests/idade.spec.ts`
- `tests/login.spec.ts`

Credenciais didáticas:

- e-mail: `ana@exemplo.com`
- senha: `SenhaSegura123!`

> ISSO É UM EXEMPLO: Não reutilize credenciais fixas dessa forma em um sistema real.

# O que vocês devem fazer para entregar:

2. Escreva testes funcionais para as interfaces de frete e senha;

3. Cubra os caminhos válidos, classes inválidas e os valores-limite
descritos nas próprias páginas;

```bash
publique o projeto resultante em seu Github; 
```