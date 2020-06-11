package oop_project;

import java.awt.Graphics;
import java.awt.Rectangle;

public class Racket {
	
	private static final int W = 20, H= 150;
	
	private int up, down;
	private int x,y,y1;
	private Pong game;
	
	public Racket(Pong game, int up, int down, int x) {
		
		this.game = game;
		this.x = x;
		y = game.getHeight() / 2;
		this.up = up;
		this.down = down;
	}

	public void update() {
		if (y > 0 && y < 1080-H-30)   y += y1;
		
		else if (y == 0)   y+=3;
		
		else if (y == 1080-H-30)    y-=3;
	}

	public void pressed(int keyCode) {
		if (keyCode == up)    y1 = -3;
		else if (keyCode == down)	y1 = 3;
	}

	public void released(int keyCode) {
		if (keyCode == up || keyCode == down)	y1 = 0;
	}

	public Rectangle getBounds() {
		
		return new Rectangle(x, y, W, H);
		
	}

	public void paint(Graphics g) {
		
		g.fillRect(x, y, W, H);
		
	}
}