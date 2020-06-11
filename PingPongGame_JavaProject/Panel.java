package oop_project;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


import javax.swing.JPanel;
import javax.swing.Timer;

public class Panel extends JPanel implements ActionListener, KeyListener {
  
    private Ball ball;
    private Racket p1, p2;
    private int s1, s2;
    private Obstacle obs1,obs2,obs3;
    private Pong game;
    public Panel(Pong game) {
        setBackground(Color.CYAN);
       
        this.game = game;
        
        ball = new Ball(game);
        
        obs1=new Obstacle(game,1500,100);
        obs2=new Obstacle(game,400,350);
        obs3=new Obstacle(game,750,700);
        
        p1 = new Racket(game, KeyEvent.VK_UP, KeyEvent.VK_DOWN, 1920-25);
        
        p2 = new Racket(game, KeyEvent.VK_A, KeyEvent.VK_D,0);
        Timer timer = new Timer(5, this);
        timer.start();
      
        addKeyListener(this);
        setFocusable(true);
    }

    public Racket getPlayer(int playerNo) {
        if (playerNo == 1)
            return p1;
        else
            return p2;
    }
    
    public Obstacle getObstacle(int obs) {
    	if(obs == 1) {
    		return obs1;
    	}else if(obs==2){
    		return obs2;
    	}else 
    		return obs3;
    	
    }

    public void increaseScore(int playerNo) {
        if (playerNo == 1)
            s2++;
        else
            s1++;
    }

    public int getScore(int playerNo) {
        if (playerNo == 1)
            return s1;
        else
            return s2;
    }
   
    private void update() {
        ball.update();
        p1.update();
        p2.update();
    }

    public void actionPerformed(ActionEvent e) {
        update();
        repaint();
    }

    public void keyPressed(KeyEvent e) {
        p1.pressed(e.getKeyCode());
        p2.pressed(e.getKeyCode());
    }

    public void keyReleased(KeyEvent e) {
        p1.released(e.getKeyCode());
        p2.released(e.getKeyCode());
    }

  

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawString(game.getPanel().getScore(1) + " : " + game.getPanel().getScore(2), game.getWidth() / 2, 50);
        obs1.paint(g); 
        obs2.paint(g); 
        obs3.paint(g); 
        ball.paint(g);
        p1.paint(g);
        p2.paint(g);
    }

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	
}