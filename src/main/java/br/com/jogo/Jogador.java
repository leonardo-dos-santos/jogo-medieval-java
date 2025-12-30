package br.com.jogo;
import java.io.Serializable;

public class Jogador implements Serializable {
    private static final long serialVersionUID = 1L;

    private final String nome;
    private double saude;
    private Arma armaAtual;
    private Capacete capacete;
    private Camisa camisa;
    private Calca calca;
    private Sapato sapato;

    public Jogador(String nome) {
        this.nome = nome;
        this.saude = 150.0; // Saúde aumentada de 100 para 150

        // Arma muito mais imponente e poderosa
        this.armaAtual = new Arma("Excalibur do Alvorecer", 25);

        // Equipamentos iniciais melhorados (Stats de Defesa e Durabilidade)
        this.capacete = new Capacete("Elmo de Aço Galvânico", 100, 15);
        this.camisa = new Camisa("Cota de Malha Real", 100, 20);
        this.calca = new Calca("Grevas de Couro Batido", 100, 10);
        this.sapato = new Sapato("Botas de Expedição", 100, 8);
    }

    public void receberDano(double ataqueInimigo) {
        double dano = ataqueInimigo - (getNivelDefesaTotal() / 5.0);
        if (dano < 0) dano = 0;
        this.saude -= dano;

        if (this.saude <= 0) {
            System.out.println("Você sucumbiu aos ferimentos... Fim de jogo.");
            System.exit(0);
        } else {
            System.out.println("Saúde Atual: " + String.format("%.2f", this.saude));
        }
    }

    public int getNivelDefesaTotal() {
        return capacete.getNivelDefesa() +
                camisa.getNivelDefesa() +
                calca.getNivelDefesa() +
                sapato.getNivelDefesa();
    }

    // Getters e Setters traduzidos
    public String getNome() { return nome; }
    public double getSaude() { return saude; }

    @Override
    public String toString() {
        return "\n--- Status do Jogador ---" +
                "\nNome: " + nome +
                "\nSaúde: " + String.format("%.2f", saude) +
                "\nArma: " + armaAtual.getNome() + " (Dano: " + armaAtual.getDano() + ")" +
                "\nDefesa Total: " + getNivelDefesaTotal() +
                "\nEquipamentos:" +
                "\n  Capacete: " + capacete +
                "  Camisa: " + camisa +
                "  Calça: " + calca +
                "  Sapato: " + sapato;
    }
}