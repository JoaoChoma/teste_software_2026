const form = document.querySelector('#senha-form');
const resultado = document.querySelector('#resultado');

form.addEventListener('submit', (event) => {
  event.preventDefault();
  const data = new FormData(form);
  const senha = data.get('senha');
  const confirmacao = data.get('confirmacao');
  const formatoValido = senha.length >= 8
    && senha.length <= 20
    && /[A-Z]/.test(senha)
    && /[a-z]/.test(senha)
    && /\d/.test(senha)
    && !/\s/.test(senha);

  resultado.hidden = false;

  if (!formatoValido) {
    resultado.className = '';
    resultado.setAttribute('role', 'alert');
    resultado.textContent = 'Senha fora do padrão';
    return;
  }

  if (senha !== confirmacao) {
    resultado.className = '';
    resultado.setAttribute('role', 'alert');
    resultado.textContent = 'As senhas não coincidem';
    return;
  }

  resultado.className = 'success';
  resultado.setAttribute('role', 'status');
  resultado.textContent = 'Senha cadastrada';
  form.reset();
});
