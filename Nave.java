package br.uniesp.poo.ted04;

public class Nave extends Veiculo{
    private static final long serialVersionUID = 1L;

    public Nave(String identificacao, String descricao, String motor, double valorDiaria, String disponivel) {
        this.tipo = "Nave";
        this.identificacao = identificacao;
        this.descricao = descricao;
        this.motor = motor;
        this.valorDiaria = valorDiaria;
        this.disponivel = "S";
    }

    @Override
    public String toString() {
        return "Tipo: " + tipo + " - NumeroID: " + identificacao + " - Modelo: " + descricao + " - Tipo do motor: " + motor + " - Valor da diária: " + valorDiaria + " - Disponível: " + disponivel;
    }
}
