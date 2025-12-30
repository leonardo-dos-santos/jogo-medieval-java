package br.com.jogo;
import java.io.Serializable;

public class Arma implements Serializable {
    private static final long serialVersionUID = 1L;

    private final String nome;
    private final int dano;

    public Arma(String nome, int dano) {
        this.nome = nome;
        this.dano = dano;
    }

    public String getNome() { return nome; }
    public int getDano() { return dano; }
}