package br.edu.exemplo;
public class EstoqueService {
 private int quantidade;
 public EstoqueService(int quantidadeInicial){this.quantidade=quantidadeInicial;}
 public boolean temEstoque(int quantidadeSolicitada){return quantidade>=quantidadeSolicitada;}
 public void retirar(int quantidade){this.quantidade-=quantidade;}
 public int getQuantidade(){return quantidade;}
}