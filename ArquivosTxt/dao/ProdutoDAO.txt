package dao;

import conexao.Conecta;
import entidades.Produto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO {

    private Connection con;

    public ProdutoDAO() {
        try {
            con = Conecta.criarConexao();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void cadastrarProduto(Produto produto) {

        String sql = "INSERT INTO produto(codigoproduto,descricao, valor, quantidade) VALUES (?,?,?,?)";

        try {

            PreparedStatement preparador = con.prepareStatement(sql);

            preparador.setInt(1, produto.getCodigoProduto());
            preparador.setString(2, produto.getDescricao());
            preparador.setDouble(3, produto.getValor());
            preparador.setInt(4, produto.getQuantidade());

            preparador.execute();
            preparador.close();

            System.out.println("Inserção na tabela - Produto -  realizada com sucesso!");

        } catch (SQLException e) {
            System.out.println("Erro - " + e.getMessage());
        }
    }

    public void atualizarValorProdutoPorDescricao(Produto produto) {

        String sql = "UPDATE produto SET valor = ? WHERE descricao = ?";

        try {
            PreparedStatement preparador = con.prepareStatement(sql);

            preparador.setDouble(1, produto.getValor());
            preparador.setString(2, produto.getDescricao());

            preparador.execute();
            preparador.close();

            System.out.println("Atualização na tabela - Estabelecimento -  realizada com sucesso!");

        } catch (SQLException e) {
            System.out.println("Erro - " + e.getMessage());
        }
    }

    public void atualizarValorProdutoPorCodigo(Produto produto) {

        String sql = "UPDATE produto SET valor = ? WHERE codigoproduto = ?";

        try {

            PreparedStatement preparador = con.prepareStatement(sql);

            preparador.setDouble(1, produto.getValor());
            preparador.setInt(2, produto.getCodigoProduto());

            preparador.execute();
            preparador.close();

            System.out.println("Alteração realizada!");

        } catch (SQLException e) {
            System.out.println("Erro - " + e.getMessage());
        }
    }


    public void deletarProdutoPorCodigo(Produto produto) {

        String sql = "DELETE FROM produto WHERE codigoproduto = ?";

        try {

            PreparedStatement preparador = con.prepareStatement(sql);

            preparador.setInt(1, produto.getCodigoProduto());

            preparador.execute();
            preparador.close();

            System.out.println("Deleção realizada com sucesso!");

        } catch (SQLException e) {
            System.out.println("Erro - " + e.getMessage());
        }
    }

    public void retornarQuantidadeProduto(int codigo) {
        String sql = "SELECT p.quantidade FROM produto p WHERE codigoproduto = ?";

//        CallableStatement cs = null;

        try {
            PreparedStatement preparador = con.prepareStatement(sql);

            preparador.setInt(1, codigo);

            preparador.execute();
            preparador.close();

//            cs = con.prepareCall(sql);
//            cs.setInt("quantidade", 1);
//            cs.executeQuery();
//
//            ResultSet resultados = cs.getResultSet();
//
//            if (resultados.next()){
//                System.out.println(resultados.getInt(4));
//            }
//            while (resultados.next()) {
//
//                Produto produto = new Produto();
//                produto.setCodigoProduto(resultados.getInt("codigoproduto"));
//                produto.setDescricao(resultados.getString("descricao"));
//                produto.setValor(resultados.getDouble("valor"));
//                qtd = produto.setQtd(resultados.getInt("quantidade"));
//            }

            System.out.println("Alteração realizada!");
        } catch (SQLException e) {
            System.out.println("Erro - " + e.getMessage());
        }
    }


    public List<Produto> selectTodos() {

        String sql = "SELECT * FROM produto";
        List<Produto> lista = new ArrayList<>();

        try {

            PreparedStatement preparador = con.prepareStatement(sql);

            ResultSet resultados = preparador.executeQuery();

            while (resultados.next()) {
                Produto produto = new Produto();
                produto.setCodigoProduto(resultados.getInt("codigoproduto"));
                produto.setDescricao(resultados.getString("descricao"));
                produto.setValor(resultados.getDouble("valor"));
                produto.setQuantidade(resultados.getInt("quantidade"));

                lista.add(produto);
            }

        } catch (SQLException e) {
            System.out.println("Erro - " + e.getMessage());
        }

        return lista;
    }



}
