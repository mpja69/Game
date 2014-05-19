package se.mpja.game;

import java.awt.Canvas;
import java.awt.Dimension;
import javax.swing.JFrame;

public class Game implements Runnable {
	
	public Game() {
		frame = getJFrame();
		canvas = getCanvas();
		frame.add(canvas);
		frame.pack();
		frame.setVisible(true);
	}

	private JFrame frame;
	private Canvas canvas;
	private Thread thread;

	public static final int WIDTH = 300, HEIGHT = WIDTH / 16 * 12;
	public static final String TITLE = "Game";
	private static final int SCALE = 3;

	public void start(){
		thread = new Thread(this, "MainThread");
		thread.start();
	}

	public void run() {
		System.out.println("Running my game");
	}
	private Canvas getCanvas(){
		Canvas c = new Canvas();
		Dimension d = new Dimension(WIDTH * SCALE, HEIGHT * SCALE);
		c.setMaximumSize(d);
		c.setMinimumSize(d);
		c.setPreferredSize(d);
		return c;
	}

	private JFrame getJFrame(){
		JFrame f = new JFrame();
		f.setResizable(false);
		f.setName(TITLE);
		f.setTitle(TITLE);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		return f;
	}

	public static void main(String[] args) {
		new Game().start();
	}
}
