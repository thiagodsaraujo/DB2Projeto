package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class ExclusaoPessoa {


    public static void main(String[] args) throws SQLException {

        Scanner sc = new Scanner(System.in);


        System.out.println("Informe o código da pessoa para ecluir: ");
        int codigo = sc.nextInt();
        sc.nextLine();

        Connection conexao = FabricaConexao.getConexao();
        String sql = "DELETE FROM pessoas WHERE codigo = ?"; // aqui vc pode setar se é = ou > ou < por exemplo

        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setInt(1, codigo);

        int contador = stmt.executeUpdate();

        if (contador > 0 ){
            System.out.println("Pessoa excluida com sucesso!!");
            System.out.println("Linhas afetadas: " + contador);
        }else {
            System.out.println("Nada feito!");
        }

        conexao.close();
        sc.close();

    }
}
