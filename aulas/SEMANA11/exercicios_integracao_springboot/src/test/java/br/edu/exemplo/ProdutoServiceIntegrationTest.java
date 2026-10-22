package br.edu.exemplo;
import br.edu.exemplo.repository.ProdutoRepository;
import br.edu.exemplo.service.ProdutoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest @Transactional
class ProdutoServiceIntegrationTest {
 @Autowired ProdutoService service;
 @Autowired ProdutoRepository repository;
 @Test void deveCadastrarERecuperarProduto(){
  // TODO EX1: cadastrar Teclado por 150, confirmar ID e buscar pelo repositório.
  // Conferir nome e preço do registro recuperado.
 }
 @Test void naoDevePersistirProdutoComNomeEmBranco(){
  // TODO EX1: contar registros, tentar cadastrar nome em branco,
  // verificar IllegalArgumentException e que a contagem não mudou.
 }
 @Test void deveAtualizarPrecoPersistido(){
  // TODO DESAFIO: cadastrar, atualizar preço e buscar novamente no repositório.
 }
}
