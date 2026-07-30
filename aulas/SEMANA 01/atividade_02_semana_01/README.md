# Atividade 02 da semana 01

Prática guiada sobre artefatos de teste, classes de equivalência e combinações de
usuário e senha.

## Arquivos

- `atividade.md`: enunciado completo;
- `index.html`: microprojeto LoginLab;
- `logic.js`: regra de autenticação;
- `modelos/`: artefatos que os alunos deverão preencher.
- `main_atividade_02.tex` e `slides_atividade_02.tex`: apresentação Beamer;
- `main_atividade_02.pdf`: slides compilados.

Abra `index.html` diretamente em um navegador. O microprojeto não depende de
servidor HTTP, não utiliza contas reais e funciona também pelo protocolo `file://`.

Há uma divergência didática intencional na build 1.0.0. Ela deve ser descoberta e
documentada pelos estudantes durante a execução.

Para recompilar a apresentação:

```bash
latexmk -xelatex main_atividade_02.tex
```
