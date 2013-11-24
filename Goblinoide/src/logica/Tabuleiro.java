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
 * Classe do tabuleiro do jogo Goblinóides
 */
public class Tabuleiro {
	public static byte[] getLinhaColuna (byte fila, byte numero) {
		byte[] linhaColuna = new byte[2];
		switch (fila) {
			case  1:
			case  2:
			case  3:
	 		case  4: {
				linhaColuna[0] = (byte)(fila - 1);
				linhaColuna[1] = numero;
				return linhaColuna;
			}
			case  5:
			case  6:
			case  7:
			case  8: {
				linhaColuna[0] = numero;
				linhaColuna[1] = (byte)(fila - 5);
				return linhaColuna;
			}
			case  9: {
				linhaColuna[0] = numero;
				linhaColuna[1] = numero;
				return linhaColuna;
			}
		}
		linhaColuna[0] = numero;
		linhaColuna[1] = (byte)(3 - numero);
		return linhaColuna;
	}
	private Goblinoide[][] casas;  

	private Goblinoide goblSugerido;

	public Tabuleiro () {
		casas = new Goblinoide[4][4];
		limpaGoblSugerido();
		limpaCasas();
	}
	
	private void addGoblinoide(Goblinoide goblinoide, byte coordX, byte coordY){
	  casas[coordX][coordY] = goblinoide;
	}  
	
	public boolean estaCheio () {
		for (byte l = 0; l < 4; l++) {
			for (byte c = 0; c < 4; c++) {
				if (casas[l][c] == null) {
					return false;
				}
			}
		}
		return true;
	}
	
	public Tabuleiro getCloneTabuleiro(){	
		Tabuleiro tabuleiroClone = new Tabuleiro();
		for (byte i = 0 ; i < 4 ; i++){
			for(byte j = 0 ; j < 4 ; j++){
				Goblinoide goblCorrente = this.getGoblinoide(i,j);
				if (goblCorrente != null) {
					tabuleiroClone.addGoblinoide(new Goblinoide(goblCorrente.getId()),i,j);
				}
			}
			
		}
		
		if (this.getGoblSugerido() != null) {
			tabuleiroClone.setGoblSugerido(new Goblinoide(getGoblSugerido().getId()));
		}
		
		return tabuleiroClone;
	}

	public Goblinoide[] getFila (byte fila) {
		Goblinoide[] goblinoides = new Goblinoide[4];
		for (byte p = 0; p <= 3; p++) {
			goblinoides[p] = getGoblFila(fila, p); 
		}
		return goblinoides;
	}
	
	public Goblinoide getGoblFila (byte fila, byte numero) {
		switch (fila) {
			case  1:
			case  2:
			case  3:
	 		case  4: return casas[fila - 1][numero];
			case  5:
			case  6:
			case  7:
			case  8: return casas[numero][fila - 5];
			case  9: return casas[numero][numero];
		}
		return casas[numero][3 - numero];
	} 
	
	public Goblinoide getGoblinoide (byte linha, byte coluna) {
		return casas[linha][coluna];
	} 
	
	public Goblinoide getGoblSugerido () {
		return goblSugerido;
	}

	private void limpaCasas () {
		for (byte l = 0; l <= 3; l++) {
			for (byte c = 0; c <= 3; c++) {
				casas[l][c] = null;
			}
		}
	}
	
	private void limpaGoblSugerido() {
		goblSugerido = null;
	} 
	
	public byte numeroDeGoblFila (byte fila) {
		byte contador = 0;
		for (byte n = 0; n < 4; n++) {
			if (getGoblFila(fila, n) != null) {
				contador++;
			}
		}
		return contador;
	}
	
	public void recebeGoblinoide (byte linha, byte coluna) {
		casas[linha][coluna] = getGoblSugerido();
		limpaGoblSugerido();
	}
	
	public void setGoblSugerido (Goblinoide goblinoide) {
		goblSugerido = goblinoide;
	}
	
	public byte verificaQuarto() {
		for (byte f = 1; f <= 10; f++) {
			if (numeroDeGoblFila(f) == 4) {
				Goblinoide[] goblinoides = getFila(f);
				byte normal = (byte)(goblinoides[0].getId() & goblinoides[1].getId() & 
									 goblinoides[2].getId() & goblinoides[3].getId());
				byte inverso = (byte)(~goblinoides[0].getId() & ~goblinoides[1].getId() & 
									  ~goblinoides[2].getId() & ~goblinoides[3].getId());
				inverso <<= 4;
				inverso >>>= 4;
				if (normal != 0 || inverso != 0) {
					return f;
				}
			}
		}
		return -1;
	}
	
	public boolean verificaQuartoNaFila (byte fila) {
		if (numeroDeGoblFila(fila) == 4) {
				Goblinoide[] goblinoides = getFila(fila);
				byte normal = (byte)(goblinoides[0].getId() & goblinoides[1].getId() & 
									 goblinoides[2].getId() & goblinoides[3].getId());
				byte inverso = (byte)(~goblinoides[0].getId() & ~goblinoides[1].getId() & 
									  ~goblinoides[2].getId() & ~goblinoides[3].getId());
				inverso <<= 4;
				inverso >>>= 4;
				if (normal != 0 || inverso != 0) {
					return true;
				}
			}
		return false;
	}
}