package Teste;

import Entidades.Estabelecimento;
import Entidades.Produto;
import dao.EstabelecimentoDAO;
import dao.ProdutoDAO;

import java.util.List;
import java.util.Scanner;

public class MainProduto {


    public static void main(String[] args) {


//        Scanner entrada = new Scanner(System.in);
//
//        System.out.println("Informe o codigo do Produto: ");
//        int codigoProduto = entrada.nextInt();
//        entrada.nextLine();
//
//        System.out.println("Informe o nome do Produto: ");
//        String descricao = entrada.nextLine();
//
//        System.out.println("Informe o valor do Produto: ");
//        Double valor = entrada.nextDouble();
//
//

//        System.out.println(retornarQtdEstoque(1));
//        cadastrarProduto(1,"Mouse",200.0, 2);
//        cadastrarProduto(2,"Teclado",300.0, 1);
//        cadastrarProduto(3,"Monitor",500.0, 1);
//        listarProduto();
        System.out.println(retornarQtdEstoque(1));
//        atualizarValorProdutoPorCodigo(1, 250.0);
//        atualizarValorProdutoPorDescricao("Teclado", 350.0);
//        deletarProdutoPorCodigo(3);
//        System.out.println("\nLista Atualizada\n");
//        listarProduto();



//            var pk = random.ints(1,100).findFirst().getAsInt();


    }

    private static int retornarQtdEstoque(int codigoProduto) {
        Produto produto = new Produto();

        ProdutoDAO produtoDAO = new ProdutoDAO();
        produto.setCodigoProduto(codigoProduto);

        return produtoDAO.retornarQuantidadeProduto(produto);
    }

    private static void cadastrarProduto(int codigoProduto, String descricao, Double valor, int quantidade) {

        Produto produto = new Produto();

        produto.setCodigoProduto(codigoProduto);
        produto.setDescricao(descricao);
        produto.setValor(valor);
        produto.setQuantidade(quantidade);

        ProdutoDAO produtoDAO = new ProdutoDAO();

        produtoDAO.cadastrarProduto(produto);

    }

    private static void atualizarValorProdutoPorDescricao(String descricao, Double valor) {

        Produto produto = new Produto();

        produto.setDescricao(descricao);
        produto.setValor(valor);

        ProdutoDAO produtoDAO = new ProdutoDAO();

        produtoDAO.atualizarValorProdutoPorDescricao(produto);
    }

    private static void atualizarValorProdutoPorCodigo(int codigoProduto, Double valor) {

        Produto produto = new Produto();

        produto.setCodigoProduto(codigoProduto);
        produto.setValor(valor);

        ProdutoDAO produtoDAO = new ProdutoDAO();

        produtoDAO.atualizarValorProdutoPorCodigo(produto);
    }


    private static void deletarProdutoPorCodigo(int codigoProduto) {

        Produto produto = new Produto();

        produto.setCodigoProduto(codigoProduto);

        ProdutoDAO produtoDAO = new ProdutoDAO();

        produtoDAO.deletarProdutoPorCodigo(produto);
    }

    private static void listarProduto() {

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

