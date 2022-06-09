package br.uniesp.poo.ted04;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class MenuLocadora implements Serializable{
    private static final long serialVersionUID = 1L;
    
    public void menu() throws Exception{
        ArrayList<Object> veiculos = ManipulaArquivo.lerArquivo("veiculos.dat");
        Scanner leitor = new Scanner(System.in);
        int opc = 0;
        
        while(true) {
            System.out.println("\n\t\t --- LOCADORA DE VEÍCULOS ---\n\n\t\t1 - Cadastrar Veículos\n\t\t2 - Cadastrar Clientes\n\t\t3 - Realizar Locação\n\t\t4 - Listar Veículos Cadastrados\n\t\t5 - Listar Clientes Cadastrados\n\t\t6 - Listar Locações Realizadas\n\t\t7 - Listar Veículos Disponíveis Para Locação\n\t\t0 - Encerrar");
            
            System.out.print("\n\t\tEscolha uma das Opções acima: ");
            String num  = leitor.nextLine();

            if (IsNumeric.numInt(num)) {
                opc = Integer.parseInt(num);
                break;

            } else {
                System.out.println("\t\tOpção inválida, tente novamente");
            }
        }

        switch (opc) {
            case 1:
            CadastroVeiculos cadVeiculos = new CadastroVeiculos();
                while (true) {
                    System.out.println("\n\n\t\t--- CADASTRAR VEÍCULOS ---\n\t\tQual tipo de veiculo deseja cadastrar \n\n\t\t1 - Carro \n\t\t2 - Moto \n\t\t3 - Nave \n\t\t0 - Voltar");

                    System.out.print("\n\t\tEscolha uma das Opções acima: ");
                    String num  = leitor.nextLine();

                    if (IsNumeric.numInt(num)) {
                    opc = Integer.parseInt(num);
                    break;

                    } else {
                    System.out.println("\t\tOpção inválida, tente novamente");
                    }
                }
                switch (opc) {
                    case 1:
                        cadVeiculos.cadastraCarro();
                        menu();
                        break;

                    case 2:
                        cadVeiculos.cadastraMoto();
                        menu();
                        break;

                    case 3:
                        cadVeiculos.cadastraNave();
                        menu();
                        break;

                    case 0:
                        System.out.println("\n\t\tVoltando ao Menu Principal");
                        menu();
                        break;

                    default:
                        System.out.println("\t\tOpção inválida, tente novamente");
                        menu();
                        break;
                }
                break;

            case 2:
                CadastroCliente cadCliente = new CadastroCliente();
                cadCliente.cadastraCliente();
                menu();
                break;

            case 3:
                RealizaLocacao reLocacao = new RealizaLocacao();
                reLocacao.locacao();
                menu();
                break;

            case 4:
                for(Object veiculo : veiculos) {
                System.out.println(veiculo);
                }
                menu();
                break;

            case 5:
                ArrayList<Object> clientes = ManipulaArquivo.lerArquivo("clientes.dat");
                for (Object cliente : clientes) {
                    System.out.println(cliente);
                }
                
                menu();
                break;

            case 6:
                ArrayList<Object> locacoes = ManipulaArquivo.lerArquivo("locacoes.dat");
                for (Object locacao : locacoes) {
                    System.out.println(locacao);
                }
            
                menu();
                break;
            case 7:
                System.out.println("\n\t\t--- VEÍCULOS DISPONÍVEIS ---");
                for(Object veiculo : veiculos) {
                    if(((Veiculo)veiculo).getDisponivel().equals("S")) {
                        System.out.println(veiculo);
                    }
                }
                menu();
                break;

            case 0:
                System.out.println("\n\t\tPrograma Encerrado.");
                break;

            default:
                System.out.println("\n\t\tOpção inválida, tente novamente");
                menu();
                break;
        }
        leitor.close();
    }
}
