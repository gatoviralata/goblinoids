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
 * Classe que define uma caixa de peças do jogo Goblinóides
 */

public class Caixa {
	private Goblinoide[] caixa;
	

	/**
	 * Método construtor da classe caixa
	 */
	public Caixa() {
		// A caixa é um vetor com dezesseis instâncias das estátuas dos Goblinóides
		caixa = new Goblinoide[16];
		resetCaixa();
	}
	/**
	 * Método para adicionar uma instância de Goblinóide na caixa de estátuas
	 * @param oGobl o Goblinoide a ser adicionado
	 * @param id a posição da caixa em que o goblinoide vai ficar (varia de 0 a 15)
	 */	
	public void adicionaGoblinoide(Goblinoide oGobl, byte id) {
		caixa[id] = oGobl;
	}
	
	/**
	 * Retorna se a caixa de estátuas está vazia
	 * @return true se estiver vazia, false se tiver alguma estátuta
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
	 * Retorna o Goblinóide que estiver na caixa de acordo com o número de identificação
	 * @param id a posição da caixa (varia de 0 a 15)
	 * @return se a posição estiver vazia, null, se não, o Goblinóide na posição 
	 */	
	public Goblinoide getGoblinoide(byte id) {
		return caixa[id];
	}
	
	/**
	 * Remove o Goblinóide de acordo com a posição na caixa
	 * @param id o número da posição na caixa de estátuas
	 */
	public void removeGoblinoide(byte id) {
		caixa[id] = null;
	}
	
	/**
	 * Reseta a caixa, atribuindo a todas as suas posições o valor null 
	 */
	public void resetCaixa() {
		for (byte i = 0; i < caixa.length; i++) {
			caixa[i] = null;
		}
	}
}