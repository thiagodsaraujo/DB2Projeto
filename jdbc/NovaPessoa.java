package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class NovaPessoa {
    public static void main(String[] args) throws SQLException {

        Scanner entrada = new Scanner(System.in);

        System.out.println("Informe o nome: ");
        String nome = entrada.nextLine();

        Connection conexao = FabricaConexao.getConexao();
        // aqui é uma forma safe de inserção de dados, para evitar SqlInjection
        // usa o preparedStatement e set onde tem a interrogação e nao vai ser possivel inserir comandos sql por injection, só vai aceitar strings
        String sql = "INSERT INTO pessoas (nome) VALUES (?)"; // pode gerar o código se quiser
//        String sql = "INSERT INTO pessoas (nome, codigo) VALUES (?, ?)";

        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setString(1, nome); // 1 ?
//        stmt.setInt(2, 100); // 2 ? incluiu a pessoa com o código 100 // mais vai dar erro se tentar novamente,
        // nao é a melhor forma
        stmt.execute();

        System.out.println("Pessoa incluida com sucesso!");
        entrada.close();
    }
}
