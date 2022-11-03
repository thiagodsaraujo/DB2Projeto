package Teste;

import Entidades.Funcionario;
import Entidades.Setor;
import dao.FuncionarioDAO;
import dao.SetorDAO;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class Exercicio01 {

    public static void main(String[] args) throws ClassNotFoundException {

        try {
            insereFuncionario();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            insereSetor();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


        listaTodosFuncionarios();
        updateFuncionarioPorNome();
        updateFuncionarioPorMatricula();
        deletarFuncionario();

    }

    private static void listaTodosFuncionarios() {
        FuncionarioDAO funcionarioDAO = null;
        funcionarioDAO = new FuncionarioDAO();

        List<Funcionario> listaResultado = funcionarioDAO.selectTodos();
        for (Funcionario f: listaResultado){
            System.out.println("Matricula: " + f.getMatricula() +
                    "Nome: " + f.getNome() +
                    "Salario: R$ " + f.getSalario() +
                    "Codigo do Setor: " + f.getCodSetor());
        }
    }


    private static void insereSetor() throws SQLException, ClassNotFoundException {
        Setor setor = new Setor();

        setor.setCodigo(3);
        setor.setNomeSet("Setor 03");

        SetorDAO setDao = null;

        setDao = new SetorDAO();
        setDao.cadastrarSetor(setor);

    }

    private static void insereFuncionario() throws SQLException, ClassNotFoundException {
        Funcionario func = new Funcionario();

        func.setMatricula(2);
        func.setCodSetor(2);
        func.setNome("Thiago2");
        func.setCreatedOn(LocalDate.now().toString().strip());
        func.setSalario(3000.0);

        FuncionarioDAO funDao = null;

        funDao = new FuncionarioDAO();
        funDao.cadastrarFuncionario(func);
    }

    private static void updateFuncionarioPorNome() {
        Funcionario func = new Funcionario();
        func.setNome("Thiago");
        func.setSalario(2000);

        FuncionarioDAO funcionarioDAO = null;

        funcionarioDAO = new FuncionarioDAO();
        funcionarioDAO.atualizarSalarioFuncionarioPorNome(func);
    }

    private static void updateFuncionarioPorMatricula() {
        Funcionario func = new Funcionario();
        func.setMatricula(1);
        func.setSalario(3123);

        FuncionarioDAO funcionarioDAO = null;

        funcionarioDAO = new FuncionarioDAO();
        funcionarioDAO.atualizarSalarioFuncionarioPorMatricula(func);
    }

    private static void deletarFuncionario() {
        Funcionario funcionario = new Funcionario();
        funcionario.setNome("Thiago2");
        FuncionarioDAO funcionarioDAO = null;

        funcionarioDAO = new FuncionarioDAO();
        funcionarioDAO.deletarFuncionario(funcionario);
    }

}
