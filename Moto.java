package br.uniesp.poo.ted04;

public class Moto extends Veiculo{
    private static final long serialVersionUID = 1L;

    public Moto(String identificacao, String descricao, String partida, double valorDiaria) {
        this.tipo = "Moto";
        this.identificacao = identificacao;
        this.descricao = descricao;
        this.partida = partida;
        this.valorDiaria = valorDiaria;
        this.disponivel = "S";
    }
    

    @Override
    public String toString() {
        return "\n - Tipo: " + tipo + "\n - NúmeroID: " + identificacao + "\n - Modelo/Descrição: " + descricao + "\n - Partida Elétrica: " + partida + "\n - Valor da diária: R$" + valorDiaria + "\n - Disponível: " + disponivel;
    }
}
