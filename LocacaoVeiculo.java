package br.uniesp.poo.ted04;

import java.io.Serializable;

public class LocacaoVeiculo implements Serializable{
    private static final long serialVersionUID = 1L;
    private Cliente cliente;
    private int diarias;
    private String seguro;
    private Double desconto;

    public LocacaoVeiculo(Cliente cliente, int diarias, String seguro, Double desconto) {
        this.cliente = cliente;
        this.diarias = diarias;
        this.seguro = seguro;
        this.desconto = desconto;
    }

    public Cliente getCliente() {
        return this.cliente;
    }

    public int getDiarias() {
        return this.diarias;
    }

    public String getSeguro() {
        return this.seguro;
    }

    public Double getDesconto() {
        return this.desconto;
    }

    @Override
    public String toString() {
        return "{" +
            " cliente='" + getCliente() + "'" +
            ", diarias='" + getDiarias() + "'" +
            ", seguro='" + getSeguro() + "'" +
            ", desconto='" + getDesconto() + "'" +
            "}";
    }    

}
