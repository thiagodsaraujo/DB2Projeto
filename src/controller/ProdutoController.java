package controller;

import entidades.Produto;
import dao.ProdutoDAO;

import java.util.List;

public class ProdutoController {


    public void retornarQtdEstoque(int codigoProduto) {
        Produto produto = new Produto();

        ProdutoDAO produtoDAO = new ProdutoDAO();
        produto.setCodigoProduto(codigoProduto);

        produtoDAO.retornarQuantidadeProduto(codigoProduto);
    }

    public void cadastrarProduto(int codigoProduto, String descricao, Double valor, int quantidade) {

        Produto produto = new Produto();

        produto.setCodigoProduto(codigoProduto);
        produto.setDescricao(descricao);
        produto.setValor(valor);
        produto.setQuantidade(quantidade);

        ProdutoDAO produtoDAO = new ProdutoDAO();

        produtoDAO.cadastrarProduto(produto);

    }

    public void atualizarValorProdutoPorDescricao(String descricao, Double valor) {

        Produto produto = new Produto();

        produto.setDescricao(descricao);
        produto.setValor(valor);

        ProdutoDAO produtoDAO = new ProdutoDAO();

        produtoDAO.atualizarValorProdutoPorDescricao(produto);
    }

    public void atualizarValorProdutoPorCodigo(int codigoProduto, Double valor) {

        Produto produto = new Produto();

        produto.setCodigoProduto(codigoProduto);
        produto.setValor(valor);

        ProdutoDAO produtoDAO = new ProdutoDAO();

        produtoDAO.atualizarValorProdutoPorCodigo(produto);
    }


    public void deletarProdutoPorCodigo(int codigoProduto) {

        Produto produto = new Produto();

        produto.setCodigoProduto(codigoProduto);

        ProdutoDAO produtoDAO = new ProdutoDAO();

        produtoDAO.deletarProdutoPorCodigo(produto);
    }

    public void listarProduto() {

        ProdutoDAO produtoDAO = new ProdutoDAO();

        List<Produto> listaResultado = produtoDAO.selectTodos();

        for(Produto p: listaResultado){
            System.out.println("- Codigo do Produto: "  + p.getCodigoProduto()  +
                    "\n- Nome do Produto: " + p.getDescricao()  +
                    "\n- Valor do Produto: R$ " + p.getValor() +
                    "\n- Quantidade em Estoque: " + p.getQuantidade() +
                    "\n------------------------------");
        }
    }
}
