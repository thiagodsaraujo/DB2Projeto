package controller;

import entidades.Estabelecimento;
import dao.EstabelecimentoDAO;

import java.util.List;

public class EstabelecimentoController {

    public EstabelecimentoController(){

    }


    public void cadastrarEstabelecimento(String nome, int codigo) {
        String sql = "INSERT INTO estabelecimento VALUES (?, ?)";
        Estabelecimento estabelecimento = new Estabelecimento();

        estabelecimento.setCodigoEstab(codigo);
        estabelecimento.setNomeEstab(nome);

        EstabelecimentoDAO estabelecimentoDAO = new EstabelecimentoDAO();
        estabelecimentoDAO.cadastrarEstabelecimento(estabelecimento);

    }

    public  void updateEstabelecimento(int codigo, String nome) {
        Estabelecimento estabelecimento = new Estabelecimento();
        estabelecimento.setNomeEstab(nome);
        estabelecimento.setCodigoEstab(codigo);

        EstabelecimentoDAO estabelecimentoDAO = new EstabelecimentoDAO();
        estabelecimentoDAO.atualizarEstabelecimentoPorCodigo(estabelecimento);
    }


    public  void deletarEstabelecimento(int codigo) {
        Estabelecimento estabelecimento = new Estabelecimento();
        estabelecimento.setCodigoEstab(codigo);
        EstabelecimentoDAO estabelecimentoDAO = new EstabelecimentoDAO();
        estabelecimentoDAO.deletarEstabelecimento(estabelecimento);
    }

    public  void listarEstabelecimentos() {
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
