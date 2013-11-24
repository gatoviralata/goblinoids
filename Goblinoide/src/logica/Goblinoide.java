package logica;

/*
 * Projeto Goblin�ides
 *	Faculdade Tecnol�gica de Carapicu�ba
 *	Equipe Sem Nome
 *	Tecnologia em Jogos Digitais, 3� ciclo Manh�
 *	Engenharia de Software
 */

/**
 * @author Thiago Valen�a
 * Classe das pe�as do jogo Goblin�ides
 */

public class Goblinoide {
	// Define o n�mero de identifica��o de cada est�tua de Goblin�ide
	private byte id;
	
	/**
	 * M�todo construtor da classe Goblinoide
	 * @param id o n�mero de identifica��o do Goblin�ide (varia de 0 a 15)
	 */
	public Goblinoide(byte id) {
		this.id = id;
	}
	
	/**
	 * Retorna a altura da est�tua
	 * @return 0 se a est�tua for baixa, 1 se for alta
	 */	
	public byte getAltura() {
		// Foi utilizado o operador & (e l�gico), que a grosso modo faz
		// uma compara��o entre as posi��es bin�rias e retorna 0 ou 1
		if ((getId() & (byte)4) == 0) {
			return 0;
		}
		return 1;
	}

	/**
	 * Retorna a cor da est�tua
	 * @return 0 se a est�tua for escura, 1 se for branca
	 */	
	public byte getCor() {
		if ((getId() & (byte)1) == 0) {
			return 0;
		}
		return 1;
	}

	/**
	 * Retorna a for�a da est�tua
	 * @return 0 se a est�tua for fraca, 1 se for forte
	 */	
	public byte getForca() {
		if ((getId() & (byte)2) == 0) {
			return 0;
		}
		return 1;
	}
	
	/**
	 * Retorna o n�mero de identifica��o da est�tua Goblin�ide
	 * @return byte de 0 a 15
	 */	
	public byte getId() {
		return id;
	}
	
	/**
	 * Retorna a string que descreve a est�tua
	 * @return String do nome da pe�a
	 */	
	public String getNome() {
		switch(this.getId()) {
		case 0:
			return "Goblin Cinza";
		case 1:
			return "Goblin Branco";
		case 2:
			return "Orc Granito";
		case 3:
			return "Orc Marfim";
		case 4:
			return "Hobgoblin Granito";
		case 5:
			return "Hobgoblin Marfim";
		case 6:
			return "Ogro Granito";
		case 7:
			return "Ogro Marfim";
		case 8:
			return "Kobold Cinza";
		case 9:
			return "Kobold Marfim";
		case 10:
			return "Bugbear Cinza";
		case 11:
			return "Bugbear Marfim";
		case 12:
			return "Gnoll Cinza";
		case 13:
			return "Gnoll Marfim";
		case 14:
			return "Troll Cinza";
		case 15:
			return "Troll Marfim";
		default:
			return "Vazio";
		}
	}

	/**
	 * Retorna a ra�a da est�tua
	 * @return 0 se a est�tua for goblin, 1 se for kobold
	 */	
	public byte getRaca() {
		if ((getId() & (byte)8) == 0) {
			return 0;
		}
		return 1;
	}

	/**
	 * Insere o id na est�tua
	 * @param _id seta o id da inst�ncia da classe
	 */	
	public void setId(byte _id) {
		this.id = _id;
	}
}
