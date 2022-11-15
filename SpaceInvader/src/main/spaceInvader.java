package main;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import entitys.Player;
import entitys.alien;
import entitys.bullet;


public class spaceInvader extends JPanel {
	
	//space invader help
	//https://codeheir.com/2019/03/17/how-to-code-space-invaders-1978-7/
	private static final long serialVersionUID = 1L;
	
	private JFrame frame;
	
	public int playerOrigionX = 200;
	public int playerOrigionY = 400;
	
	//Enemy
	public CopyOnWriteArrayList<alien> alien1 = new CopyOnWriteArrayList<alien>();
	public CopyOnWriteArrayList<bullet> bullet = new CopyOnWriteArrayList<bullet>();
	public CopyOnWriteArrayList<bullet> bulletPlayer = new CopyOnWriteArrayList<bullet>();
	
	private int score = 0;
	private int lives = 3;
	private int winningScore = 60;
	int timer = 0;
	
	private Player player;	
	private KeyManager keyManager;
	
	public spaceInvader() {
		frame = new JFrame();
		player = new Player(this,200,400,30,30);
		keyManager = new KeyManager(this);
		
		alien1.add(new alien(this,10,80,30,30));
		alien1.add(new alien(this,50,80,30,30));
		alien1.add(new alien(this,90,80,30,30));
		
		alien1.add(new alien(this,10,40,30,30));
		alien1.add(new alien(this,50,40,30,30));
		alien1.add(new alien(this,90,40,30,30));
		
	
		this.setBackground(Color.black);
		this.addKeyListener(keyManager);
		frame.add(this);
		frame.addKeyListener(keyManager);
		frame.setTitle("Space Invader");
		frame.setSize(500,500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	public void paint(Graphics g) {
		super.paintComponent(g);

			if(lives!=0) {
				if(score!=winningScore) {
					player.update();
				}else if (score == winningScore) {
					g.setColor(Color.red);
					g.drawString("You win", 200,200);
				}
				player.draw(g);
				aliens(g);	
				bullets(g);
				Hud(g);
			}else {
				g.setColor(Color.red);
				g.drawString("You lose", 200,200);
			}
			timer++;
			if(timer==3000) {
				int rand = (int)(Math.random()*3)+1;
				
				try {
					if(rand == 1) {
						bullet.add(new bullet(this,alien1.get(0).getX()+10,alien1.get(0).getY()+20));
					}
					if(rand == 2) {
						bullet.add(new bullet(this,alien1.get(1).getX()+10,alien1.get(1).getY()+20));
					}
					if(rand == 3) {
						bullet.add(new bullet(this,alien1.get(2).getX()+10,alien1.get(2).getY()+20));
					}
				}catch(Exception e) {
					System.out.println("random bullet shot by aliens inside spaceinvader");
				}
								
				timer = 0;
			}
	
		//re-draws the screen needed
		repaint();
		g.dispose();
	}
	
	
	private void Hud(Graphics g) {
		g.setColor(Color.white);
		g.drawString("SCORE "+score, 30, 15);
		g.drawString("LIVES "+lives, 300, 15);
		
	}

	private void aliens(Graphics g) {
		for(alien a : alien1) {
			if(score != winningScore)a.update();
			a.draw(g);
		}
	}

	private void bullets(Graphics g) {		
			for(int i = 0;i<bullet.size();i++) {
				bullet b = bullet.get(i);
				b.direction = "down";
				if(score != winningScore)b.update();
				b.draw(g);
			}

		for(int i = 0;i<bulletPlayer.size();i++) {
			bullet b = bulletPlayer.get(i);
			b.direction = "up";
			if(score != winningScore)b.update();
			b.draw(g);
			
		}
	}

	public KeyManager getKeyManager() {
		return keyManager;
	}
	
	public Player getPlayer() {
		return player;
	}
	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getLives() {
		return lives;
	}

	public void setLives(int lives) {
		this.lives = lives;
	}

	public int getPlayerOrigionX() {
		return playerOrigionX;
	}

	public int getPlayerOrigionY() {
		return playerOrigionY;
	}

	public static void main(String[]argh) {
		new spaceInvader();
	}
}
