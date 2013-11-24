import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class TelaMenu extends JFrame{
	
	public TelaMenu(){
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		super.setTitle("Goblinoides");
		super.setResizable(false);
		super.getContentPane().setBackground(Color.BLACK);
		//super.setIconImage(Toolkit.getDefaultToolkit().getImage(PrgGoblinoide.class.getResource("/img/goblinIco.jpg")));
		super.setBounds(100, 100, 1016, 647);
		super.getContentPane().setLayout(null);
		
		
		JButton btnNewGame = new JButton("New Game");
		btnNewGame.setBounds(423, 179, 138, 35);
		super.getContentPane().add(btnNewGame);
		btnNewGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				TelaGame newgame = new TelaGame();
				newgame.setVisible(true);
				TelaMenu.super.dispose();
			}
		});
		
		
		JButton btnTutorial = new JButton("Tutorial");
		btnTutorial.setBounds(423, 248, 138, 35);
		super.getContentPane().add(btnTutorial);
		btnTutorial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Tutorial newtutorial = new Tutorial();
				newtutorial.setVisible(true);
				TelaMenu.super.dispose();
			}
		});
		
		JButton btnOption = new JButton("Opções");
		btnOption.setBounds(423, 323, 138, 35);
		super.getContentPane().add(btnOption);
		
		JButton btnSair = new JButton("Sair");
		btnSair.setBounds(423, 400, 138, 35);
		super.getContentPane().add(btnSair);
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				TelaMenu.super.dispose();
			}
		});
	}

}
