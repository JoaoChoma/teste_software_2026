(function () {
  "use strict";

  const form = document.querySelector("#login-form");
  const mensagem = document.querySelector("#mensagem");
  const sessao = document.querySelector("#sessao");

  form.addEventListener("submit", function (event) {
    event.preventDefault();
    const resultado = window.LoginLab.autenticar(
      document.querySelector("#usuario").value,
      document.querySelector("#senha").value
    );
    mensagem.textContent = resultado.mensagem;
    sessao.textContent = resultado.sessao ? "sim" : "não";
  });

  document.querySelector("#limpar").addEventListener("click", function () {
    form.reset();
    mensagem.textContent = "Nenhuma tentativa executada.";
    sessao.textContent = "não";
    document.querySelector("#usuario").focus();
  });
})();

