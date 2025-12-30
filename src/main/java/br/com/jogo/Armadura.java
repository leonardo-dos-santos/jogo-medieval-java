package br.com.jogo;
import java.io.Serializable;

public class Armadura implements Serializable {
    private static final long serialVersionUID = 1L;

    private final String nome;
    private int durabilidade;
    private int nivelDefesa;

    public Armadura(String nome, int durabilidade, int nivelDefesa) {
        this.nome = nome;
        this.durabilidade = durabilidade;
        this.nivelDefesa = nivelDefesa;
    }

    public void reduzirDurabilidade(int reducao) {
        durabilidade -= reducao;
        if (durabilidade <= 0) {
            System.out.println("Sua " + nome + " foi destruída!");
            nivelDefesa = 0;
        }
    }

    public int getNivelDefesa() {
        return (int) (nivelDefesa * (durabilidade / 100.0));
    }

    @Override
    public String toString() {
        return nome + ", Defesa: " + nivelDefesa + "\n";
    }
}