# Exemplo funcional com Playwright

Projeto executável associado à apresentação `aula05_playwright.md`.

## O que ele demonstra

- login válido e inválido;
- locators por rótulo, papel e `data-testid`;
- asserções de URL, conteúdo e estado da sessão;
- classes de equivalência e valores-limite para idade;
- execução em Chromium, Firefox e WebKit;
- servidor iniciado automaticamente pelo Playwright;
- relatório HTML, screenshot em falha e trace na primeira repetição.

## Instalação

```bash
npm install
npm run browsers
```

Em Linux ou ambiente de integração contínua:

```bash
PLAYWRIGHT_BROWSERS_PATH=.browsers npx playwright install --with-deps chromium
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

Para instalar todos os navegadores e executar os três projetos:

```bash
npm run browsers:all
npm run test:all
```

## Aplicação manual

```bash
npm run start
```

Acesse:

- http://127.0.0.1:3000/login
- http://127.0.0.1:3000/idade

Credenciais didáticas:

- e-mail: `ana@exemplo.com`
- senha: `SenhaSegura123!`

> Não reutilize credenciais fixas dessa forma em um sistema real.
