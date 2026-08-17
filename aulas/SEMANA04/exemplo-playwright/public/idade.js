const form = document.querySelector('#idade-form');
const resultado = document.querySelector('#resultado');

form.addEventListener('submit', (event) => {
  event.preventDefault();
  const texto = new FormData(form).get('idade').trim();
  const idade = Number(texto);
  const valida = /^\d+$/.test(texto) && Number.isInteger(idade) && idade >= 18 && idade <= 65;

  resultado.hidden = false;
  resultado.className = valida ? 'success' : '';
  resultado.setAttribute('role', valida ? 'status' : 'alert');
  resultado.textContent = valida ? 'Cadastro permitido' : 'Idade inválida';
});

