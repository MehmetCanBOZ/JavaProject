package oop_project;

import java.awt.Color;

import javax.swing.JFrame;

public class Pong extends JFrame {
    
	private final static int W = 1920, H = 1080;
    
	private Panel panel;

    public Pong() {
        setSize(W, H);
        setTitle("PING  PONG  GAME");
        setBackground(Color.GREEN);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        panel = new Panel(this);
        add(panel);
    }

    public Panel getPanel() {
        return panel;
        
    }}