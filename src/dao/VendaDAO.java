package dao;

import conexao.Conecta;
import entidades.Venda;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VendaDAO {

    private Connection con;

    public VendaDAO(){
        try {
            con = Conecta.criarConexao();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void cadastrarVenda(Venda venda){
        String sql = "INSERT INTO venda(codigovenda,codigoprod, codvendedor, valorvenda, quantidade) " +
                "VALUES (?,?,?,?,?)";

        try {

            PreparedStatement preparador = con.prepareStatement(sql);

            preparador.setInt(1,venda.getCodigoVenda());
            preparador.setInt(2,venda.getCodigoProd());
            preparador.setInt(3,venda.getCodVendedor());
            preparador.setDouble(4,venda.getValorVenda());
            preparador.setInt(5,venda.getQntdVendida());

            preparador.execute();
            preparador.close();

            System.out.println("Inserção na tabela - Venda -  realizada com sucesso!");

        } catch (SQLException e) {
            System.out.println("Erro - " + e.getMessage());
        }
    }

    public void deletarVendaPorCodigo(Venda venda){
        String sql = "DELETE FROM venda WHERE codigovenda = ?";

        try {

            PreparedStatement preparador = con.prepareStatement(sql);

            preparador.setInt(1,venda.getCodigoVenda());

            preparador.execute();
            preparador.close();

            System.out.println("Deleção realizada com sucesso!");

        } catch (SQLException e) {
            System.out.println("Erro - " + e.getMessage());
        }
    }



    public List<Venda> selectTodos(){
        String sql = "SELECT * FROM venda";
        List<Venda> lista = new ArrayList<>();

        try {
            PreparedStatement preparador = con.prepareStatement(sql);
            ResultSet resultados = preparador.executeQuery();

            while (resultados.next()){
                Venda venda = new Venda();
                venda.setCodigoVenda(resultados.getInt("codigovenda"));
                venda.setCodigoProd(resultados.getInt("codigoprod"));
                venda.setCodVendedor(resultados.getInt("codigovendedor"));
                venda.setValorVenda(resultados.getDouble("valorvenda"));
                venda.setQntdVendida(resultados.getInt("quantidade"));
            }

        }catch (SQLException e) {
            System.out.println("Erro - " + e.getMessage());
        }
        return lista;
    }

}
