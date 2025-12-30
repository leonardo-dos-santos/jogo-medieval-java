package br.com.jogo;

import java.util.Scanner;
import java.io.*;

public class JogoMedieval {

    private Jogador jogador;

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        JogoMedieval jogo = new JogoMedieval();

        jogo.jogador = jogo.iniciar(console);

        jogo.adicionarAtraso(500);
        System.out.println("\nVamos dar uma olhada em você para garantir que está pronto para a jornada.");
        System.out.println(jogo.jogador);

        jogo.adicionarAtraso(1000);
        System.out.println("\nÓtimo começo! Vamos salvar seu progresso para não perdê-lo.");
        jogo.salvar();

        jogo.adicionarAtraso(2000);
        System.out.println("Jogo salvo com sucesso...");
        System.out.println("Agora, vamos testar o carregamento para garantir que tudo está funcionando...");

        jogo.adicionarAtraso(1000);
        System.out.println("Limpando dados da memória (Simulando saída)...");
        String nomeParaCarregar = jogo.jogador.getNome();
        jogo.jogador = null;

        jogo.adicionarAtraso(1500);
        jogo.jogador = jogo.carregar(nomeParaCarregar, console);
        System.out.println("Carregando personagem...");

        jogo.adicionarAtraso(2000);
        System.out.println("Aqui estão os dados carregados do arquivo:");
        jogo.adicionarAtraso(500);
        System.out.println(jogo.jogador);
    }

    private Jogador iniciar(Scanner console) {
        Jogador player;
        Arte.telaInicial();

        System.out.println("Bem-vindo à sua mais nova aventura!");
        System.out.println("Diga-me viajante, você já esteve aqui antes?");
        System.out.print("   Digite 's' para carregar, 'n' para novo jogo: ");

        String resposta = console.next().toLowerCase();

        while (true) {
            if (resposta.equals("s")) {
                System.out.print("\nQual o nome do seu personagem anterior? ");
                String nome = console.next();
                player = carregar(nome, console);
                break;
            } else if (resposta.equals("n")) {
                System.out.print("\nQual será o nome do seu novo herói? ");
                String nome = console.next();
                player = new Jogador(nome);
                break;
            } else {
                System.out.print("Desculpe, digite 's' ou 'n': ");
                resposta = console.next().toLowerCase();
            }
        }
        return player;
    }

    private void salvar() {
        String nomeArquivo = this.jogador.getNome() + ".svr";
        try (ObjectOutputStream saida = new ObjectOutputStream(new FileOutputStream(nomeArquivo))) {
            saida.writeObject(this.jogador);
        } catch (IOException e) {
            System.out.println("Erro ao salvar o jogo: " + e.getMessage());
        }
    }

    private Jogador carregar(String nomeJogador, Scanner console) {
        Jogador jogadorCarregado;
        try (ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(nomeJogador + ".svr"))) {
            jogadorCarregado = (Jogador) entrada.readObject();
        } catch (IOException | ClassNotFoundException e) {
            adicionarAtraso(1000);
            System.out.println("\nProblema ao carregar. Criando um novo personagem padrão...");
            jogadorCarregado = new Jogador(nomeJogador);
        }
        return jogadorCarregado;
    }

    private void adicionarAtraso(int tempo) {
        try {
            Thread.sleep(tempo);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}