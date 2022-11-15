package entitys;

import java.awt.Graphics;
import java.awt.Rectangle;

import main.spaceInvader;

public abstract class GameObject {

	protected float x,y;
	protected int width,height;
	
	protected double speed;
	protected spaceInvader space;
	protected Rectangle bounds = new Rectangle(0,0,0,0);
	
	public GameObject() {}
	
	public GameObject(spaceInvader space,float x,float y,int width,int height) {
		this.space = space;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		bounds = new Rectangle(0,0,width,height);
	}
	
	public abstract void update();
	
	public abstract void draw(Graphics g);

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public Rectangle getBounds() {
		return bounds;
	}

	public void setBounds(Rectangle bounds) {
		this.bounds = bounds;
	}
}
