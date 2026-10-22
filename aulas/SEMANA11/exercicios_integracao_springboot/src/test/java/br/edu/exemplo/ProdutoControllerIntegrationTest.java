package br.edu.exemplo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.springframework.http.MediaType;
@SpringBootTest @AutoConfigureMockMvc @Transactional
class ProdutoControllerIntegrationTest {
 @Autowired MockMvc mockMvc;
 @Test void deveCadastrarProdutoPelaApi() throws Exception {
  // TODO EX2: POST /produtos com JSON {"nome":"Mouse","preco":80.0}
  // Verificar HTTP 200, ID numérico, nome e preço no JSON de resposta.
 }
 @Test void deveBuscarProdutoPelaApi() throws Exception {
  // TODO EX2: cadastrar por POST, extrair o ID da resposta,
  // executar GET /produtos/{id} e conferir os dados retornados.
 }
}
