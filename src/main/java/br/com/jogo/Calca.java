package br.com.jogo;
import java.io.Serializable;

public class Calca extends Armadura implements Serializable {
    private static final long serialVersionUID = 1L;

    public Calca(String nome, int durabilidade, int nivelDefesa) {
        super(nome, durabilidade, nivelDefesa);
    }
}