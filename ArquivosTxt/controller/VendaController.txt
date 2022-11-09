package controller;

import entidades.Produto;
import entidades.Venda;
import dao.ProdutoDAO;
import dao.VendaDAO;

import java.util.List;

public class VendaController {



    public void retornarQtdEstoque(int codigoProduto) {

        Produto produto = new Produto();

        ProdutoDAO produtoDAO = new ProdutoDAO();
        produto.setCodigoProduto(codigoProduto);

        produtoDAO.retornarQuantidadeProduto(codigoProduto);
    }

    public void cadastrarVenda(int codigoVenda,
                               int codigoProduto,
                               int codigoVendedor,
                               int quantidade) {

        Venda venda = new Venda();

        venda.setCodigoVenda(codigoVenda);
        venda.setCodigoProd(codigoProduto);
        venda.setCodVendedor(codigoVendedor);
        venda.setQntdVendida(quantidade);

        VendaDAO vendaDAO = new VendaDAO();

        vendaDAO.cadastrarVenda(venda);

    }

    public void deletarVendaPorCodigo(int codigoVenda) {

        Venda venda = new Venda();

        venda.setCodigoVenda(codigoVenda);

        VendaDAO vendaDAO = new VendaDAO();

        vendaDAO.deletarVendaPorCodigo(venda);
    }

    public void listarVendas() {

        VendaDAO vendaDAO = new VendaDAO();

        List<Venda> listaResultado = vendaDAO.selectTodos();

        for(Venda v: listaResultado){
            System.out.println("- Codigo da Venda: "  + v.getCodigoVenda()  +
                    "\n- Código do Produto: " + v.getCodigoProd()  +
                    "\n- Código do Vendedor " + v.getCodVendedor() +
                    "\n- Quantidade Vendida: " + v.getQntdVendida() +
                    "\n------------------------------");
        }
    }
}
