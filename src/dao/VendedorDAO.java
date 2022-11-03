package dao;

import Conexao.Conecta;
import Entidades.Produto;
import Entidades.Vendedor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VendedorDAO {

    private Connection con;

    public VendedorDAO(){
            try {
            con = Conecta.criarConexao();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void cadastrarVendedor(Vendedor vendedor){

        String sql = "INSERT INTO vendedor(matricula,codest, nome, salario) VALUES (?,?,?,?)";

        try {

            PreparedStatement preparador = con.prepareStatement(sql);

            preparador.setInt(1,vendedor.getMatricula());
            preparador.setInt(2,vendedor.getCodEst());
            preparador.setString(3,vendedor.getNome());
            preparador.setDouble(4,vendedor.getSalario());

            preparador.execute();
            preparador.close();

            System.out.println("Inserção na tabela - Vendedor -  realizada com sucesso!");

        } catch (SQLException e) {
            System.out.println("Erro - " + e.getMessage());
        }
    }

    public void atualizarSalarioVendedorPorMatricula(Vendedor vendedor) {

        String sql = "UPDATE vendedor SET salario = ? WHERE matricula = ?";

        try {
            PreparedStatement preparador = con.prepareStatement(sql);

            preparador.setDouble(1,vendedor.getSalario());
            preparador.setInt(2,vendedor.getMatricula());

            preparador.execute();
            preparador.close();

            System.out.println("Atualização na tabela - Vendedor -  realizada com sucesso!");

        } catch (SQLException e) {
            System.out.println("Erro - " + e.getMessage());
        }
    }

    public void atualizarSalarioVendedorPorNome(Vendedor vendedor) {

        String sql = "UPDATE vendedor SET salario = ? WHERE nome = ?";

        try {

            PreparedStatement preparador = con.prepareStatement(sql);

            preparador.setDouble(1,vendedor.getSalario());
            preparador.setString(2,vendedor.getNome());

            preparador.execute();
            preparador.close();

            System.out.println("Atualização na tabela - Vendedor -  realizada com sucesso!");

        } catch (SQLException e) {
            System.out.println("Erro - " + e.getMessage());
        }
    }


    public void deletarVendedorPorMatricula(Vendedor vendedor) {

        String sql = "DELETE FROM vendedor WHERE matricula = ?";

        try {

            PreparedStatement preparador = con.prepareStatement(sql);

            preparador.setInt(1,vendedor.getMatricula());

            preparador.execute();
            preparador.close();

            System.out.println("Deleção realizada com sucesso!");

        } catch (SQLException e) {
            System.out.println("Erro - " + e.getMessage());
        }
    }

    public List<Vendedor> selectTodos() {

        String sql = "SELECT * FROM vendedor";
        List<Vendedor> lista = new ArrayList<>();

        try {

            PreparedStatement preparador = con.prepareStatement(sql);
            ResultSet resultados = preparador.executeQuery();

            while (resultados.next()) {
                Vendedor vendedor = new Vendedor();

                vendedor.setMatricula(resultados.getInt("matricula"));
                vendedor.setCodEst(resultados.getInt("codest"));
                vendedor.setNome(resultados.getString("nome"));
                vendedor.setSalario(resultados.getDouble("salario"));

                lista.add(vendedor);
            }

        } catch (SQLException e) {
            System.out.println("Erro - " + e.getMessage());
        }

        return lista;
    }


}
