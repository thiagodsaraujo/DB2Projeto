package Entidades;

public class Produto {

    private int codigoProduto;
    private String descricao;
    private Double valor;
    private int quantidade;



    public Produto() {
    }

    public Produto(int codigoProduto, String descricao, Double valor, int quantidade) {
        this.codigoProduto = codigoProduto;
        this.descricao = descricao;
        this.valor = valor;
    }

    public int getCodigoProduto() {
        return codigoProduto;
    }

    public void setCodigoProduto(int codigoProduto) {
        this.codigoProduto = codigoProduto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

}
