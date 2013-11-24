package logica;

/*
 *	Projeto Goblin�ides
 *	Faculdade Tecnol�gica de Carapicu�ba
 *	Equipe Sem Nome
 *	Tecnologia em Jogos Digitais, 3� ciclo Manh�
 *	Engenharia de Software
 */

/**
 * @author Thiago Valen�a
 * Classe que define jogadores e turnos no jogo Goblin�ides
 */

import logica.Goblinoide;
import logica.Tabuleiro;

public class Jogador {
	protected Goblinoide goblSelecionado;
  	protected String nome;
	protected int placar;

	/**
	 * M�todo construtor da classe Jogador
	 * @param nome o nome do jogador	 */
	public Jogador(String nome) {
		this.nome = nome;
		placar = 0;
		goblSelecionado = null;
	}
	
	/**
	 * M�todo que adiciona um ponto no placar do jogador
	 */
	public void adicionaPlacar () {
		placar++;
	}

	/**
	 * M�todo que retorna a inst�ncia da classe Goblin�ide selecionado para o advers�rio
	 * @return inst�ncia da classe Goblin�ide selecionado para o advers�rio	 */
	public Goblinoide getGoblSelecionado () {
		return goblSelecionado;
	}
	
	/**
	 * M�todo que retorna o nome do jogador
	 * @return String com o nome do jogador	 */
	public String getNome () {
		return nome;
	}

	/**
	 * M�todo que retorna o placar do jogador
	 * @return inteiro com o placar do jogador	 */
	public int getPlacar () {
		return placar;
	}
	
	/**
	 * Simula uma jogada do jogador enviando o Goblin�ide ao tabuleiro
	 * @param oTabuleiro inst�ncia do tabuleiro que receber� a jogada
	 * @param linha inteiro de 0 a 3 que indica a linha do tabuleiro
	 * @param coluna inteiro de 0 a 3 que indica a coluno do tabuleiro	 */
	public void jogar(Tabuleiro oTabuleiro, byte linha, byte coluna) {
		oTabuleiro.recebeGoblinoide(linha,coluna);
	} 
	
	/**
	 * M�todo que nulifica a inst�ncia do goblin�ide selecionado para o advers�rio */
	public void removeGoblSelecionado () {
		goblSelecionado = null;
	}

	/**
	 * M�todo que seta o goblin�ide selecionado para o advers�rio
	 * @param oGobl o inst�ncia do goblin�ide escolhido para o advers�rio */
	public void setGoblSelecionado (Goblinoide oGobl) {
		goblSelecionado = oGobl;
	}

	/**
	 * M�todo que modifica o nome do jogador
	 * @param _nome novo nome para o jogador */
	public void setNome (String _nome) {
		this.nome = _nome;
	}

	/**
	 * M�todo que envia o goblin�ide sugerido para o advers�rio � inst�ncia do tabuleiro
	 * @param oTabuleiro a inst�ncia do tabuleiro*/
	public void sugereGobl (Tabuleiro oTabuleiro) {
		oTabuleiro.setGoblSugerido(getGoblSelecionado());
		removeGoblSelecionado();
	}
}