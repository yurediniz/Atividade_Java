package br.uniesp.poo.ted04;

public class Carro extends Veiculo{
    private static final long serialVersionUID = 1L;

    public Carro(String identificacao,String descricao, int qtdPassageiros, double valorDiaria, String disponivel) {
        this.tipo = "Carro";
        this.identificacao = identificacao;
        this.descricao = descricao; 
        this.qtdPassageiros = qtdPassageiros;
        this.valorDiaria = valorDiaria;
        this.disponivel = "S";
    }

    @Override
    public String toString() {
        return "Tipo: " + tipo + " - NúmeroID: " + identificacao + " - Modelo: " + descricao + " - Quantidade de ocupantes: " + qtdPassageiros + " - Valor da diária: " + valorDiaria + " - Disponível: " + disponivel;
    }

}
