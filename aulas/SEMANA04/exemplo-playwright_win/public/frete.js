const form = document.querySelector('#frete-form');
const resultado = document.querySelector('#resultado');

form.addEventListener('submit', (event) => {
  event.preventDefault();
  const data = new FormData(form);
  const cep = data.get('cep').trim();
  const valorTexto = data.get('valor').trim().replace(',', '.');
  const valor = Number(valorTexto);
  const entradaValida = /^\d{8}$/.test(cep)
    && /^\d+(?:[.,]\d{1,2})?$/.test(data.get('valor').trim())
    && valor > 0;

  resultado.hidden = false;

  if (!entradaValida) {
    resultado.className = '';
    resultado.setAttribute('role', 'alert');
    resultado.textContent = 'Dados inválidos';
    return;
  }

  const frete = valor >= 200 ? 0 : cep.startsWith('8') ? 15 : 25;
  resultado.className = 'success';
  resultado.setAttribute('role', 'status');
  resultado.textContent = frete === 0 ? 'Frete grátis' : `Frete: R$ ${frete.toFixed(2).replace('.', ',')}`;
});
