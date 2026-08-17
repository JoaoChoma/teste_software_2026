const http = require('node:http');
const fs = require('node:fs');
const path = require('node:path');

const port = Number(process.env.PORT || 3000);
const publicDir = path.join(__dirname, 'public');
const types = {
  '.html': 'text/html; charset=utf-8',
  '.css': 'text/css; charset=utf-8',
  '.js': 'text/javascript; charset=utf-8',
};

const server = http.createServer((request, response) => {
  const url = new URL(request.url, `http://${request.headers.host}`);
  const routes = {
    '/': 'login.html',
    '/login': 'login.html',
    '/conta': 'conta.html',
    '/idade': 'idade.html',
  };

  const requested = routes[url.pathname] || url.pathname.replace(/^\//, '');
  const file = path.normalize(path.join(publicDir, requested));

  if (!file.startsWith(publicDir)) {
    response.writeHead(403);
    response.end('Acesso negado');
    return;
  }

  fs.readFile(file, (error, content) => {
    if (error) {
      response.writeHead(error.code === 'ENOENT' ? 404 : 500);
      response.end(error.code === 'ENOENT' ? 'Página não encontrada' : 'Erro interno');
      return;
    }
    response.writeHead(200, {
      'Content-Type': types[path.extname(file)] || 'application/octet-stream',
      'Cache-Control': 'no-store',
    });
    response.end(content);
  });
});

server.listen(port, '127.0.0.1', () => {
  console.log(`Aplicação didática disponível em http://127.0.0.1:${port}`);
});
