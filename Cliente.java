package br.uniesp.poo.ted04;

import java.io.Serializable;

public class Cliente implements Serializable{
    private static final long serialVersionUID = 1L;
    private String cpf;
    private String nome;
    private String idade;
    private String telefone;

    public Cliente(String cpf, String nome, String idade, String telefone) throws Exception{
        this.cpf = cpf;
        this.nome = nome;
        this.idade = idade;
        this.telefone = telefone;
    }

    public String getCpf() {
        return this.cpf;
    }

    public String getNome() {
        return this.nome;
    }

    public String getIdade() {
        return this.idade;
    }

    public String getTelefone() {
        return this.telefone;
    }
   
    @Override
    public String toString() {
        return "\n - CPF: " + cpf + "\n - Nome: " + nome + "\n - Idade: " + idade + "\n - Telefone: " + telefone;
    }
}
