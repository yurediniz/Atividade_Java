package br.uniesp.poo.ted04;

public class Moto extends Veiculo{
    private static final long serialVersionUID = 1L;

    public Moto(String identificacao, String descricao, String partida, double valorDiaria, String disponivel) {
        this.tipo = "Moto";
        this.identificacao = identificacao;
        this.descricao = descricao;
        this.partida = partida;
        this.valorDiaria = valorDiaria;
        this.disponivel = "S";
    }

    @Override
    public String toString() {
        return "Tipo: " + tipo + " - NúmeroID: " + identificacao + " - Modelo: " + descricao + " - Partida Elétrica: " + partida + " - Valor da diária: " + valorDiaria + " - Disponível: " + disponivel;
    }
}
