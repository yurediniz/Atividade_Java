package br.uniesp.poo.ted04;

import java.io.Serializable;

public class LocacaoVeiculo implements Serializable{
    private static final long serialVersionUID = 1L;
    private Cliente cliente;
    private Veiculo veiculo;
    private int diarias;
    private String seguro;
    private double valorSeguro;
    private double desconto;
    private double valorDesconto;
    private double valorLocacao;

    public LocacaoVeiculo(Cliente cliente, Veiculo veiculo, int diarias, String seguro, double valorSeguro, double desconto, double valorDesconto, double valorLocacao) {
        this.cliente = cliente;
        this.veiculo = veiculo;
        this.diarias = diarias;
        this.seguro = seguro;
        this.valorSeguro = valorSeguro;
        this.desconto = desconto;
        this.valorDesconto = valorDesconto;
        this.valorLocacao = valorLocacao;
    }

    public Cliente getCliente() {
        return this.cliente;
    }

    public Veiculo getVeiculo() {
        return this.veiculo;
    }

    public int getDiarias() {
        return this.diarias;
    }

    public String getSeguro() {
        return this.seguro;
    }

    public double getValorSeguro() {
        return this.valorSeguro;
    }

    public double getDesconto() {
        return this.desconto;
    }
    
    public double getValorDesconto() {
        return this.valorDesconto;
    }

    public double getValorLocacao() {
        return this.valorLocacao;
    }    
    
    @Override
    public String toString() {
        return "\n--- Dados do Cliente ---" + getCliente() +
            "\n --- Dados do Veiculo ---" + getVeiculo() +
            "\n --- Dados da Locação ---\n - Diárias: " + getDiarias() + " dias" + "\n - Seguro: " + getSeguro() + "\n - Valor do Seguro: R$" + getValorSeguro() + 
            "\n - Desconto: " + getDesconto() + "%" + "\n - Valor do Desconto: R$" + getValorDesconto() +
            "\n - Valor da Locação: R$" + getValorLocacao();
    }

}
