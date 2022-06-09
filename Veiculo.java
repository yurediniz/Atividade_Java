package br.uniesp.poo.ted04;

import java.io.Serializable;

public class Veiculo implements Serializable {
    protected static final long serialVersionUID = 1L;
    protected String tipo;
    protected String identificacao;
    protected String descricao;
    protected double valorDiaria;
    protected int qtdPassageiros;
    protected String partida;
    protected String motor;
    protected String disponivel;

    public String getTipo() {
        return this.tipo;
    }

    public String getIdentificacao() {
        return this.identificacao;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public double getValorDiaria() {
        return this.valorDiaria;
    }

    public int getQtdPassageiros() {
        return this.qtdPassageiros;
    }

    public String getPartida() {
        return this.partida;
    }

    public String getMotor() {
        return this.motor;
    }


    public String getDisponivel() {
        return this.disponivel;
    }

    public void setDisponivel(String disponivel) {
        this.disponivel = disponivel;
    }    
}