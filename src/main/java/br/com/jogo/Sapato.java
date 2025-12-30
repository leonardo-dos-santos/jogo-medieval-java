package br.com.jogo;
import java.io.Serializable;

public class Sapato extends Armadura implements Serializable {
    private static final long serialVersionUID = 1L;

    public Sapato(String nome, int durabilidade, int nivelDefesa) {
        super(nome, durabilidade, nivelDefesa);
    }
}