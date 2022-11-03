package dao;

import Conexao.Conecta;
import Entidades.Funcionario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioDAO {

    private Connection con;

    public FuncionarioDAO() {
        try {
            con = Conecta.criarConexao();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void cadastrarFuncionario(Funcionario funcionario) {
        String sql = "INSERT INTO funcionario(matricula, nome, salario, codset) VALUES(?,?,?,?)";
        try {
            PreparedStatement preparador = con.prepareStatement(sql);
            preparador.setLong(1, funcionario.getMatricula());
            preparador.setString(2, funcionario.getNome());
            preparador.setDouble(3, funcionario.getSalario());
            preparador.setLong(4, funcionario.getCodSetor());

            preparador.execute();
            preparador.close();

            System.out.println("Inserção na tabela - Funcionáirio - realizada com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro - " + e.getMessage());
        }
    }

    public void atualizarSalarioFuncionarioPorNome(Funcionario funcionario) {
        String sql = "UPDATE funcionario SET salario = ? WHERE nome = ?";

        try {
            PreparedStatement preparador = con.prepareStatement(sql);
            preparador.setDouble(1, funcionario.getSalario());
            preparador.setString(2, funcionario.getNome());

            preparador.execute();
            preparador.close();

            System.out.println("Alteração realizada!");

        } catch (SQLException e) {
            System.out.println("Erro - " + e.getMessage());
        }
    }

    public void atualizarSalarioFuncionarioPorMatricula(Funcionario funcionario) {
        String sql = "UPDATE funcionario SET salario = ? WHERE matricula = ?";

        try {
            PreparedStatement preparador = con.prepareStatement(sql);
            preparador.setDouble(1, funcionario.getSalario());
            preparador.setInt(2, funcionario.getMatricula());

            preparador.execute();
            preparador.close();

            System.out.println("Alteração realizada!");

        } catch (SQLException e) {
            System.out.println("Erro - " + e.getMessage());
        }
    }


    public void deletarFuncionario(Funcionario funcionario) {
        String sql = "DELETE FROM funcionario WHERE nome = ?";
        try {
            PreparedStatement preparador = con.prepareStatement(sql);
            preparador.setString(1, funcionario.getNome());

            preparador.execute();
            preparador.close();

            System.out.println("Deleção realizada com sucesso!");

        } catch (SQLException e) {
            System.out.println("Erro - " + e.getMessage());
        }
    }

    public List<Funcionario> selectTodos() {

        String sql = "SELECT * FROM funcionario";
        List<Funcionario> lista = new ArrayList<Funcionario>();

        try {
            PreparedStatement preparador = con.prepareStatement(sql);
            ResultSet resultados = preparador.executeQuery();

            while (resultados.next()) {
                Funcionario funcionario = new Funcionario();
                funcionario.setMatricula(resultados.getInt("matricula"));
                funcionario.setNome(resultados.getString("nome"));
                funcionario.setSalario(resultados.getDouble("salario"));
                funcionario.setCodSetor(resultados.getInt("codset"));
                lista.add(funcionario);
            }

        } catch (SQLException e) {
            System.out.println("Erro - " + e.getMessage());
        }

        return lista;
    }
}

