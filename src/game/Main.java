package game;

import java.awt.EventQueue;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Main extends JFrame {

	public Main() {
		this.add(new Game());
		this.setResizable(false);
		pack();

		setTitle("Snake v0.0");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				JFrame ex = new Main();
				ex.setVisible(true);
			}
		});
	}

}
