package Teste;

import Controller.ProdutoController;
import Controller.VendedorController;
import Entidades.Produto;
import dao.ProdutoDAO;

import java.util.List;
import java.util.Scanner;

public class MainProduto {



//        Scanner entrada = new Scanner(System.in);
//
//        System.out.println("Informe o codigo do Produto: ");
//        int codigoProduto = entrada.nextInt();
//        entrada.nextLine();
//
//        System.out.println("Informe o nome do Produto: ");
//        String descricao = entrada.nextLine();
//
//        System.out.println("Informe o valor do Produto: ");
//        Double valor = entrada.nextDouble();
//
//

//        System.out.println(retornarQtdEstoque(1));
//        cadastrarProduto(1,"Mouse",200.0, 2);
//        cadastrarProduto(2,"Teclado",300.0, 1);
//        cadastrarProduto(3,"Monitor",500.0, 1);
//        listarProduto();
//        retornarQtdEstoque(1);
//        atualizarValorProdutoPorCodigo(1, 250.0);
//        atualizarValorProdutoPorDescricao("Teclado", 350.0);
//        deletarProdutoPorCodigo(3);
//        System.out.println("\nLista Atualizada\n");
//        listarProduto();



//            var pk = random.ints(1,100).findFirst().getAsInt();
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
                System.out.println("Informe o valor do estabelecimento do vendedor: ");
                Double valor = entrada.nextDouble();
                entrada.nextLine();
                System.out.println("Informe a quantidade do do vendedor: ");
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
                System.out.println("Informe a Matricula do vendedor que deseja alterar: ");
                int matriculaAtt = entradaAtt.nextInt();
                entradaAtt.nextLine();
                System.out.println("Informe o NOVO SALARIO desejado para o Vendedor: ");
                Double salarioAtt = entradaAtt.nextDouble();
                entradaAtt.nextLine();
//                controller.atualizarSalarioVendedorPorMatricula(matriculaAtt,salarioAtt);
                return true;

            case 3:
                Scanner entradaDelete = new Scanner(System.in);
                System.out.println("DELEÇÃO DO VENDEDOR POR MATRICULA");
//                controller.listarVendedores();
                System.out.println("\n");
                System.out.println("Informe a matricula do Vendedor que deseja deletar: ");
                int codigoDelete = entradaDelete.nextInt();
//                controller.deletarVendedor(codigoDelete);
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
                "MANIPULAÇÃO VENDEDOR" +
                "\n-----------------------------------------" + "\n" +
                "DIGITE A OPÇÃO DESEJADA: " + "\n" +
                "[1] Para CADASTRAR um vendedor" + "\n" +
                "[2] Para ATUALIZAR um vendedor" + "\n" +
                "[3] Para DELETAR um vendedor" + "\n" +
                "-----------------------------------------");


        Scanner sc = new Scanner(System.in);


        int escolha = sc.nextInt();

        return escolha; // retorna o numero que o usuário escreveu
    }
}

