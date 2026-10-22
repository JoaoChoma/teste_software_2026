package br.edu.exemplo;
import br.edu.exemplo.model.Produto;
import br.edu.exemplo.repository.ProdutoRepository;
import br.edu.exemplo.service.ProdutoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@Transactional
class ProdutoServiceIntegrationTest {
    @Autowired ProdutoService service;
    @Autowired ProdutoRepository repository;
    @Test void deveCadastrarEPersistirProduto() {
        Produto salvo = service.cadastrar("Teclado", 150.0);
        assertNotNull(salvo.getId());
        repository.flush();
        Produto encontrado = repository.findById(salvo.getId()).orElseThrow();
        assertEquals("Teclado", encontrado.getNome());
        assertEquals(150.0, encontrado.getPreco());
    }
}
