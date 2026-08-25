# Exemplo funcional com Playwright no Windows

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


## Pré-requisitos no Windows

- Node.js LTS instalado: https://nodejs.org/
- PowerShell, Prompt de Comando ou Terminal do Windows

Confira a instalação:

```powershell
node --version
npm --version
```

## Preparar o projeto

No PowerShell, entre na pasta do projeto e instale as dependências:

```powershell
cd "aulas\SEMANA04\exemplo-playwright_win"
npm install
npm run browsers
```

O comando `npm run browsers` instala o Chromium usado pelos testes e só precisa
ser repetido quando o Playwright solicitar uma nova versão.

## Usar o sistema antes dos testes

No primeiro terminal:

```powershell
npm run start
```

Acesse:

- http://127.0.0.1:3000/login
- http://127.0.0.1:3000/idade
- http://127.0.0.1:3000/frete
- http://127.0.0.1:3000/senha

Mantenha esse terminal aberto enquanto usa o sistema. Para encerrá-lo, pressione
`Ctrl+C`.

## Executar os testes

Com o sistema ainda aberto, abra um segundo terminal na mesma pasta e execute:

```powershell
npm test
```

O Playwright reutiliza o servidor que já está rodando. Se ele não estiver aberto,
o próprio Playwright inicia e encerra o servidor automaticamente.

Somente Chromium, mostrando o navegador:

```powershell
npm run test:headed
```

Interface de execução e depuração:

```powershell
npm run test:ui
```

Depurador passo a passo:

```powershell
npm run test:debug
```

Abrir o último relatório:

```powershell
npm run report
```

Para instalar todos os navegadores e executar os projetos:

```powershell
npm run browsers:all
npm run test:all
```



## Prática propostas

1. Clonar o repositório e acessar a pasta do projeto `aulas\SEMANA04\exemplo-playwright_win`

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
