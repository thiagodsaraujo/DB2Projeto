package Teste;

import Controller.ProdutoController;
import Controller.VendedorController;
import Entidades.Produto;
import dao.ProdutoDAO;

import java.util.List;
import java.util.Scanner;

public class MainProduto {


public static void main(String[] args) {

    Escolha3 esc = new Escolha3();

    boolean val = false;

    while(val == false) { // Enquanto "val"for "false" o while vai ficar fazendo loop, mas quando se tornar "true" ele vai parar
        int opc = esc.menu();
        val = esc.escolher(opc);
    }
}
}

class Escolha3 {

    ProdutoController controller = new ProdutoController();

    public boolean escolher(int escolha) {
        switch (escolha) {

            case 1:
                System.out.println("CADASTRO DO PRODUTO");
                Scanner entrada = new Scanner(System.in);
                System.out.println("Informe o codigo do Produto: ");
                int codigoProduto = entrada.nextInt();
                entrada.nextLine();
                System.out.println("Informe a descricao desejado para o vendedor: ");
                String descricao = entrada.nextLine();
                System.out.println("Informe o valor do Produto:" + descricao + " para cadastro em R$: ");
                Double valor = entrada.nextDouble();
                entrada.nextLine();
                System.out.println("Informe a quantidade no estoque: ");
                int quantidade = entrada.nextInt();
                entrada.nextLine();
                controller.cadastrarProduto(codigoProduto,descricao,valor,quantidade);
                entrada.close();
                return true;
            case 2:
                Scanner entradaAtt = new Scanner(System.in);
                System.out.println("ATUALIZAÇÃO DO VALOR DO PRODUTO POR CODIGO");
                controller.listarProduto();
                System.out.println("\n");
                System.out.println("Informe o Codigo do Produto que deseja alterar: ");
                int matriculaAtt = entradaAtt.nextInt();
                entradaAtt.nextLine();
                System.out.println("Informe o NOVO VALOR desejado para o produto: ");
                Double salarioAtt = entradaAtt.nextDouble();
                entradaAtt.nextLine();
//                controller.atualizarSalarioVendedorPorMatricula(matriculaAtt,salarioAtt);
                return true;

            case 3:
                Scanner entradaDelete = new Scanner(System.in);
                System.out.println("DELEÇÃO DO PRODUTO POR CÓDIGO");
//                controller.listarVendedores();
                System.out.println("\n");
                System.out.println("Informe o codigo do Produto que deseja deletar: ");
                int codigoDelete = entradaDelete.nextInt();
                controller.deletarProdutoPorCodigo(codigoDelete);
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
                "MANIPULAÇÃO PRODUTO" +
                "\n-----------------------------------------" + "\n" +
                "DIGITE A OPÇÃO DESEJADA: " + "\n" +
                "[1] Para CADASTRAR um produto" + "\n" +
                "[2] Para ATUALIZAR um produto" + "\n" +
                "[3] Para DELETAR um produto" + "\n" +
                "-----------------------------------------");


        Scanner sc = new Scanner(System.in);


        int escolha = sc.nextInt();

        return escolha; // retorna o numero que o usuário escreveu
    }
}

