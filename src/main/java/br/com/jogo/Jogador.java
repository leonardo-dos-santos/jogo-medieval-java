package br.com.jogo;
import java.io.Serializable;

public class Jogador implements Serializable {
    private static final long serialVersionUID = 1L;

    private final String nome;
    private double saude;
    private Arma armaAtual;
    private Capacete capacete;
    private Camisa camisa;

    public Jogador(String nome) {
        this.nome = nome;
        this.saude = 100.0;
        this.armaAtual = new Arma("Espada Enferrujada", 3);
        // Inicializando para evitar NullPointerException
        this.capacete = new Capacete("Nenhum", 0, 0);
        this.camisa = new Camisa("Farrapos", 100, 1);
    }

    public String getNome() { return nome; }

    @Override
    public String toString() {
        return "\nJogador Atual: " + nome + "\nSaúde: " + saude + "\nArma: " + armaAtual.getNome();
    }
}