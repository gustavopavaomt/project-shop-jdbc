package com.br.devgustavo.domain;

public class Produto {

    private Integer id;
    private String nome;
    private Double price;
    private Integer qtd_estoque;

    public Produto(String nome, Double price, Integer qtd_estoque) {
        this.nome = nome;
        this.price = price;
        this.qtd_estoque = qtd_estoque;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getQtd_estoque() {
        return qtd_estoque;
    }

    public void setQtd_estoque(Integer qtd_estoque) {
        this.qtd_estoque = qtd_estoque;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", price=" + price +
                ", qtd_estoque=" + qtd_estoque +
                '}';
    }
}
