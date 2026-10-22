package br.edu.exemplo.controller;
import br.edu.exemplo.model.Produto;
import br.edu.exemplo.service.ProdutoService;
import org.springframework.web.bind.annotation.*;
@RestController @RequestMapping("/produtos")
public class ProdutoController {
 private final ProdutoService service;
 public ProdutoController(ProdutoService service){this.service=service;}
 @PostMapping public Produto cadastrar(@RequestBody ProdutoRequest request){return service.cadastrar(request.nome(),request.preco());}
 @GetMapping("/{id}") public Produto buscar(@PathVariable Long id){return service.buscar(id);}
}
