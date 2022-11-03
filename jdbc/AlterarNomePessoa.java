package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.SortedMap;

public class AlterarNomePessoa {

    public static void main(String[] args) throws SQLException {

        Scanner sc = new Scanner(System.in);

        System.out.println("Informe o c�digo da pessoa: ");
        int codigo = sc.nextInt();


        String sql = "SELECT codigo, nome FROM pessoas WHERE codigo = ?";
        String update = "UPDATE pessoas SET nome = ? WHERE codigo = ?";

        Connection conexao = FabricaConexao.getConexao();

        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setInt(1,codigo);
        ResultSet resultado = stmt.executeQuery();

        if (resultado.next()){
            Pessoa p = new Pessoa(resultado.getInt(1), resultado.getString(2));

            System.out.println("O nome atual � " + p.getNome());
            sc.nextLine();

            System.out.println("Informe o novo nome: ");
            String novoNome = sc.nextLine();

            stmt.close();
            stmt = conexao.prepareStatement(update);
            stmt.setString(1, novoNome);
            stmt.setInt(2, codigo);
            stmt.execute();

            System.out.println("Pessoa atualizada com sucesso!");
        }else {
            System.out.println("Pessoa n�o encontrada");
        }

        conexao.close();
        sc.close();

    }
}
