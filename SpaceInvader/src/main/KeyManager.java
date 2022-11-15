package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import entitys.bullet;

public class KeyManager implements KeyListener {
	
	public boolean left = false,right = false,
			spacebar = false;
	
	private spaceInvader space;
	
	public KeyManager(spaceInvader space) {
		this.space = space;
	}
	

	@Override
	public void keyTyped(KeyEvent e) {
		
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_A)left = true;
		if(e.getKeyCode() == KeyEvent.VK_D)right = true;
		if(e.getKeyCode() == KeyEvent.VK_SPACE) {
			space.bulletPlayer.add(new bullet(space,space.getPlayer().getX(),space.getPlayer().getY()));
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_A)left = false;
		if(e.getKeyCode() == KeyEvent.VK_D)right = false;
		
	}

}
