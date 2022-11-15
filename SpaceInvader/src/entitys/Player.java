package entitys;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Toolkit;

import main.spaceInvader;

public class Player extends GameObject{
	
	double speed = 0.09;
	double xMove,yMove;
	
	public boolean isPlayerShootingit = false; 

	public Player(spaceInvader space, float x, float y, int width, int height) {
		super(space, x, y, width, height);
		
	}
	
	@Override
	public void update() {
		xMove = 0;
		yMove = 0;
		bounds = new Rectangle((int)x,(int)y,width,height);
		
		if(space.getKeyManager().left)xMove-=speed;
		if(space.getKeyManager().right)xMove+=speed;
		
		move();
	}

	@Override
	public void draw(Graphics g) {
		g.drawImage(Toolkit.getDefaultToolkit().getImage("res/player.png"),(int)x,(int)y,width,height,null);
	}
	
	private void move() {
		x+=xMove;
		y+=yMove;
		
	}

}
