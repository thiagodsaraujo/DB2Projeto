package Teste;

import Conexao.Conecta;
import Entidades.Estabelecimento;
import dao.EstabelecimentoDAO;
import dao.FuncionarioDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.IntStream;

public class MainEstabelecimento {


    public static void main(String[] args) {

//        Connection conexao = null;
//        try {
//            conexao = Conecta.criarConexao();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }


//        Scanner entrada = new Scanner(System.in);
//        System.out.println("Informe o nome: ");
//        String nome = entrada.nextLine();
//
//        System.out.println("Informe o codigo: ");
//        int codigo = entrada.nextInt();
//
//
//        cadastrarEstabelecimento(nome,codigo);
        listarEstabelecimentos();
        updateEstabelecimento(2,"NovoEstabelecimento");
        listarEstabelecimentos();
//        deletarEstabelecimento(1);
//        listarEstabelecimentos();

//            var pk = random.ints(1,100).findFirst().getAsInt();


    }



    private static void cadastrarEstabelecimento(String nome, int codigo) {
        String sql = "INSERT INTO estabelecimento VALUES (?, ?)";
        Estabelecimento estabelecimento = new Estabelecimento();

        estabelecimento.setCodigoEstab(codigo);
        estabelecimento.setNomeEstab(nome);

        EstabelecimentoDAO estabelecimentoDAO = new EstabelecimentoDAO();
        estabelecimentoDAO.cadastrarEstabelecimento(estabelecimento);

    }

    private static void updateEstabelecimento(int codigo, String nome) {
        Estabelecimento estabelecimento = new Estabelecimento();
        estabelecimento.setNomeEstab(nome);
        estabelecimento.setCodigoEstab(codigo);

        EstabelecimentoDAO estabelecimentoDAO = new EstabelecimentoDAO();
        estabelecimentoDAO.atualizarEstabelecimentoPorCodigo(estabelecimento);
    }


    private static void deletarEstabelecimento(int codigo) {
        Estabelecimento estabelecimento = new Estabelecimento();
        estabelecimento.setCodigoEstab(codigo);
        EstabelecimentoDAO estabelecimentoDAO = new EstabelecimentoDAO();
        estabelecimentoDAO.deletarEstabelecimento(estabelecimento);
    }

    private static void listarEstabelecimentos() {
        EstabelecimentoDAO estabelecimentoDAO = new EstabelecimentoDAO();
        List<Estabelecimento> listaResultado = estabelecimentoDAO.selectTodos();

        for(Estabelecimento e: listaResultado){
            System.out.println("Codigo do Estabelecimento: "  + e.getCodigoEstab() +
                    "\nNome do Estabelecimento: " + e.getNomeEstab() +
                    "\n-------------------------------"
            );
        }
    }



}

