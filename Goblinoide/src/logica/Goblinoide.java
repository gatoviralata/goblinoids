package logica;

/*
 * Projeto Goblinóides
 *	Faculdade Tecnológica de Carapicuíba
 *	Equipe Sem Nome
 *	Tecnologia em Jogos Digitais, 3º ciclo Manhã
 *	Engenharia de Software
 */

/**
 * @author Thiago Valença
 * Classe das peças do jogo Goblinóides
 */

public class Goblinoide {
	// Define o número de identificação de cada estátua de Goblinóide
	private byte id;
	
	/**
	 * Método construtor da classe Goblinoide
	 * @param id o número de identificação do Goblinóide (varia de 0 a 15)
	 */
	public Goblinoide(byte id) {
		this.id = id;
	}
	
	/**
	 * Retorna a altura da estátua
	 * @return 0 se a estátua for baixa, 1 se for alta
	 */	
	public byte getAltura() {
		// Foi utilizado o operador & (e lógico), que a grosso modo faz
		// uma comparação entre as posições binárias e retorna 0 ou 1
		if ((getId() & (byte)4) == 0) {
			return 0;
		}
		return 1;
	}

	/**
	 * Retorna a cor da estátua
	 * @return 0 se a estátua for escura, 1 se for branca
	 */	
	public byte getCor() {
		if ((getId() & (byte)1) == 0) {
			return 0;
		}
		return 1;
	}

	/**
	 * Retorna a força da estátua
	 * @return 0 se a estátua for fraca, 1 se for forte
	 */	
	public byte getForca() {
		if ((getId() & (byte)2) == 0) {
			return 0;
		}
		return 1;
	}
	
	/**
	 * Retorna o número de identificação da estátua Goblinóide
	 * @return byte de 0 a 15
	 */	
	public byte getId() {
		return id;
	}
	
	/**
	 * Retorna a string que descreve a estátua
	 * @return String do nome da peça
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
	 * Retorna a raça da estátua
	 * @return 0 se a estátua for goblin, 1 se for kobold
	 */	
	public byte getRaca() {
		if ((getId() & (byte)8) == 0) {
			return 0;
		}
		return 1;
	}

	/**
	 * Insere o id na estátua
	 * @param _id seta o id da instância da classe
	 */	
	public void setId(byte _id) {
		this.id = _id;
	}
}
