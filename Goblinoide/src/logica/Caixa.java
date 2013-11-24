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
 * Classe que define uma caixa de pe�as do jogo Goblin�ides
 */

public class Caixa {
	private Goblinoide[] caixa;
	

	/**
	 * M�todo construtor da classe caixa
	 */
	public Caixa() {
		// A caixa � um vetor com dezesseis inst�ncias das est�tuas dos Goblin�ides
		caixa = new Goblinoide[16];
		resetCaixa();
	}
	/**
	 * M�todo para adicionar uma inst�ncia de Goblin�ide na caixa de est�tuas
	 * @param oGobl o Goblinoide a ser adicionado
	 * @param id a posi��o da caixa em que o goblinoide vai ficar (varia de 0 a 15)
	 */	
	public void adicionaGoblinoide(Goblinoide oGobl, byte id) {
		caixa[id] = oGobl;
	}
	
	/**
	 * Retorna se a caixa de est�tuas est� vazia
	 * @return true se estiver vazia, false se tiver alguma est�tuta
	 */
	public boolean estaVazia() {
		for (byte i = 0; i < caixa.length; i++) {
			if (caixa[i] != null) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * Retorna o Goblin�ide que estiver na caixa de acordo com o n�mero de identifica��o
	 * @param id a posi��o da caixa (varia de 0 a 15)
	 * @return se a posi��o estiver vazia, null, se n�o, o Goblin�ide na posi��o 
	 */	
	public Goblinoide getGoblinoide(byte id) {
		return caixa[id];
	}
	
	/**
	 * Remove o Goblin�ide de acordo com a posi��o na caixa
	 * @param id o n�mero da posi��o na caixa de est�tuas
	 */
	public void removeGoblinoide(byte id) {
		caixa[id] = null;
	}
	
	/**
	 * Reseta a caixa, atribuindo a todas as suas posi��es o valor null 
	 */
	public void resetCaixa() {
		for (byte i = 0; i < caixa.length; i++) {
			caixa[i] = null;
		}
	}
}