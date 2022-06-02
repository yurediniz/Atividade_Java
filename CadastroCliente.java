package br.uniesp.poo.ted04;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class CadastroCliente implements Serializable{
    private static final long serialVersionUID = 1L;
    private String cpf;
    private String nome;
    private String idade;
    private String telefone;

    ArrayList<Object> clientes = ManipulaArquivo.lerArquivo("clientes.dat");

    Scanner leitor = new Scanner(System.in);

    public void cadastraCliente() throws Exception {
        try {
            System.out.println("\n\n\t\t--- Cadastrando Cliente ---");
            System.out.println("\t\tInforme os dados do cliente");
            
            System.out.print("\t\tCPF(Somente Números): ");
            cpf = leitor.nextLine().trim();
            valideCpf(cpf);

            System.out.print("\t\tNome Completo(Somente Letras): ");
            nome = leitor.nextLine().toUpperCase().trim();
            valideNome(nome);

            System.out.print("\t\tIdade(Somente Números): ");
            idade = leitor.nextLine().trim();
            validaIdade(idade);

            System.out.print("\t\tTelefone com DDD(Somente Números): ");
            telefone = leitor.nextLine().trim();
            valideTelefone(telefone);

            Cliente c = new Cliente(cpf, nome, idade, telefone);
            clientes.add(c);
            ManipulaArquivo.gravarArquivo(clientes, "clientes.dat");
            System.out.println("\t\tCliente Cadastrado Com Sucesso");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    private void valideCpf(String cpf) throws Exception {

        if(!(cpf.length() == 11) || !(isNumericInt(cpf))) {
            throw new Exception("\n\t\tERRO: Número de CPF Inválido");
        }

        for(Object cliente : clientes) {
            if(((Cliente) cliente).getCpf().equals(cpf)) {
                throw new Exception("\n\t\tERRO: Cliente Com CPF Já Cadastrado.");
            }
        }
    }
    private void valideNome(String nome) throws Exception {
        if(nome.length() < 5) {
            throw new Exception("\t\tERRO: O nome deve ter mais que 5 caracteres");
        } else if(nome.length() > 25) {
            throw new Exception("\t\tERRO: O nome deve ter menos que 25 caracteres, utilize abreviações");

        } else if(isNumericChar(nome)) {
            throw new Exception("\t\tERRO: O nome não pode conter números");

        } else if(nome.indexOf(" ") == - 1) {
            throw new Exception("\t\tERRO: Informe o nome completo com nome e sobrenome");
            
        } else if(nome.substring(0, nome.indexOf(" ")).length() <= 2 || nome.substring(nome.lastIndexOf(" ") + 1).length() <= 2) {
            throw new Exception("\t\tERRO: nome e sobrenomes devem ter pelo menos 2 caracteres");
        }
    }
    
    private void validaIdade(String idade) throws Exception {
        if(idade.length() > 2) {
            throw new Exception("\t\tERRO: Idade máxima permitida para clientes é de 99 anos");
        } else if (!(isNumericInt(idade))) {
            throw new Exception("\t\tERRO: Digite apenas números");
        }
    }

    private void valideTelefone(String telefone) throws Exception {
        if(!(telefone.length() == 11 || !(isNumericInt(idade)))) {
            throw new Exception("\t\tERRO: Número de telefone inválido");
        }
    }

    private boolean isNumericInt(String strNum) throws Exception {
        Pattern patternInt = Pattern.compile("-?\\d+?");
        if (strNum == null) {
            return false;
        }
        return patternInt.matcher(strNum).matches();
    }
    private boolean isNumericChar(String nome) throws Exception {
        for (int i = 0; i < nome.length(); i++) {
            if (Character.isDigit(nome.charAt(i))) {
                return true;
            }
        }
        return false;
    }
}
