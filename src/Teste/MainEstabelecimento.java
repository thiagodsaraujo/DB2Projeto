package Teste;

import Controller.EstabelecimentoController;
import java.util.Scanner;

public class MainEstabelecimento {


    public static void main(String[] args) {

        Escolha esc = new Escolha();

        boolean val = false;

        while(val == false) { // Enquanto "val"for "false" o while vai ficar fazendo loop, mas quando se tornar "true" ele vai parar
            int opc = esc.menu();
            val = esc.escolher(opc);
        }
    }
}

class Escolha {

    EstabelecimentoController controller = new EstabelecimentoController();

    public boolean escolher(int escolha) {
        switch (escolha) {

            case 1:
                System.out.println("CADASTRO DO ESTABELECIMENTO");
                Scanner entrada = new Scanner(System.in);
                System.out.println("Informe o nome desejado para o Estabelecimento: ");
                String nome = entrada.nextLine();
                System.out.println("Informe o codigo do Estabelecimento: ");
                int codigo = entrada.nextInt();
                controller.cadastrarEstabelecimento(nome,codigo);
                entrada.close();
                return true;
            case 2:
                Scanner entradaAtt = new Scanner(System.in);
                System.out.println("ATUALIZAÇÃO DO ESTABELECIMENTO POR CÓDIGO");
                controller.listarEstabelecimentos();
                System.out.println("\n");
                System.out.println("Informe o codigo do Estabelecimento que deseja alterar: ");
                int codigoAtt = entradaAtt.nextInt();
                entradaAtt.nextLine();
                System.out.println("Informe o NOVO nome desejado para o Estabelecimento: ");
                String nomeAtt = entradaAtt.nextLine();
                controller.updateEstabelecimento(codigoAtt,nomeAtt);
                return true;

            case 3:
                Scanner entradaDelete = new Scanner(System.in);
                System.out.println("DELEÇÃO DO ESTABELECIMENTO POR CÓDIGO");
                controller.listarEstabelecimentos();
                System.out.println("\n");
                System.out.println("Informe o codigo do Estabelecimento que deseja deletar: ");
                int codigoDelete = entradaDelete.nextInt();
                controller.deletarEstabelecimento(codigoDelete);
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
                "MANIPULAÇÃO ESTABELECIMENTOS" +
                "\n-----------------------------------------" + "\n" +
                "DIGITE A OPÇÃO DESEJADA: " + "\n" +
                "[1] Para CADASTRAR um estabelecimento" + "\n" +
                "[2] Para ATUALIZAR um estabelecimento" + "\n" +
                "[3] Para DELETAR um estabelecimento" + "\n" +
                "-----------------------------------------");


        Scanner sc = new Scanner(System.in);


        int escolha = sc.nextInt();

        return escolha; // retorna o numero que o usuário escreveu
    }
}

