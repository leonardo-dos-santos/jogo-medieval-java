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
        this.saude = 100.0;
        this.armaAtual = new Arma("Espada Curta Enferrujada", 3);
        // Inicialização padrão para evitar NullPointerException ao calcular defesa
        this.capacete = new Capacete("Nenhum", 0, 0);
        this.camisa = new Camisa("Trapos de Pano", 100, 1);
        this.calca = new Calca("Trapos de Pano", 100, 1);
        this.sapato = new Sapato("Nenhum", 0, 0);
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