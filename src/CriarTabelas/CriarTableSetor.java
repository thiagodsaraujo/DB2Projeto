package CriarTabelas;

import Conexao.Conecta;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CriarTableSetor {

    public static void main(String[] args) {

        Connection conexao = null;
        try {
            conexao = Conecta.criarConexao();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }


        String sql = "CREATE TABLE IF NOT EXISTS setor (" +
                "codigo int PRIMARY KEY, " +
                "nomeset VARCHAR(50) NOT NULL"+
                ")";

        Statement stmt = null;
        
        try {
            stmt = conexao.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            stmt.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println("Tabela Criada com sucesso!");

        try {
            conexao.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
