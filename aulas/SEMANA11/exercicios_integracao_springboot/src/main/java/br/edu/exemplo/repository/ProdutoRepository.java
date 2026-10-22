package br.edu.exemplo.repository;
import br.edu.exemplo.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ProdutoRepository extends JpaRepository<Produto,Long> {}
