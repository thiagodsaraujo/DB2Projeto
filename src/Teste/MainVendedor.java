package Teste;

import Entidades.Vendedor;
import dao.VendedorDAO;

import java.util.List;
import java.util.Scanner;

public class MainVendedor {

    public static void main(String[] args) {

//        Scanner entrada = new Scanner(System.in);
//        System.out.println("Informe o nome do Vendedor: ");
//        String nome = entrada.nextLine();
//        System.out.println("Informe a matricula do Vendedor: ");
//        int matricula = entrada.nextInt();
//        System.out.println("Informe o Codógio do estabelecimento do Vendedor: ");
//        int codEstab = entrada.nextInt();
//        System.out.println("Informe o Salário do Vendedor: ");
//        Double salario = entrada.nextDouble();
//
//
//        cadastrarVendedor(matricula, codEstab, nome, salario);

        cadastrarVendedor(2, 3, "Felipe", 3000.0);
//        cadastrarVendedor(3, 2, "Caio", 3000.0);
//        cadastrarVendedor(4, 2, "Excluir", 3000.0);
        listarVendedores();
        atualizarSalarioVendedorPorMatricula(2, 12345.0);
        atualizarSalarioVendedorPorNome("Caio", 3333.3);
        deletarVendedor(4);
        System.out.println("Lista Atualizada");
        listarVendedores();

    }

    private static void listarVendedores() {

        VendedorDAO vendedorDAO = new VendedorDAO();

        List<Vendedor> listaResultado = vendedorDAO.selectTodos();

        for (Vendedor v: listaResultado){
            System.out.println("- Nome do Vendedor: "  + v.getMatricula()  +
                    "\n- Matricula do Vendedor: " + v.getMatricula()  +
                    "\n- Código do Estabelecimento" + v.getCodEst() +
                    "\n- Salário do Vendedor: R$ " + v.getSalario() +
                    "\n------------------------------");
        }
    }


    private static void cadastrarVendedor(int matricula, int codEstab, String nome, Double salario) {
        Vendedor vendedor = new Vendedor();

        vendedor.setMatricula(matricula);
        vendedor.setCodEst(codEstab);
        vendedor.setNome(nome);
        vendedor.setSalario(salario);

        VendedorDAO vendedorDAO = new VendedorDAO();

        vendedorDAO.cadastrarVendedor(vendedor);
    }

    private static void deletarVendedor(int matricula) {
        Vendedor vendedor = new Vendedor();

        vendedor.setMatricula(matricula);

        VendedorDAO vendedorDAO = new VendedorDAO();

        vendedorDAO.deletarVendedorPorMatricula(vendedor);
    }


    private static void atualizarSalarioVendedorPorNome(String nome, Double salario) {
        Vendedor vendedor = new Vendedor();

        vendedor.setNome(nome);
        vendedor.setSalario(salario);

        VendedorDAO vendedorDAO = new VendedorDAO();

        vendedorDAO.atualizarSalarioVendedorPorNome(vendedor);
    }

    private static void atualizarSalarioVendedorPorMatricula(int matricula, Double salario) {
        Vendedor vendedor = new Vendedor();

        vendedor.setMatricula(matricula);
        vendedor.setSalario(salario);

        VendedorDAO vendedorDAO = new VendedorDAO();

        vendedorDAO.atualizarSalarioVendedorPorMatricula(vendedor);
    }

}
