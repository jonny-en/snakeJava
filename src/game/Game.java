package game;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Game extends JPanel implements ActionListener {

	private final int B_WIDTH = 300;
	private final int B_HEIGHT = 300;

	private Timer timer;
	private boolean inGame = true;
	private int xPos;
	private int yPos;

	public Game() {

		this.addKeyListener(new TAdapter());
		this.setFocusable(true);
		setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));

		init();
	}

	public void init() {
		xPos = 150;
		yPos = 150;

		timer = new Timer(140, this);
		timer.start();
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		doDrawing(g);
	}

	private void doDrawing(Graphics g) {
		if (inGame) {
			g.drawRect(xPos, yPos, 10, 10);
			Toolkit.getDefaultToolkit().sync();
		}

		else {
			gameOver(g);
		}

	}

	private void gameOver(Graphics g) {
		// do something
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

		repaint();
	}

	private class TAdapter extends KeyAdapter {
		@Override
		public void keyPressed(KeyEvent e) {
			int key = e.getKeyCode();

			if (key == KeyEvent.VK_LEFT) {
				xPos -= 10;
			}

			if (key == KeyEvent.VK_RIGHT) {
				xPos += 10;
			}

			if (key == KeyEvent.VK_UP) {
				yPos -= 10;
			}

			if (key == KeyEvent.VK_DOWN) {
				yPos += 10;
			}
		}
	}
}
