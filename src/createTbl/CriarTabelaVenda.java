package createTbl;

import conexao.Conecta;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CriarTabelaVenda {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        Connection conexao = Conecta.criarConexao();


        String sql = "CREATE TABLE IF NOT EXISTS venda (" +
                "codigoVenda int PRIMARY KEY, " +
                "codigoProd int NOT NULL," +
                "codVendedor int NOT NULL," +
                "qntdVendida int NOT NULL," +
                "FOREIGN KEY(codigoProd) REFERENCES produto(codigoproduto), " +
                "FOREIGN KEY(codVendedor) REFERENCES vendedor(matricula)" +
                ")";

        Statement stmt = conexao.createStatement();
        stmt.execute(sql);

        System.out.println("Tabela Criada com sucesso!");
        conexao.close();

    }
}
