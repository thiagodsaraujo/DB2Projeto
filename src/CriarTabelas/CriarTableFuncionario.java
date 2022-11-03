package CriarTabelas;

import Conexao.Conecta;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CriarTableFuncionario {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        Connection conexao = Conecta.criarConexao();


        String sql = "CREATE TABLE IF NOT EXISTS funcionario (" +
                "matricula int PRIMARY KEY, " +
                "nome VARCHAR(100) NOT NULL," +
                "salario NUMERIC(10,2) NOT NULL," +
                "createdOn VARCHAR(20), " +
                "codset INT" +
                ")";



        Statement stmt = conexao.createStatement();
        stmt.execute(sql);

        System.out.println("Tabela Criada com sucesso!");
        conexao.close();

    }
}
