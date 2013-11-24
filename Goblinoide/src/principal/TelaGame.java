import java.awt.Color;

import logica.Goblinoide;
import logica.Jogador;
import logica.Jogo;
import logica.Caixa;

import javax.swing.*;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import javax.swing.JPanel;

import javax.swing.ImageIcon;

import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;




@SuppressWarnings("serial")
public class TelaGame extends JFrame {
	public JButton[] buttonCaixa;
	public JButton[] buttonTabuleiro;
	//estanciado o vetor
	public Caixa[] cxlg;
	public Byte iPeca;
	public JPanel panel;

	public byte xMatriz=0, yMatriz=0;

	private static Jogo jogo;
	private static String jogador1, jogador2, dialogo;
	private static byte idGoblTemporario;
	public Jogo getJogo() 
	{
		return jogo;
	}
	
	
	

	public TelaGame(){
		
		
		
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		super.setTitle("Goblinoides");
		super.setResizable(false);
		super.getContentPane().setBackground(Color.BLACK);
		//super.setIconImage(Toolkit.getDefaultToolkit().getImage(PrgGoblinoide.class.getResource("/img/goblinIco.jpg")));
		super.setBounds(1, 1, 1280, 720);
		super.getContentPane().setLayout(null);

		

		
		panel = new JPanel();
		panel.setBackground(new Color(0, 0, 51));
		panel.setBounds(151, 157, 448, 500);
		super.getContentPane().add(panel);
		panel.setLayout(null);
		panel.setEnabled(false);
		panel.setVisible(false);
		
		
		buttonCaixa = new JButton[16];
		buttonTabuleiro = new JButton[16];
		
		String caminho;

		JLabel label = new JLabel("Sua Pe\u00E7a:");
		label.setForeground(new Color(0, 0, 153));
		label.setFont(new Font("Arial Black", Font.PLAIN, 20));
		label.setBounds(24, 49, 119, 42);
		getContentPane().add(label);
		
		JButton btnpca = new JButton("");
		btnpca.setBackground(Color.BLACK);
		btnpca.setBounds(151, 32, 100, 114);
		getContentPane().add(btnpca);
		
		
		JButton btnMgG = new JButton("");
		btnMgG.setIcon(new ImageIcon(PrgGoblinoide.class.getResource("/img/magoGordo.fw.png")));
		btnMgG.setBackground(Color.BLACK);
		btnMgG.setBounds(41, 347, 100, 134);
		getContentPane().add(btnMgG);
		
		JButton btnMgM = new JButton("");
		btnMgM.setIcon(new ImageIcon(PrgGoblinoide.class.getResource("/img/magoMagro.fw.png")));
		btnMgM.setBackground(Color.BLACK);
		btnMgM.setBounds(611, 347, 100, 134);
		getContentPane().add(btnMgM);
		btnMgM.setVisible(false);


		jogador1 = (JOptionPane.showInputDialog("Insira o nome do Jogador 1 (Mago Vermelho): "));
		jogador2 = (JOptionPane.showInputDialog("Insira o nome do Jogador 2 (Mago Azul): "));

		jogo = new Jogo(new Jogador(jogador1), new Jogador(jogador2));
		int x = 782, y = 128, xt= 10, yt=11;
		
		//byte xMatriz=0, yMatriz=0;
		
		dialogo += "\n ";
		dialogo += jogo.getJogadorDaVez().getNome() + ", retire uma peça para seu adversário jogar.";
        JOptionPane.showMessageDialog(null,dialogo);
        
		
		for (byte i=0; i<16; i++){
			
			
			
			 // estanciado os botões
			caminho = "/img/"+i+".png";
			
			buttonCaixa[i] = new JButton();
			buttonCaixa[i].setIcon(new ImageIcon(PrgGoblinoide.class.getResource(caminho.toString())));
			
			
			
			// alinhando os botões calculando as posições
			if (i==8){
				y = 128;
				x = 1027;
			}	
			
			if (i%2!=0){
				x = x + 121;	
			}
			else if (i%2==0 && i!=0 && i!=8) {
				
				x = x - 121;
				y= y + 121;
			}
			
			iPeca = i;
			
			System.out.print(iPeca);
			
			
			
			buttonCaixa[i].setBounds(x, y, 100, 114);
			super.getContentPane().add(buttonCaixa[i]);
			
			buttonCaixa[i].setName(Byte.toString(i));	
			buttonCaixa[i].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
						
						byte idx =  Byte.parseByte(((JButton)e.getSource()).getName());								
                        buttonCaixa[idx].setVisible(false);
                        //super.buttonCaixa[idx].dispose();
                        /*
                        for(byte i = 0; i < 16; i++) {
            				if (jogo.getCaixa().getGoblinoide(i) != null) {
            					dialogo += jogo.getCaixa().getGoblinoide(i).getId() + " ";
            				}
            			}
            			*/
            			
                        idGoblTemporario = idx;
            			if(idGoblTemporario < 0 || idGoblTemporario > 15) {
            				if (jogo.getTabuleiro().verificaQuarto() > 0)
            					jogo.getJogadorDaVez().adicionaPlacar();
            				else {
            					jogo.mudaTurno();
            					jogo.getJogadorDaVez().adicionaPlacar();
            				 }
            				JOptionPane.showMessageDialog(null, jogo.getJogadorDaVez().getNome()+ " ganhou!");
            				//break;
            			}
            			
            			//ver como utilizar um objeto 
            			panel.setVisible(true);
            			jogo.getCaixa().removeGoblinoide(idGoblTemporario);
            			jogo.getJogadorDaVez().setGoblSelecionado(new Goblinoide(idGoblTemporario));
            			// aqui o programa dá uma "pausa" para ter certeza que o jogador escolheu
            			// o goblinóide certo, como se perguntasse "você tem certeza que deseja escolher este?"
            			jogo.getTabuleiro().setGoblSugerido(jogo.getJogadorDaVez().getGoblSelecionado());
            			dialogo = "";
            			jogo.mudaTurno();
            			dialogo += jogo.getJogadorDaVez().getNome() + ", escolha onde o goblinóide deverá ficar no tabuleiro";
            			JOptionPane.showMessageDialog(null,dialogo);
                        
            			
            			//dialogo += jogo.getTabuleiro().getGoblSugerido().getNome() + " vai ficar. Coordenada ";
            			dialogo = "";
            			//imprimeJogo();
                        
					}
				});
			
			
			if ((i>0 && i<4) || (i>4 && i<8) || (i>8 && i<12)||(i>12)) {
				xMatriz =+1;
				xt = xt + 110;
				
			}
			else if(i==4||i==8||i==12){
				xMatriz = 0;
				yMatriz =+ 1;
				xt = 10;
				yt= yt + 123;
			
			}
			
			
			String idt = Byte.toString(i);
			
			
			
			buttonTabuleiro[i] = new JButton(idt);
			buttonTabuleiro[i].setName(idt);
			buttonTabuleiro[i].setForeground(new Color(204, 0, 0));
			buttonTabuleiro[i].setBackground(Color.BLACK);
			buttonTabuleiro[i].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					//x = Byte.parseByte(JOptionPane.showInputDialog(dialogo + " X:"));
        			//y = Byte.parseByte(JOptionPane.showInputDialog(dialogo + " Y:"));


					String pathImg = "/img/" + Byte.toString(idGoblTemporario)+".png";
			        System.out.print(pathImg);
					byte idt =  Byte.parseByte(((JButton)e.getSource()).getName());		
					
					buttonTabuleiro[idt].setIcon(new ImageIcon(PrgGoblinoide.class.getResource(pathImg)));
					
					
					if ((idt>0 && idt<4) || (idt>4 && idt<8) || (idt>8 && idt<12)||(idt>12)) {
						xMatriz = 0;
						
					}
					else if(idt==4||idt==8||idt==12){
						xMatriz = 0;
						yMatriz =+ 1;
						xt = 10;
						yt= yt + 123;
					
					}

					/// ver como mandar uma variavel para dentro de listener
					System.out.println("posição X="+TelaGame.this.xMatriz);
					System.out.println("posição y="+TelaGame.this.yMatriz);
					
					jogo.getTabuleiro().recebeGoblinoide(TelaGame.this.xMatriz, TelaGame.this.yMatriz);
        			
					String nropeca = Byte.toString(idGoblTemporario);
					//System.out.printf("Insere a peca: %s",nropeca);
					System.out.print(idGoblTemporario);
        			
					imprimeJogo();
					dialogo += "\n ";
					dialogo += jogo.getJogadorDaVez().getNome() + ", retire uma peça para seu adversário jogar.";
			        JOptionPane.showMessageDialog(null,dialogo);
			        panel.setEnabled(false);
        			
				}
			});
			
			buttonTabuleiro[i].setBounds(xt, yt, 100, 114);
			panel.add(buttonTabuleiro[i]);
		
			
			
			
			
		}
		
				JLabel lblNewLabel = new JLabel("Selecione a Pe\u00E7a do seu Advers\u00E1rio");
		lblNewLabel.setFont(new Font("Arial Black", Font.PLAIN, 20));
		lblNewLabel.setBounds(530, 32, 397, 42);
		super.getContentPane().add(lblNewLabel);
		
		JLabel lblSeuTurno = new JLabel("Seu turno!");
		lblSeuTurno.setFont(new Font("Arial Black", Font.PLAIN, 20));
		lblSeuTurno.setBounds(530, 496, 397, 42);
		super.getContentPane().add(lblSeuTurno);
		
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
		interfaceJogo += " |\n Placar: ";
		interfaceJogo += jogo.getJogador1().getNome() + " " + jogo.getJogador1().getPlacar() + " x ";
		interfaceJogo += jogo.getJogador2().getPlacar() + " " + jogo.getJogador2().getNome();
		JOptionPane.showMessageDialog(null, interfaceJogo);
	}
	

}
