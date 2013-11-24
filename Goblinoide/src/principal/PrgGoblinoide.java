import javax.swing.SwingUtilities;


public class PrgGoblinoide {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				TelaMenu newmenu = new TelaMenu();
				newmenu.setVisible(true);
				
			}
		});
	}

}









/*
package principal;

import javax.swing.JOptionPane;

import logica.Goblinoide;
import logica.Jogador;
import logica.Jogo;

public class PrgGoblinoide {

	private static Jogo jogo;
	private static String jogador1, jogador2, dialogo;
	private static byte idGoblTemporario, x, y;
	
	public Jogo getJogo() 
	{
		return jogo;
	}
	

	public static void main(String[] argv) {
	
	dialogo = "Pe�as dispon�veis: ";
	jogador1 = (JOptionPane.showInputDialog("Insira o nome do Jogador 1: "));
	jogador2 = (JOptionPane.showInputDialog("Insira o nome do Jogador 2: "));
	jogo = new Jogo(new Jogador(jogador1), new Jogador(jogador2));
	

	do {
		for(byte i = 0; i < 16; i++) {
			if (jogo.getCaixa().getGoblinoide(i) != null) {
				dialogo += jogo.getCaixa().getGoblinoide(i).getId() + " ";
			}
		}
		dialogo += "\n ";
		dialogo += jogo.getJogadorDaVez().getNome() + ", retire uma pe�a para seu advers�rio jogar.";
		idGoblTemporario = Byte.parseByte(JOptionPane.showInputDialog(dialogo));
		if(idGoblTemporario < 0 || idGoblTemporario > 15) {
			if (jogo.getTabuleiro().verificaQuarto() > 0)
				jogo.getJogadorDaVez().adicionaPlacar();
			else {
				jogo.mudaTurno();
				jogo.getJogadorDaVez().adicionaPlacar();
			 }
			JOptionPane.showMessageDialog(null, jogo.getJogadorDaVez().getNome()+ " ganhou!");
			imprimeJogo();
			break;
		}
		jogo.getCaixa().removeGoblinoide(idGoblTemporario);
		jogo.getJogadorDaVez().setGoblSelecionado(new Goblinoide(idGoblTemporario));
		// aqui o programa d� uma "pausa" para ter certeza que o jogador escolheu
		// o goblin�ide certo, como se perguntasse "voc� tem certeza que deseja escolher este?"
		jogo.getTabuleiro().setGoblSugerido(jogo.getJogadorDaVez().getGoblSelecionado());
		dialogo = "";
		jogo.mudaTurno();
		dialogo += jogo.getJogadorDaVez().getNome() + ", escolha onde o goblin�ide ";
		dialogo += jogo.getTabuleiro().getGoblSugerido().getNome() + " vai ficar. Coordenada ";
		x = Byte.parseByte(JOptionPane.showInputDialog(dialogo + " X:"));
		y = Byte.parseByte(JOptionPane.showInputDialog(dialogo + " Y:"));
		jogo.getTabuleiro().recebeGoblinoide(x, y);
		dialogo = "";
		imprimeJogo();
	} while (!(jogo.getCaixa().estaVazia()));
}

static void imprimeJogo() {
	String interfaceJogo = "Tabuleiro:\n";
	for (byte l = 0; l < 4; l++) {
		interfaceJogo += "| ";
		for (byte c = 0; c < 4; c++) {
			interfaceJogo += " ";
			if (jogo.getTabuleiro().getGoblinoide(l, c) != null)
				interfaceJogo += Byte.toString(jogo.getTabuleiro().getGoblinoide(l, c).getId());
			else
				interfaceJogo += "XX";
			interfaceJogo += " ";
		}
		interfaceJogo += "|\n";
	}
	interfaceJogo += "\n Placar: ";
	interfaceJogo += jogo.getJogador1().getNome() + " " + jogo.getJogador1().getPlacar() + " x ";
	interfaceJogo += jogo.getJogador2().getPlacar() + " " + jogo.getJogador2().getNome();
	JOptionPane.showMessageDialog(null, interfaceJogo);
}
}
*/
