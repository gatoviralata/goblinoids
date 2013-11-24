package logica;

/*
 *	Projeto Goblinóides
 *	Faculdade Tecnológica de Carapicuíba
 *	Equipe Sem Nome
 *	Tecnologia em Jogos Digitais, 3º ciclo Manhã
 *	Engenharia de Software
 */

/**
 * @author Thiago Valença
 *  Classe que integra a lógica do jogo Goblinóides
 */

import logica.Caixa;
import logica.Goblinoide;
import logica.Jogador;
import logica.Tabuleiro;

public class Jogo {

	private Caixa caixa;
	private Jogador jogador1, 
					jogador2,
					jogadorDaVez;
	private Tabuleiro tabuleiro;

	public Jogo (Jogador j1, Jogador j2) {
		tabuleiro = new Tabuleiro();
		caixa = new Caixa();
		for (byte i = 0; i < 16; i++) {
			caixa.adicionaGoblinoide(new Goblinoide(i), i);
		}
		jogador1 = j1;
		jogador2 = j2;
		jogadorDaVez = jogador1;
	}
	
	public Caixa getCaixa () {
		return caixa;
	}
	
	public Jogador getJogador1 () {
		return jogador1;
	}

	public Jogador getJogador2 () {
		return jogador2;
	}

	public Jogador getJogadorDaVez () {
		return jogadorDaVez;
	}

	public Tabuleiro getTabuleiro () {
		return tabuleiro;
	}

	public void limpaJogo() {
		tabuleiro = new Tabuleiro();
		caixa = new Caixa();
		for (byte i = 0; i < 16; i++) {
			caixa.adicionaGoblinoide(new Goblinoide(i),i);
		}
		
		this.jogador1.removeGoblSelecionado();
		this.jogador2.removeGoblSelecionado();
		jogadorDaVez = jogador1;
	}

	public void mudaTurno () {
		if (jogadorDaVez == jogador1) {
			jogadorDaVez = jogador2;
		}
		else {
			jogadorDaVez = jogador1;
		}
	}
}