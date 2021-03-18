package main;

import java.util.Random;
import java.util.Scanner;

import dao.JogadorDAO;
import dao.PartidaDAO;
import model.Jogador;
import model.Partida;

/**
 * @author douglas
 *
 */
public class Application {
	
	private static Application app;
	
	private static Random random;
	
	private static Partida partida;
	
	/**
	 * Construtor padrao
	 */
	public Application() {
		Application.random = new Random();
		Application.partida = new Partida();
	}
	
	/**
	 * Gerar instancia Application
	 * 
	 * @return
	 */
	public static Application getInstance() {
		if (app == null) {
			app = new Application();
		}
		return app;
	}
		
	/**
	 * Metodo main aplicacao JOKENPO
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		Application.getInstance();
		
		Scanner sc = new Scanner(System.in);
		
		Jogador jogador = new Jogador();
		partida.setJogador(jogador);
		
		// Inicio do game
		System.out.print("Insira seu nome para iniciar: ");
		jogador.setNome(sc.nextLine());
		
		int op = 0;
		
		do {
			
			int pontosPlayer = 0;
			int pontosComputador = 0;
			
			for (int i = 0; i < 10; i++) {
				
				int escolha = 0;
				
				String jogadaPlayer = null;
				String jogadaComputador = null;
			
				do {
					System.out.println("\nEscolha a sua jogada: ");
					System.out.println("1- Pedra");
					System.out.println("2- Papel");
					System.out.println("3- Tesoura");
					System.out.println("0- Desistir");
					
					escolha = sc.nextInt();
					
					if (escolha == 0) {
						System.out.println("\nSaindo...");
						sc.close();
						return;
					}
					
					jogadaPlayer = preencheJogada(escolha);
				
				} while (escolha > 3);
				
				System.out.println("\nAgora é a vez do computador...");
				
				int nextInt = random.nextInt(3) + 1;
				jogadaComputador = preencheJogada(nextInt);
				
				System.out.println("\nA jogada do computador foi " + jogadaComputador);
				
				switch (verificaGanhadorRodada(jogadaPlayer, jogadaComputador)) {
					case "player":
						pontosPlayer +=1;
						break;
					
					case "computador":
						pontosComputador +=1;
						break;
		
					default:
						break;
				}
				
			}
			
			partida.setPontuacaoJogador(pontosPlayer);
			partida.setPontuacaoComputador(pontosComputador);
			partida.setVencedor(verificaGanhadorPartida(pontosPlayer, pontosComputador));
			
			// Salva dados Jogador
			String idJogador = JogadorDAO.salva(jogador);
			jogador.setId(Long.valueOf(idJogador));
			
			// Salva dados Partida
			PartidaDAO.salva(partida);
			
			// Imprime placar e resultado da partida
			imprimeResultado(partida);
			
			System.out.println("\nDesejar jogar novamente? 1- SIM / 2- NÃO");
			op = sc.nextInt();
			
			System.out.println("\nSaindo...");
			
		} while (op == 1);
		
		sc.close();
	}

	/**
	 * Imprime a resolução da partida
	 * 
	 * @param partida
	 */
	private static void imprimeResultado(Partida partida) {

		String mensagem;
		
		if (partida.getVencedor() == "Jogador") {
			mensagem = "Parabéns pela vitória!!!";
		} else if (partida.getVencedor() == "Computador") {
			mensagem = "Você perdeu!";
		} else {
			mensagem = "A partida terminou empatada.";
		}
		
		System.out.println("=============================================");
		System.out.println(partida.getJogador().getNome() + " seu placar foi " + partida.getPontuacaoJogador());
		System.out.println("O placar da Máquina foi " + partida.getPontuacaoComputador());
		System.out.println("\n" + mensagem);
		System.out.println("=============================================");
	}

	/**
	 * Verifica o ganhador da rodada
	 * 
	 * @param jogadaPlayer
	 * @param jogadaComputador
	 */
	private static String verificaGanhadorRodada(final String jogadaPlayer, final String jogadaComputador) {
		if (jogadaPlayer.equals(jogadaComputador)) {
			System.out.println("\nEmpate. Ninguém pontua.");
			return "empate";
		} 
		else if ( jogadaPlayer.equals("Papel") && jogadaComputador.equals("Pedra") || 
				jogadaPlayer.equals("Pedra") && jogadaComputador.equals("Tesoura") || 
				jogadaPlayer.equals("Tesoura") && jogadaComputador.equals("Papel") ) {
			System.out.println("\nVocê ganhou 1 ponto.");
			return "player";
		} else {
			System.out.println("\nComputador ganhou 1 ponto.");
			return "computador";
		}
	}
	
	/**
	 * Verifica o ganhador da partida
	 * 
	 * @param pontosPlayer
	 * @param pontosComputador
	 * @return
	 */
	private static String verificaGanhadorPartida(final Integer pontosPlayer, final Integer pontosComputador) {
		if (pontosPlayer > pontosComputador) {
			return "Jogador";
		} else if (pontosPlayer < pontosComputador) {
			return "Computador";
		} else {
			return "Empate";
		}
	}

	/**
	 * Preenche a escolha da jogada 
	 * 
	 * @param escolha
	 * @return
	 */
	private static String preencheJogada(final Integer escolha) {
		
		String jogada = null;
		
		switch (escolha) {
		
			case 1:
				jogada = "Pedra";
				break;
			case 2:
				jogada = "Papel";
				break;
			case 3:
				jogada = "Tesoura";
				break;
			default:
				System.out.println("\nDigite uma das 3 escolhas possíveis, ou 0 para desistir do jogo.");
				break;
				
		}
		
		return jogada;
	}

}
