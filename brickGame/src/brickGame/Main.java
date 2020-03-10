package brickGame;

import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {
		
		//Build frame for game
		JFrame obj = new JFrame();
		
		//Reference Gameplay
		Gameplay gamePlay = new Gameplay();
		
		//Set restrictions
		obj.setBounds(10,10,700,600);
		obj.setTitle("brickGame");
		obj.setResizable(false);
		obj.setVisible(true);
		obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		obj.add(gamePlay);
		obj.setVisible(true);
		
		
	}

}
