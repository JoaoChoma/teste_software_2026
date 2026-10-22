package br.edu.exemplo.service;
import br.edu.exemplo.model.Produto;
import br.edu.exemplo.repository.ProdutoRepository;
import org.springframework.stereotype.Service;
@Service
public class ProdutoService {
 private final ProdutoRepository repository;
 public ProdutoService(ProdutoRepository repository){this.repository=repository;}
 public Produto cadastrar(String nome,double preco){
  if(nome==null || nome.isBlank()) throw new IllegalArgumentException("Nome obrigatório");
  if(preco<=0) throw new IllegalArgumentException("Preço deve ser positivo");
  return repository.save(new Produto(nome,preco));
 }
 public Produto buscar(Long id){return repository.findById(id).orElseThrow(()->new IllegalArgumentException("Produto não encontrado"));}
 public Produto atualizarPreco(Long id,double novoPreco){
  if(novoPreco<=0) throw new IllegalArgumentException("Preço deve ser positivo");
  Produto produto=buscar(id);produto.setPreco(novoPreco);return repository.save(produto);
 }
}
