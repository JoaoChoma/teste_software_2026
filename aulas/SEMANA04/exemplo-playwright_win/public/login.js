const form = document.querySelector('#login-form');
const mensagem = document.querySelector('#mensagem');

form.addEventListener('submit', (event) => {
  event.preventDefault();
  const data = new FormData(form);
  const email = data.get('email');
  const senha = data.get('senha');

  if (email === 'ana@exemplo.com' && senha === 'SenhaSegura123!') {
    sessionStorage.setItem('usuarioAutenticado', 'Ana');
    location.assign('/conta');
    return;
  }

  mensagem.textContent = 'E-mail ou senha inválidos';
  mensagem.hidden = false;
});

