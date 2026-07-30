(function () {
  "use strict";

  const contas = new Map([
    ["aluno01", { senha: "Teste@123", bloqueada: false }],
    ["professor01", { senha: "Aula@2026", bloqueada: false }],
    ["bloqueado01", { senha: "Segura@456", bloqueada: true }],
  ]);

  function autenticar(usuarioInformado, senhaInformada) {
    const usuario = String(usuarioInformado);
    const senha = String(senhaInformada);

    if (!usuario.trim() || !senha) {
      return {
        autenticado: false,
        mensagem: "Usuário e senha são obrigatórios.",
        sessao: false,
      };
    }

    const conta = contas.get(usuario);

    // Defeito didático intencional: RN-LOGIN-06 exige mensagem genérica.
    if (!conta) {
      return {
        autenticado: false,
        mensagem: "Usuário não cadastrado.",
        sessao: false,
      };
    }

    if (conta.bloqueada) {
      return {
        autenticado: false,
        mensagem: "Conta bloqueada. Procure o suporte.",
        sessao: false,
      };
    }

    if (senha !== conta.senha) {
      return {
        autenticado: false,
        mensagem: "Usuário ou senha inválidos.",
        sessao: false,
      };
    }

    return {
      autenticado: true,
      mensagem: `Bem-vindo, ${usuario}.`,
      sessao: true,
    };
  }

  window.LoginLab = { autenticar };
})();

