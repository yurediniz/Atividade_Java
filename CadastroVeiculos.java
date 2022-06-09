package br.uniesp.poo.ted04;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class CadastroVeiculos implements Serializable{
    private static final long serialVersionUID = 1L;
    private String numIdent;
    private String descricao;
    private double valorDiaria;
    private int qtdPassageiros;
    private String partida;
    private String motor;
    private String strNum;

    ArrayList<Object> veiculos = ManipulaArquivo.lerArquivo("veiculos.dat");
    
    Scanner leitor = new Scanner(System.in);
    
    public void cadastraCarro() {
        
        try {
            System.out.println("\n\n\t\t--- CADASTRANDO CARRO---");
            System.out.println("\n\n\t\t--- Informe os dados do Carro ---");

            System.out.print("\t\tIdentificação (Somente números(3 Dígitos) - ex.001): ");
            numIdent = leitor.nextLine().trim();
            verificaNumIdent(numIdent);

            System.out.print("\t\tModelo/Descrição: ");
            descricao = leitor.nextLine().toUpperCase().trim();
            verificaDescricacao(descricao);

            System.out.print("\t\tQuantidade de passageiros(Min = 2 / Max = 7): ");
            strNum = leitor.nextLine().trim();
            qtdPassageiros = verificaQtdPassageiros(strNum);

            System.out.print("\t\tValor da diária: ");
            strNum = leitor.nextLine().trim();
            valorDiaria = verificaValorDiarias(strNum);

            Carro c = new Carro(numIdent, descricao, qtdPassageiros, valorDiaria);
            veiculos.add(c);
            ManipulaArquivo.gravarArquivo(veiculos, "veiculos.dat");

            System.out.println("\n\t\tCarro cadastrado com sucesso");
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public void cadastraMoto() {

        try {
            System.out.println("\n\n\t\t--- CADASTRANDO MOTO ---");
            System.out.println("\n\n\t\t--- Informe os dados da Moto ---");

            System.out.print("\t\tIdentificação (Somente números(3 Dígitos) - ex.001): ");
            numIdent = leitor.nextLine().trim();
            verificaNumIdent(numIdent);

            System.out.print("\t\tModelo/Descrição: ");
            descricao = leitor.nextLine().toUpperCase().trim();
            verificaDescricacao(descricao);

            System.out.print("\t\tPartida elétrica(S/N): ");
            partida = leitor.nextLine().toUpperCase().trim();
            verificaPartida(partida);

            System.out.print("\t\tValor da diária: ");
            strNum = leitor.nextLine().trim();
            valorDiaria = verificaValorDiarias(strNum);

            Moto m = new Moto(numIdent, descricao, partida, valorDiaria);
            veiculos.add(m);
            ManipulaArquivo.gravarArquivo(veiculos, "veiculos.dat");

            System.out.println("\n\t\tMoto cadastrada com sucesso");
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void cadastraNave() {

        try {
            System.out.println("\n\n\t\t--- CADASTRANDO NAVE ---");
            System.out.println("\n\n\t\t--- Informe os dados da Nave ---");

            System.out.print("\t\tIdentificação (Somente números (3 Dígitos) - ex.001): ");
            numIdent = leitor.nextLine().trim();
            verificaNumIdent(numIdent);

            System.out.print("\t\tModelo/Descrição: ");
            descricao = leitor.nextLine().toUpperCase().trim();
            descricao = descricao.toUpperCase();
            verificaDescricacao(descricao);

            System.out.print("\t\tTipo de motor - Atômico(A) ou Elétrico(E) - (A/E): ");
            motor = leitor.nextLine().toUpperCase().trim();
            verificaMotor(motor);

            System.out.print("\t\tValor da diária: ");
            strNum = leitor.nextLine().trim();
            valorDiaria = verificaValorDiarias(strNum);

            Nave n = new Nave(numIdent, descricao, motor, valorDiaria);
            veiculos.add(n);
            ManipulaArquivo.gravarArquivo(veiculos, "veiculos.dat");

            System.out.println("\n\t\tNave cadastrada com sucesso");
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void verificaNumIdent(String numIdent) throws Exception {
        if(!(numIdent.length() == 3)  || !IsNumeric.numInt(numIdent)){
            throw new Exception("\n\t\tERRO: Número de identificação inválido, Obrigatório ter apenas 3 dígitos e só pode conter números");
        }

        for(Object veiculo : veiculos) {
            if(((Veiculo) veiculo).getIdentificacao().equals(numIdent)) {
                throw new Exception("\n\t\tERRO: Veículo com Número de Identificação Já Cadastrado.");
            }
        }
    }

    private void verificaDescricacao(String descricao) throws Exception {
        if(descricao.length() < 5 || descricao.length() > 30) {
            throw new Exception("\n\t\tERRO: A descrição deve ter no mínimo 6 e no máximo 30 caracteres");
        }
    }
    private int verificaQtdPassageiros(String strNum) throws Exception {
        if (!IsNumeric.numInt(strNum)) {
            throw new Exception("\n\t\tERRO: Valor inválido, tente novamente");
        }
        int intNum = Integer.parseInt(strNum);
        if(intNum < 2 || intNum > 7) {
            throw new Exception("\n\t\tERRO: Só aceitamos carros com capacidade minima de 2 e maxima de 7 passageiros");
        }
        return intNum;
    }
    
    private void verificaPartida(String partida) throws Exception {
        if(!(partida.length() == 1) && (!partida.equals("S") || !partida.equals("N"))) {
            throw new Exception("\n\t\tERRO: Valor inválido, digite apenas S ou N");
        }
    }
    
    private double verificaValorDiarias(String strNum) throws Exception {
        if (!IsNumeric.numFloat(strNum)) {
            throw new Exception("\n\t\tERRO: Valor inválido, tente novamente");
        }
        double dbNum  = Double.parseDouble(strNum);
        if(dbNum < 10 || valorDiaria > 10000){
            throw new Exception("\n\t\tERRO: Valor inválido, valor deve estar entre 0 e 10000.");
        }
        return dbNum;
    }

    private void verificaMotor(String motor) throws Exception{
        if(!(motor.length() == 1) && (!motor.equals("A") || !motor.equals("E"))) {
            throw new Exception("\n\t\tERRO: Valor inválido, digite apenas A ou E");
        }
    }
}
