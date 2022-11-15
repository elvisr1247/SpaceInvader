package entitys;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import main.spaceInvader;

public class bullet extends GameObject {
	
	public String direction = "";
	double speed = 0.03;
	double xMove,yMove;
	
	
	public bullet() {
		
	}

	public bullet(spaceInvader space, float x, float y) {
		super(space, x, y,5,15);
		// TODO Auto-generated constructor stub
		 
	}
	
	
	@Override
	public void update() {
		xMove = 0;
		yMove = 0;
		bounds = new Rectangle((int)x,(int)y,width,height);
		
		if(y>=455||y<=0) {
			space.bullet.remove(this);
		}
		//when bullet hits player damage player
		for(int i = 0;i < space.bullet.size();i++) {
			if(space.bullet.get(i).bounds.intersects(space.getPlayer().getBounds())) {
//				System.out.println("-1 life");
				int lives = space.getLives();
				space.setLives(lives-=1);
				space.bullet.remove(this);
				space.getPlayer().setX(space.getPlayerOrigionX());
				space.getPlayer().setY(space.getPlayerOrigionY());
			}
		}
		try {
			//when bullet hits alien give player points and remove alien
			for(int i = 0;i < space.bulletPlayer.size();i++) {
				for(int j = 0; j<space.alien1.size();j++) {
					if(space.bulletPlayer.get(i).bounds.intersects(space.alien1.get(j).getBounds())) {
						space.bulletPlayer.remove(this);
						space.alien1.remove(j);
						int score = space.getScore();
						space.setScore(score+=10);
						
					}
				}
			}
		}catch(Exception e) {
			System.out.println("player bullet removal code inside bullet class");
		}
		
		
		if(direction.equals("up"))yMove-=speed; 
		if(direction.equals("down"))yMove+=speed; 
		
		move();
		
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(Color.white);
		g.fillRect((int)x,(int)y, width, height);
		
	}
	

	public void move() {
		x+=xMove;
		y+=yMove;
	}
	
}
