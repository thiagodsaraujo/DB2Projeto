package controller;

import entidades.Vendedor;
import dao.VendedorDAO;

import java.util.List;

public class VendedorController {

    public VendedorController(){

    }

    public void cadastrarVendedor(int matricula, int codEstab, String nome, Double salario) {
        Vendedor vendedor = new Vendedor();

        vendedor.setMatricula(matricula);
        vendedor.setCodEst(codEstab);
        vendedor.setNome(nome);
        vendedor.setSalario(salario);

        VendedorDAO vendedorDAO = new VendedorDAO();

        vendedorDAO.cadastrarVendedor(vendedor);
    }

    public void deletarVendedor(int matricula) {
        Vendedor vendedor = new Vendedor();

        vendedor.setMatricula(matricula);

        VendedorDAO vendedorDAO = new VendedorDAO();

        vendedorDAO.deletarVendedorPorMatricula(vendedor);
    }


    public void atualizarSalarioVendedorPorNome(String nome, Double salario) {
        Vendedor vendedor = new Vendedor();

        vendedor.setNome(nome);
        vendedor.setSalario(salario);

        VendedorDAO vendedorDAO = new VendedorDAO();

        vendedorDAO.atualizarSalarioVendedorPorNome(vendedor);
    }

    public void atualizarSalarioVendedorPorMatricula(int matricula, Double salario) {
        Vendedor vendedor = new Vendedor();

        vendedor.setMatricula(matricula);
        vendedor.setSalario(salario);

        VendedorDAO vendedorDAO = new VendedorDAO();

        vendedorDAO.atualizarSalarioVendedorPorMatricula(vendedor);
    }

    public void listarVendedores() {

        VendedorDAO vendedorDAO = new VendedorDAO();

        List<Vendedor> listaResultado = vendedorDAO.selectTodos();

        for (Vendedor v: listaResultado){
            System.out.println("- Nome do Vendedor: "  + v.getNome()  +
                    "\n- Matricula do Vendedor: " + v.getMatricula()  +
                    "\n- Código do Estabelecimento" + v.getCodEst() +
                    "\n- Salário do Vendedor: R$ " + v.getSalario() +
                    "\n------------------------------");
        }
    }
}
