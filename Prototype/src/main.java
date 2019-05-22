import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class main extends JPanel {

	private JPanel contentPane;

	private static final long serialVersionUID = 1L;

	// TODO move constants to other class
	final int RIGHT_GAMER_BAR_X = 750;
	final int GAMER_BAR_WIDTH = 28;
	final int GAMER_BAR_HEIGHT = 204;

	static int LEFT_GAMER_LOCATION_X = 10; //
	static int y1;
	static int y2 = 34;
	static int x2 = 750;

	int width;
	int height;

	float radiusOfBall = 10;
	float diameter = radiusOfBall * 2;

	float currentXOfBall = radiusOfBall + 20;
	float currentYOfBall = radiusOfBall + 20;

	float dx = 30;
	float dy = 10;

	public main() {

		setFocusable(true);
		requestFocusInWindow();
		setBackground(Color.BLACK);
		setLayout(null);

		final Image rightBarImage = new ImageIcon(this.getClass().getResource("/rechts.PNG")).getImage();

		JLabel rightGamer = new JLabel("New label");
		rightGamer.setIcon(new ImageIcon(rightBarImage));

		rightGamer.setBounds(RIGHT_GAMER_BAR_X, y1, GAMER_BAR_WIDTH, GAMER_BAR_HEIGHT);
		add(rightGamer);

		final Image leftBarImage = new ImageIcon(this.getClass().getResource("/links.PNG")).getImage();
		JLabel leftGamer = new JLabel("");
		leftGamer.setIcon(new ImageIcon(leftBarImage));
		leftGamer.setBounds(10, y2, GAMER_BAR_WIDTH, GAMER_BAR_HEIGHT);
		add(leftGamer);

		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				Thread t = new Thread() {
					public void run() {
						if (e.getKeyCode() == KeyEvent.VK_W) {

							y1 = (int) leftGamer.getBounds().getY();
							if (y1 > 0)
								y1 -= 10;
							leftGamer.setBounds(LEFT_GAMER_LOCATION_X, y1, GAMER_BAR_WIDTH, GAMER_BAR_HEIGHT);
						}
						if (e.getKeyCode() == KeyEvent.VK_S) {

							y1 = (int) leftGamer.getBounds().getY();
							if (y1 < 360)
								y1 += 10;
							leftGamer.setBounds(LEFT_GAMER_LOCATION_X, y1, GAMER_BAR_WIDTH, GAMER_BAR_HEIGHT);
						}
						if (e.getKeyCode() == KeyEvent.VK_UP) {

							y2 = (int) rightGamer.getBounds().getY();
							if (y2 > 10)
								y2 -= 10;
							rightGamer.setBounds(x2, y2, GAMER_BAR_WIDTH, GAMER_BAR_HEIGHT);
						}
						if (e.getKeyCode() == KeyEvent.VK_DOWN) {

							y2 = (int) rightGamer.getBounds().getY();
							if (y2 < 360)
								y2 += 10;
							rightGamer.setBounds(x2, y2, GAMER_BAR_WIDTH, GAMER_BAR_HEIGHT);
						}
					}
				};

				t.start();
			}

		});

	}

	Thread thread = new Thread() {
		public void run() {
			while (true) {

				width = getWidth();
				height = getHeight();

				currentXOfBall = currentXOfBall + dx;
				currentYOfBall = currentYOfBall + dy;

				if ((currentXOfBall - radiusOfBall < 0) || (currentXOfBall - radiusOfBall == LEFT_GAMER_LOCATION_X)) {
					dx = -dx;
					currentXOfBall = radiusOfBall;
				} else if (currentXOfBall + radiusOfBall > width) {
					dx = -dx;
					currentXOfBall = width - radiusOfBall;
				}

				if (currentYOfBall - radiusOfBall < 0) {
					dy = -dy;
					currentYOfBall = radiusOfBall;
				} else if (currentYOfBall + radiusOfBall > height) {
					dy = -dy;
					currentYOfBall = height - radiusOfBall;
				}
				repaint();

				try {
					Thread.sleep(50);
				} catch (InterruptedException ex) {
				}

			}
		}
	};
	{
		thread.start();
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.white);
		g.fillOval((int) (currentXOfBall - radiusOfBall), (int) (currentYOfBall - radiusOfBall), (int) diameter,
				(int) diameter);
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame("Bouncing Ball");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 600);
		frame.setContentPane(new main());
		frame.setVisible(true);
	}
}
