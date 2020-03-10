package brickGame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.Timer;

import javax.swing.JPanel;

public class Gameplay extends JPanel implements KeyListener, ActionListener {
	
	private boolean play = false;
	private int score = 0;
	
	private int totalBricks = 21;
	
	private Timer timer;
	private int delay = 8;
	
	private int playerX = 310;
	
	private int ballposX = 350;
	private int ballposY = 400;
	//Speed of ball
	private int ballXdir = -3;
	private int ballYdir = -3;
	
	public Gameplay() {
		
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		timer = new Timer(delay, this);
		timer.start();
		
	}
	
	public void paint(Graphics g) {
		
		//background
		g.setColor(Color.black);
		g.fillRect(1,1,692,592);
		
		//borders
		g.setColor(Color.blue);
		g.fillRect(0, 0, 3, 592);
		g.fillRect(0, 0, 692, 3);
		g.fillRect(691, 0, 3, 592);
		
		//paddle
		g.setColor(Color.blue);
		g.fillRect(playerX,550,100,8);
		
		//ball
		g.setColor(Color.white);
		g.fillOval(ballposX, ballposY, 20, 20);
	}
			

	@Override
	public void actionPerformed(ActionEvent e) {
		timer.start();
		if(play) {
			//Create rectangle to detect intersection of objects
			if(new Rectangle(ballposX,ballposY,20,20).intersects(new Rectangle(playerX, 550, 100, 8))) {
				ballYdir = -ballYdir;
			}
			
			
			ballposX += ballXdir;
			ballposY += ballYdir;
			if(ballposX < 0) {
				ballXdir = -ballXdir;
			}
			if(ballposY < 0) {
				ballYdir = -ballYdir;
			}
			if(ballposX > 670) {
				ballXdir = -ballXdir;
			}
			
		}
		
		repaint();
		
		
	}

	
	//Don't need these
	@Override
	public void keyTyped(KeyEvent e) {}
	@Override
	public void keyReleased(KeyEvent e) {}
		

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			if(playerX >= 600) {
				playerX = 600;
			}
			else {
				moveRight();
			}
		}
		
		if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			if(playerX < 10) {
				playerX = 10;
			}
			else {
				moveLeft();
			}
		}
		
	}
	
	public void moveRight() {
		play = true;
		playerX += 50;
	}
	
	public void moveLeft() {
		play = true;
		playerX -= 50;
	}
	
	


}
