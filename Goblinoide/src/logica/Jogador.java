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
 * Classe que define jogadores e turnos no jogo Goblinóides
 */

import logica.Goblinoide;
import logica.Tabuleiro;

public class Jogador {
	protected Goblinoide goblSelecionado;
  	protected String nome;
	protected int placar;

	/**
	 * Método construtor da classe Jogador
	 * @param nome o nome do jogador	 */
	public Jogador(String nome) {
		this.nome = nome;
		placar = 0;
		goblSelecionado = null;
	}
	
	/**
	 * Método que adiciona um ponto no placar do jogador
	 */
	public void adicionaPlacar () {
		placar++;
	}

	/**
	 * Método que retorna a instância da classe Goblinóide selecionado para o adversário
	 * @return instância da classe Goblinóide selecionado para o adversário	 */
	public Goblinoide getGoblSelecionado () {
		return goblSelecionado;
	}
	
	/**
	 * Método que retorna o nome do jogador
	 * @return String com o nome do jogador	 */
	public String getNome () {
		return nome;
	}

	/**
	 * Método que retorna o placar do jogador
	 * @return inteiro com o placar do jogador	 */
	public int getPlacar () {
		return placar;
	}
	
	/**
	 * Simula uma jogada do jogador enviando o Goblinóide ao tabuleiro
	 * @param oTabuleiro instância do tabuleiro que receberá a jogada
	 * @param linha inteiro de 0 a 3 que indica a linha do tabuleiro
	 * @param coluna inteiro de 0 a 3 que indica a coluno do tabuleiro	 */
	public void jogar(Tabuleiro oTabuleiro, byte linha, byte coluna) {
		oTabuleiro.recebeGoblinoide(linha,coluna);
	} 
	
	/**
	 * Método que nulifica a instância do goblinóide selecionado para o adversário */
	public void removeGoblSelecionado () {
		goblSelecionado = null;
	}

	/**
	 * Método que seta o goblinóide selecionado para o adversário
	 * @param oGobl o instância do goblinóide escolhido para o adversário */
	public void setGoblSelecionado (Goblinoide oGobl) {
		goblSelecionado = oGobl;
	}

	/**
	 * Método que modifica o nome do jogador
	 * @param _nome novo nome para o jogador */
	public void setNome (String _nome) {
		this.nome = _nome;
	}

	/**
	 * Método que envia o goblinóide sugerido para o adversário à instância do tabuleiro
	 * @param oTabuleiro a instância do tabuleiro*/
	public void sugereGobl (Tabuleiro oTabuleiro) {
		oTabuleiro.setGoblSugerido(getGoblSelecionado());
		removeGoblSelecionado();
	}
}