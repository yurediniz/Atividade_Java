package br.uniesp.poo.ted04;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class RealizaLocacao implements Serializable{
    private static final long serialVersionUID = 1L;
    private Veiculo veic;
    private Cliente cli;
    private String idVeiculo;
    private String cpfCliente;
    private int diarias;
    private String seguro;
    private double desconto;
    private String strNum;

    ArrayList<Object> clientes = ManipulaArquivo.lerArquivo("clientes.dat");
    ArrayList<Object> veiculos = ManipulaArquivo.lerArquivo("veiculos.dat");
    ArrayList<Object> locacoes = ManipulaArquivo.lerArquivo("locacoes.dat");
    
    
    Scanner leitor = new Scanner(System.in);
    public void locacao() {
        double valorLocacao = 0;
        double valorSeguro = 0;
        double valorDesconto = 0;
        System.out.println("\n\t\t--- REALIZANDO LOCAÇÃO ---");
        
        try {
            System.out.print("\t\tInforme CPF do Cliente Cadastrado: ");
            cpfCliente = leitor.nextLine().trim();
            cli = (Cliente) verificaClienteCadastrado(cpfCliente);

            System.out.print("\t\tInforme o Número de identificação do veiculo: ");
            idVeiculo = leitor.nextLine().trim();
            veic = (Veiculo) verificaVeiculoDisponivel(idVeiculo);

            System.out.print("\t\tInforme a Quantidade de diárias: ");
            strNum = leitor.nextLine().trim();
            diarias = validaDiarias(strNum);
            
            System.out.print("\t\tInforme se a locação é com seguro(S/N): ");
            seguro = leitor.nextLine().toUpperCase().trim();
            validaSeguro(seguro);

            System.out.print("\t\tInforme o desconto: ");
            strNum = leitor.nextLine().trim();
            desconto = validaDesconto(strNum);

            if (seguro.equals("S")) {
                valorSeguro = calculaSeguro();
            }
            valorLocacao = (diarias * veic.getValorDiaria()) + valorSeguro;
            valorDesconto = valorLocacao * (desconto/100);
            valorLocacao = valorLocacao - valorDesconto;
            System.out.println("\t\tValor Total da Locação = R$ " + valorLocacao);
            

            LocacaoVeiculo l = new LocacaoVeiculo(cli, veic, diarias, seguro, valorSeguro, desconto, valorDesconto, valorLocacao);
            locacoes.add(l);
            ManipulaArquivo.gravarArquivo(locacoes, "locacoes.dat");
            
            veiculos.remove(veic);
            veic.setDisponivel("N");
            veiculos.add(veic);
            ManipulaArquivo.gravarArquivo(veiculos, "veiculos.dat");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    private double calculaSeguro() {
        double valorSeguro = 0;
        if(veic.getTipo().equals("Carro")) {
            valorSeguro = 0.05 * veic.getValorDiaria() * (1.0 + veic.getQtdPassageiros()/20.0);
        } else if (veic.getTipo().equals("Moto")) {
            valorSeguro = 0.09 * veic.getValorDiaria();
        } else if (veic.getTipo().equals("Nave")) {
            valorSeguro = 0.2 * veic.getValorDiaria();
            if (veic.getMotor().equals("A")) {
                valorSeguro = valorSeguro * 2.0;
            }
        }
        valorSeguro = valorSeguro * diarias;
        return valorSeguro;
    }

    private Object verificaClienteCadastrado(String cpfCliente) throws Exception {
        if(!(cpfCliente.length() == 11) || !(IsNumeric.numInt(cpfCliente))) {
            throw new Exception("\n\t\tERRO: Número de CPF Inválido, informe apenas on números");
        }
        for (Object cliente : clientes) {
            if (((Cliente) cliente).getCpf().equals(cpfCliente)) {
                return cliente;
            }
        }
        throw new Exception("\n\t\tERR0: Cliente não está cadastrado");
    }

    private Object verificaVeiculoDisponivel(String idVeiculo) throws Exception {
        if (!IsNumeric.numInt(idVeiculo)  || !(idVeiculo.length() == 3)) {
            throw new Exception("\n\t\tERR0: Número de Identificação inválido. O Número de Identificação é um número inteiro com 3 dígitos");
        }
        for (Object veiculo : veiculos) {
            if (((Veiculo) veiculo).getIdentificacao().equals(idVeiculo)) {
                if(((Veiculo) veiculo).getDisponivel().equals("S")) {
                    return veiculo;
                } else if(((Veiculo) veiculo).getDisponivel().equals("N")) {
                    throw new Exception("\n\t\tERR0: Veículo não está disponível");
                }
            }
        }
        throw new Exception("\n\t\tERR0: Veículo com Número de Identificação não Cadastrado");
    }

    private void validaSeguro(String str) throws Exception {
        if (!(str.length() == 1) && (!str.equals("S") || str.equals("N"))) {
            throw new Exception("\n\t\tERRO: Valor inválido, digite 'S' para Sim ou 'N'para Não");
        }
    }

    private double validaDesconto(String strNum) throws Exception {
        if(!IsNumeric.numFloat(strNum)) {
            throw new Exception("\n\t\tERRO: Valor Inválido.");
        }
        double desc = Double.parseDouble(strNum);
        if(desc < 0 || desc > 12){
            throw new Exception("\n\t\tERRO: O desconto permitido é entre 0 e 12%");
        }
        return desc;
    }
    
    private int validaDiarias(String strNum) throws Exception {
        if(!IsNumeric.numInt(strNum)) {
            throw new Exception("\n\t\tERRO: Valor Inválido.");
        }
        int numInt = Integer.parseInt(strNum);
        if(numInt < 1 || numInt > 365) {
            throw new Exception("\n\t\tERRO: Quantidade de Diárias - MIN = 1 e MAX = 365");
        }
        return numInt;
    }
}
