package CriarTabelas;

import Conexao.Conecta;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CriarTabelaProduto {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        Connection conexao = Conecta.criarConexao();


        String sql = "CREATE TABLE IF NOT EXISTS produto (" +
                "codigoProduto int PRIMARY KEY, " +
                "descricao VARCHAR(100) NOT NULL," +
                "valor NUMERIC(10,2) NOT NULL," +
                "quantidade int NOT NULL"+
                ")";



        Statement stmt = conexao.createStatement();
        stmt.execute(sql);

        System.out.println("Tabela Criada com sucesso!");
        conexao.close();

    }
}
