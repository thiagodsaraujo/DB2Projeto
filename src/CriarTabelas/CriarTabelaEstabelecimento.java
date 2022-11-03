package CriarTabelas;

import Conexao.Conecta;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CriarTabelaEstabelecimento {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        Connection conexao = Conecta.criarConexao();


        String sql = "CREATE TABLE IF NOT EXISTS estabelecimento (" +
                "codigoEstab INT PRIMARY KEY," +
                "nomeEstab VARCHAR(100) NOT NULL" +
                ")";

        Statement stmt = conexao.createStatement();
        stmt.execute(sql);

        System.out.println("Tabela Criada com sucesso!");
        conexao.close();

    }
}
