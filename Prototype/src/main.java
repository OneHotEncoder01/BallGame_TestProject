import java.awt.*;
import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class main extends JPanel {

	private JPanel contentPane;

	private static final long serialVersionUID = 1L;

	static int x1 = 10, y1, y2 = 34 ,x2 = 750;

	int width;
	int height;

	float radius = 10;
	float diameter = radius * 2;

	float X = radius + 20;
	float Y = radius + 20;

	float dx = 30;
	float dy = 10;
	
	public main() {
	
		setFocusable(true);
		requestFocusInWindow();
		setBackground(Color.BLACK);
		setLayout(null);

		Image imgr = new ImageIcon(this.getClass().getResource("/rechts.PNG")).getImage();

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(imgr));
		lblNewLabel.setBounds(750, y1, 28, 204);
		add(lblNewLabel);

		Image imgl = new ImageIcon(this.getClass().getResource("/links.PNG")).getImage();
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(imgl));
		lblNewLabel_1.setBounds(10, y2, 28, 204);
		add(lblNewLabel_1);
		
		
                	addKeyListener(new KeyAdapter() {
					@Override
					public void keyPressed(KeyEvent e) {
						Thread t = new Thread() {
							public void run() {
								if (e.getKeyCode() == KeyEvent.VK_W) {

									y1 = (int) lblNewLabel_1.getBounds().getY();
									if (y1 > 0)
										y1 -= 10;
									lblNewLabel_1.setBounds(x1, y1, 28, 204);
								}
								if (e.getKeyCode() == KeyEvent.VK_S) {

									y1 = (int) lblNewLabel_1.getBounds().getY();
									if (y1 < 360)
										y1 += 10;		
									lblNewLabel_1.setBounds(x1, y1, 28, 204);
								}
								if (e.getKeyCode() == KeyEvent.VK_UP) {

									y2 = (int) lblNewLabel.getBounds().getY();
									if (y2 > 10)
										y2 -= 10;
									lblNewLabel.setBounds(x2, y2, 28, 204);
								}
								if (e.getKeyCode() == KeyEvent.VK_DOWN) {

									y2 = (int) lblNewLabel.getBounds().getY();
									if (y2 < 360)
										y2 += 10;
									lblNewLabel.setBounds(x2, y2, 28, 204);
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

					X = X + dx;
					Y = Y + dy;

					if (X - radius<0  ) {
						dx = -dx;
						X = radius;
					} else if (X + radius > width) {
						dx = -dx;
						X = width - radius;
					}

					if (Y - radius < 0) {
						dy = -dy;
						Y = radius;
					} else if (Y + radius > height ) {
						dy = -dy;
						Y = height - radius;
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
		g.fillOval((int) (X - radius), (int) (Y - radius), (int) diameter, (int) diameter);
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame("Bouncing Ball");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 600);
		frame.setContentPane(new main());
		frame.setVisible(true);
	}
}
