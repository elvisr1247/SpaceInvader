package entitys;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Toolkit;

import main.spaceInvader;

public class alien extends GameObject {
	
	String direction = "right";
	boolean right = false;
	boolean left = false;

	double dfspeed = 0.01;
	
	public alien(spaceInvader space,float x, float y, int width, int height) {
		super(space,x, y, width, height);
		speed = dfspeed;
	}
	
	@Override
	public void update() {
		bounds = new Rectangle((int)x,(int)y,width,height);
		for(int i = 0;i<space.alien1.size();i++) {
			if(space.alien1.get(i).getX()>=455) {
				direction = "right";
				right = true;
				left = false;
				y+=10 ;//moves aliens down every time it hits the corner
			}else if(space.alien1.get(i).getX()<=0){
				direction = "left";
				left = true;
				right = false;
				y+=10;//moves aliens down every time it hits the corner
			}
		}
			
	
		if(right) {
			direction = "right";
		}
		if(left) {
			direction = "left";
		}
		
		if(direction.equals("right")) {
			x-=speed;
		}
		if(direction.equals("left")) {
			x+=speed;
		}
		speed = dfspeed;
		
  }

	@Override
	public void draw(Graphics g) {
		g.drawImage(Toolkit.getDefaultToolkit().getImage("res/alien.png"),(int)x,(int)y,width,height,null);
	}

}
