package dao;

import Conexao.Conecta;
import Entidades.Setor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SetorDAO {

    private Connection con;

    public SetorDAO() {
        try {
            con = Conecta.criarConexao();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void cadastrarSetor(Setor setor){
        String sql = "INSERT INTO setor(codigo,nomeset) VALUES (?,?)";
        try {
            PreparedStatement preparador = con.prepareStatement(sql);
            preparador.setInt(1,setor.getCodigo());
            preparador.setString(2,setor.getNomeSet());

            preparador.execute();
            preparador.close();

            System.out.println("Inserção na tabela - Setor -  realizada com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro - " + e.getMessage());
        }
    }

}
