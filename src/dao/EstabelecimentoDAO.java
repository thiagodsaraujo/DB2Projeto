package dao;

import conexao.Conecta;
import entidades.Estabelecimento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EstabelecimentoDAO {

    private Connection con;

    public EstabelecimentoDAO() {
        try {
            con = Conecta.criarConexao();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void cadastrarEstabelecimento(Estabelecimento estabelecimento){

        String sql = "INSERT INTO estabelecimento(codigoestab,nomeestab) VALUES (?,?)";

        try {

            PreparedStatement preparador = con.prepareStatement(sql);

            preparador.setInt(1,estabelecimento.getCodigoEstab());
            preparador.setString(2,estabelecimento.getNomeEstab());

            preparador.execute();
            preparador.close();

            System.out.println("Inserção na tabela - Estabelecimento -  realizada com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro - " + e.getMessage());
        }
    }

//    public void atualizarEstabelecimentoPorNome(Estabelecimento estabelecimento) {
//        String sql = "UPDATE estabelecimento SET nomeestab = ? WHERE nomeestab = ?";
//        try {
//            PreparedStatement preparador = con.prepareStatement(sql);
//
//            preparador.setInt(1,estabelecimento.getCodigoEstab());
//            preparador.setString(2,estabelecimento.getNomeEstab());
//
//            preparador.execute();
//            preparador.close();
//            System.out.println("Atualização na tabela - Estabelecimento -  realizada com sucesso!");
//        } catch (SQLException e) {
//            System.out.println("Erro - " + e.getMessage());
//        }
//    }

    public void atualizarEstabelecimentoPorCodigo(Estabelecimento estabelecimento) {
        String sql = "UPDATE estabelecimento SET nomeestab = ? WHERE codigoestab = ?";

        try {

            PreparedStatement preparador = con.prepareStatement(sql);

            preparador.setString(1,estabelecimento.getNomeEstab());
            preparador.setInt(2,estabelecimento.getCodigoEstab());

            preparador.execute();
            preparador.close();

            System.out.println("Alteração realizada!");

        } catch (SQLException e) {
            System.out.println("Erro - " + e.getMessage());
        }
    }


    public void deletarEstabelecimento(Estabelecimento estabelecimento) {
        String sql = "DELETE FROM estabelecimento WHERE codigoestab = ?";
        try {
            PreparedStatement preparador = con.prepareStatement(sql);

            preparador.setInt(1,estabelecimento.getCodigoEstab());

            preparador.execute();
            preparador.close();

            System.out.println("Deleção realizada com sucesso!");

        } catch (SQLException e) {
            System.out.println("Erro - " + e.getMessage());
        }
    }

    public List<Estabelecimento> selectTodos() {

        String sql = "SELECT * FROM estabelecimento";
        List<Estabelecimento> lista = new ArrayList<>();

        try {
            PreparedStatement preparador = con.prepareStatement(sql);
            ResultSet resultados = preparador.executeQuery();

            while (resultados.next()) {
                Estabelecimento estabelecimento = new Estabelecimento();
                estabelecimento.setCodigoEstab(resultados.getInt("codigoestab"));
                estabelecimento.setNomeEstab(resultados.getString("nomeestab"));

                lista.add(estabelecimento);
            }

        } catch (SQLException e) {
            System.out.println("Erro - " + e.getMessage());
        }

        return lista;
    }



}
