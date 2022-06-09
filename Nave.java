package br.uniesp.poo.ted04;

public class Nave extends Veiculo{
    private static final long serialVersionUID = 1L;

    public Nave(String identificacao, String descricao, String motor, double valorDiaria) {
        this.tipo = "Nave";
        this.identificacao = identificacao;
        this.descricao = descricao;
        this.motor = motor;
        this.valorDiaria = valorDiaria;
        this.disponivel = "S";
    }

    @Override
    public String toString() {
        return "\n - Tipo: " + tipo + "\n - NumeroID: " + identificacao + "\n - Modelo/Descrição: " + descricao + "\n - Tipo do motor: " + motor + "\n - Valor da diária: R$" + valorDiaria + "\n - Disponível: " + disponivel;
    }
}
