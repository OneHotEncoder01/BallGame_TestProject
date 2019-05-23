package pack1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;

public class GameScreen extends JFrame {

	public GameScreen() {

	}

	protected void paintComponent(Graphics g) {

		super.paintComponents(g);

		Graphics2D g2d = (Graphics2D) g;

		this.setBounds(0, 0, Properties.SCREEN_WIDTH, Properties.SCREEN_HEIGHT);
		this.setLayout(new BorderLayout());

		this.setSize(Properties.SCREEN_WIDTH, Properties.SCREEN_HEIGHT);
		this.setTitle("PONG");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		this.setResizable(false);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.addKeyListener(new KeyHandler());
		g.setColor(Color.BLACK);
		requestFocus();

		GamePanel gamePanel = new GamePanel();
		add(gamePanel, BorderLayout.CENTER);
		BarMovement move = new BarMovement(gamePanel);

		setVisible(true);

	}

}
