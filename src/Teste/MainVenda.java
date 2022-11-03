package Teste;

import java.util.Scanner;

public class MainVenda {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        System.out.println("Informe o codigo da Venda: ");
        int codigoVenda = entrada.nextInt();
        entrada.nextLine();

        System.out.println("Informe o codigo do Produto: ");
        int codigoProduto = entrada.nextInt();
        entrada.nextLine();

        System.out.println("Informe o codigo do Vendedor: ");
        int codVendedor = entrada.nextInt();
        entrada.nextLine();

        System.out.println("Informe a quantidade Vendida: ");
        String qtd = entrada.nextLine();


        //TODO: PRECISA PEGAR O VALOR DO PRODUTO E MULTIPLICAR PELA QUANTIDADE VENDIDA
        // TUDO ISSO DENTRO DE UM SQL, COLOCAR NO VendaDAo e fazer esse calculo.

        cadastrarVenda(codigoVenda,codigoProduto,codVendedor,qtd);

    }

    private static void cadastrarVenda(int codigoVenda, int codigoProduto, int codVendedor, String qtd) {

    }

}
