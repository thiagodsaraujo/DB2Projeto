package Teste;

import Conexao.Conecta;
import Controller.EstabelecimentoController;
import Controller.ProdutoController;

import java.sql.Connection;
import java.sql.SQLException;

public class Teste {

    public static void main(String[] args) {
        try {
            Connection con = Conecta.criarConexao();
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        } catch (SQLException e){
            e.printStackTrace();
        }

        ProdutoController controller = new ProdutoController();
        controller.retornarQtdEstoque(1);
    }
}
