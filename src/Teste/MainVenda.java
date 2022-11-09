package Teste;

import Controller.ProdutoController;
import Controller.VendaController;
import Controller.VendedorController;

import java.util.Scanner;

public class MainVenda {

    public static void main(String[] args) {

        Escolha3 esc = new Escolha3();

        boolean val = false;

        while(val == false) { // Enquanto "val"for "false" o while vai ficar fazendo loop, mas quando se tornar "true" ele vai parar
            int opc = esc.menu();
            val = esc.escolher(opc);
        }
    }
}

class Escolha4 {

    VendaController controller = new VendaController();

    public boolean escolher(int escolha) {
        switch (escolha) {

            case 1:
                System.out.println("CADASTRO DE VENDA");
                Scanner entrada = new Scanner(System.in);
                System.out.println("Informe o codigo da VENDA: ");
                int codigoVenda = entrada.nextInt();
                entrada.nextLine();
                System.out.println("Informe o código do Produto a ser vendido: ");
                int codigoProduto = entrada.nextInt();
                System.out.println("Informe o código do Vendedor que irá realizar a venda: ");
                int codigoVendedor = entrada.nextInt();
                entrada.nextLine();
                System.out.println("Informe a quantidade vendida: ");
                int quantidade = entrada.nextInt();
                entrada.nextLine();
                controller.cadastrarVenda(codigoVenda,codigoProduto,codigoVendedor,quantidade);
                entrada.close();
                return true;
            case 2:
                Scanner entradaDelete = new Scanner(System.in);
                System.out.println("DELEÇÃO DE VENDA POR CÓDIGO");
                controller.listarVendas();
                System.out.println("\n");
                System.out.println("Informe o codigo da Venda que deseja deletar: ");
                int codigoDelete = entradaDelete.nextInt();
                controller.deletarVendaPorCodigo(codigoDelete);
                return true;
            default:
                System.out.println("Opção inválida" + "\n" + "Por favor, escolha um de nossos serviços.");
        }
        return false; // Caso nenhuma das opções acima tenha sido escolhida ele cai aqui nesse "return false", fazendo com que o while rode novamente

    }

    public int menu() {
        System.out.println("-----------------------------------------" + "\n" +
                "BEM VINDO AO SISTEMA DO PROJETO BD2" + "\n" +
                "-----------------------------------------" + "\n" +
                "MANIPULAÇÃO DE VENDAS" +
                "\n-----------------------------------------" + "\n" +
                "DIGITE A OPÇÃO DESEJADA: " + "\n" +
                "[1] Para CADASTRAR uma VENDA" + "\n" +
                "[2] Para DELETAR uma VENDA" + "\n" +
                "-----------------------------------------");


        Scanner sc = new Scanner(System.in);


        int escolha = sc.nextInt();

        return escolha; // retorna o numero que o usuário escreveu
    }

}
