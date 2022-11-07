package Teste;

import Controller.EstabelecimentoController;
import Controller.VendedorController;
import Entidades.Vendedor;
import dao.VendedorDAO;

import java.util.List;
import java.util.Scanner;

public class MainVendedor {

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


        public static void main(String[] args) {

            Escolha2 esc = new Escolha2();

            boolean val = false;

            while(val == false) { // Enquanto "val"for "false" o while vai ficar fazendo loop, mas quando se tornar "true" ele vai parar
                int opc = esc.menu();
                val = esc.escolher(opc);
            }
        }
    }

    class Escolha2 {

        VendedorController controller = new VendedorController();

        public boolean escolher(int escolha) {
            switch (escolha) {

                case 1:
                    System.out.println("CADASTRO DO VENDEDOR");
                    Scanner entrada = new Scanner(System.in);
                    System.out.println("Informe a matricula do vendedor: ");
                    int matricula = entrada.nextInt();
                    entrada.nextLine();
                    System.out.println("Informe o nome desejado para o vendedor: ");
                    String nome = entrada.nextLine();
                    System.out.println("Informe o codigo do estabelecimento do vendedor: ");
                    int codEstab = entrada.nextInt();
                    entrada.nextLine();
                    System.out.println("Informe o salario do do vendedor: ");
                    Double salario = entrada.nextDouble();
                    entrada.nextLine();
                    controller.cadastrarVendedor(matricula,codEstab,nome,salario);
                    entrada.close();
                    return true;
                case 2:
                    Scanner entradaAtt = new Scanner(System.in);
                    System.out.println("ATUALIZAÇÃO DO SALARIO DO VENDEDOR POR MATRICULA");
                    controller.listarVendedores();
                    System.out.println("\n");
                    System.out.println("Informe a Matricula do vendedor que deseja alterar: ");
                    int matriculaAtt = entradaAtt.nextInt();
                    entradaAtt.nextLine();
                    System.out.println("Informe o NOVO SALARIO desejado para o Vendedor: ");
                    Double salarioAtt = entradaAtt.nextDouble();
                    entradaAtt.nextLine();
                    controller.atualizarSalarioVendedorPorMatricula(matriculaAtt,salarioAtt);
                    return true;

                case 3:
                    Scanner entradaDelete = new Scanner(System.in);
                    System.out.println("DELEÇÃO DO VENDEDOR POR MATRICULA");
                    controller.listarVendedores();
                    System.out.println("\n");
                    System.out.println("Informe a matricula do Vendedor que deseja deletar: ");
                    int codigoDelete = entradaDelete.nextInt();
                    controller.deletarVendedor(codigoDelete);
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
