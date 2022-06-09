package br.uniesp.poo.ted04;

public class Carro extends Veiculo{
    private static final long serialVersionUID = 1L;

    public Carro(String identificacao,String descricao, int qtdPassageiros, double valorDiaria) {
        this.tipo = "Carro";
        this.identificacao = identificacao;
        this.descricao = descricao; 
        this.qtdPassageiros = qtdPassageiros;
        this.valorDiaria = valorDiaria;
        this.disponivel = "S";
    }

    @Override
    public String toString() {
        return "\n - Tipo: " + tipo + "\n - NúmeroID: " + identificacao + "\n - Modelo/Descrição: " + descricao + "\n - Quantidade de ocupantes: " + qtdPassageiros + "\n - Valor da diária: R$" + valorDiaria + "\n - Disponível: " + disponivel;
    }

}
