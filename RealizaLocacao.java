package br.uniesp.poo.ted04;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

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
        System.out.println("\n\t\t--- REALIZANDO LOCAÇÃO ---");
        
        try {
            System.out.print("\t\tInforme o Número de identificação do veiculo: ");
            idVeiculo = leitor.next();
            isNumericInt(idVeiculo);
            veic = (Veiculo) verificaVeiculoDisponivel(idVeiculo);

            System.out.print("\t\tInforme CPF do Cliente Cadastrado: ");
            cpfCliente = leitor.next();
            isNumericInt(cpfCliente);
            cli = (Cliente) verificaClienteCadastrado(cpfCliente);

            System.out.print("\t\tInforme a Quantidade de diárias: ");
            strNum = leitor.next();
            isNumericInt(strNum);
            diarias = Integer.parseInt(strNum);
            
            System.out.print("\t\tInforme se a locação de seguro(S/N): ");
            seguro = leitor.next().toUpperCase();
            validaSeguro(seguro);

            System.out.print("\t\tInforme o desconto: ");
            strNum = leitor.next();
            if (!isNumericFloat(strNum)){
                throw new Exception("\n\t\tERRO: Valor inválido, tente novamente");
            }
            desconto = Double.parseDouble(strNum);
            validaDesconto(desconto);

            LocacaoVeiculo l = new LocacaoVeiculo(cli, diarias, seguro, desconto);
            locacoes.add(l);
            ManipulaArquivo.gravarArquivo(locacoes, "locacoes.dat");

            System.out.println("\t\tValor Total da Locação = R$ " + calculaLocacao());
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    private double calculaSeguro() {
        int numPassageiros = veic.getQtdPassageiros();
        String tipoMotor = veic.getMotor();
        double valorSeguro = 0;
        double valorDiaria = veic.getValorDiaria();
        if(veic.getTipo().equals("Carro")) {
            valorSeguro = 0.05 * valorDiaria * (1 + numPassageiros/20);
        } else if (veic.getTipo().equals("Moto")) {
            valorSeguro = 0.09 * valorDiaria;
        } else if (veic.getTipo().equals("Nave")) {
            valorSeguro = 2 * valorDiaria;
            if (tipoMotor.equals("A")) {
                valorSeguro = valorSeguro * 2;
            }
        }
        return valorSeguro;
    }

    private double calculaLocacao() {
        double valorLocacao = 0;
        double valorSeguro = 0;
        double valorDesconto = 0;
        valorLocacao = diarias * veic.getValorDiaria();
        if (seguro.equals("S")) {
            valorSeguro = calculaSeguro();
            valorLocacao = valorLocacao + valorSeguro;
        }
        valorDesconto = valorLocacao * (desconto/100);
        valorLocacao = valorLocacao - valorDesconto;
        return valorLocacao;
    }

    private Object verificaClienteCadastrado(String cpfCliente) throws Exception {
        for (Object cliente : clientes) {
            if (((Cliente) cliente).getCpf().equals(cpfCliente)) {
                return cliente;
            }
        }
        throw new Exception("\t\tERR0: Cliente não está cadastrado");
    }

    private Object verificaVeiculoDisponivel(String idVeiculo) throws Exception {
        for (Object veiculo : veiculos) {
            if (((Veiculo) veiculo).getIdentificacao().equals(idVeiculo)) {
                return veiculo;
            }
        }
        throw new Exception("\t\tERR0: Veículo não está disponível");
    }

    private boolean isNumericInt(String strNum) throws Exception {
        Pattern patternInt = Pattern.compile("-?\\d+?");
        if (strNum == null) {
            throw new Exception("\t\tERRO: Valor inválido, tente novamente");
        }
        return patternInt.matcher(strNum).matches();
    }

    private boolean isNumericFloat(String strNum) throws Exception {
        Pattern patternFloat = Pattern.compile("-?\\d+(\\.\\d+)?");
        if (strNum == null) {
            throw new Exception("\n\t\tERRO: Valor inválido, tente novamente");
        }
        return patternFloat.matcher(strNum).matches();
    }

    private boolean validaSeguro(String str) throws Exception {
        if (str.length() <= 0 || str.length() > 1) {
            throw new Exception("\n\t\tERRO: Valor inválido, tente novamente");
        } else if(!(str.equals("S") || str.equals("N"))) {
            throw new Exception("\n\t\tERRO: Valor inválido, tente novamente");
        }
        return true;
    }

    private void validaDesconto(Double desconto) throws Exception{
        if(desconto < 0 || desconto > 12){
            throw new Exception("\n\t\tERRO: O desconto só permitido entre 0 e 12%");
        }
    }
}
