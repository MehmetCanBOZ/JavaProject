package oop_project;

import java.awt.Graphics;
import java.awt.Rectangle;

public class Obstacle {
	private static final int W = 20, H= 180;
	private int x,y;
	private Pong game;
	
public Obstacle(Pong game, int x,int y) {
		
		this.game = game;
		this.x = x;
		this.y=y;
		
	}
public void update() {
	
	
      if (y == 0)   y+=3;
	
	else if (y == 1080-H-30)    y-=3;
}
public Rectangle getBounds() {
	
	return new Rectangle(x, y, W, H);
	
}
public void paint(Graphics g) {
	
	g.fillRect(x, y, W, H);
	
}
}
