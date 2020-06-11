package oop_project;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Set;

import javax.swing.JOptionPane;

public class Ball {
	private static final int r=40;
	private Pong game;
	private int x, y, x1 = 3, y1 = 3;

	public Ball(Pong game) {
		this.game = game;
		x = game.getWidth() / 2;
		y = game.getHeight() / 2;
	}

	public int getX1() {
		return x1;
	}

	public void setX1(int x1) {
		this.x1 = x1;
	}

	public int getY1() {
		return y1;
	}

	public void setY1(int y1) {
		this.y1 = y1;
	}

	public void update() {
		x += x1;
		y += y1;
		if (x < 0) {
			game.getPanel().increaseScore(1);
			x = game.getWidth() / 2;
			x1 = -x1;
		} else if (x > 1920) {
			game.getPanel().increaseScore(2);
			x = game.getWidth() / 2;
			x1 = -x1;
		} else if (y < 0 || y > 1080-2*r )
			y1 = -y1;
		if (game.getPanel().getScore(1) == 5) {
			JOptionPane.showMessageDialog(null, "Player 1 wins", "Pong", JOptionPane.PLAIN_MESSAGE);System.exit(0); 
		}
		
		else if (game.getPanel().getScore(2) == 5) {
			JOptionPane.showMessageDialog(null, "Player 2 wins", "Pong", JOptionPane.PLAIN_MESSAGE);System.exit(0);
		}
		
		
		checkCollision();
	}

	public void checkCollision() {
		if (game.getPanel().getPlayer(1).getBounds().intersects(getBounds()) || game.getPanel().getPlayer(2).getBounds().intersects(getBounds()) || game.getPanel().getObstacle(1).getBounds().intersects(getBounds()) || game.getPanel().getObstacle(2).getBounds().intersects(getBounds()) || game.getPanel().getObstacle(3).getBounds().intersects(getBounds()) ) x1 = -x1;
	}

	public Rectangle getBounds() {
		return new Rectangle(x, y, r, r);
	}

	public void paint(Graphics g) {
		
		g.fillOval(x, y, r, r);
		
	}
}