package br.edu.exemplo.model;
import jakarta.persistence.*;
@Entity
public class Produto {
 @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;
 private String nome;
 private double preco;
 protected Produto() {}
 public Produto(String nome,double preco) {this.nome=nome;this.preco=preco;}
 public Long getId(){return id;}
 public String getNome(){return nome;}
 public double getPreco(){return preco;}
 public void setPreco(double preco){this.preco=preco;}
}
