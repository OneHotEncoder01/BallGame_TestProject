import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JTextField;

public class Panels extends JFrame {

	private JPanel contentPane;

	static int x1, y1, x2, y2;
	private JTextField textField;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Panels frame = new Panels();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Panels() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		Image imgl = new ImageIcon(this.getClass().getResource("/links.PNG")).getImage();

		JLabel link = new JLabel("");
		link.setIcon(new ImageIcon(imgl));
		link.setBounds(28, 115, 28, 204);
		contentPane.add(link);
		
		Image imgr = new ImageIcon(this.getClass().getResource("/rechts.PNG")).getImage();
		
		JLabel rechts = new JLabel("");
		rechts.setIcon(new ImageIcon(imgl));
		rechts.setBounds(725, 142, 28, 204);
		contentPane.add(rechts);

		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_W) {
					x1 = (int) link.getBounds().getX();
					y1 = (int) link.getBounds().getY();
					if (y1 > 0)
						y1 -= 5;
					link.setBounds(x1, y1, 28, 204);
				}
				if (e.getKeyCode() == KeyEvent.VK_S) {
					x1 = (int) link.getBounds().getX();
					y1 = (int) link.getBounds().getY();
					if (y1 < 360)
						y1 += 5;
					link.setBounds(x1, y1, 28, 204);
				}
				if (e.getKeyCode() == KeyEvent.VK_UP) {
					x2 = (int) rechts.getBounds().getX();
					y2 = (int) rechts.getBounds().getY();
					if (y2 > 0)
						y2 -= 5;
					rechts.setBounds(x2, y2, 28, 204);
				}
				if (e.getKeyCode() == KeyEvent.VK_DOWN) {
					x2 = (int) rechts.getBounds().getX();
					y2 = (int) rechts.getBounds().getY();
					if (y2 < 360)
						y2 += 5;
					rechts.setBounds(x2, y2, 28, 204);
				}
			}

		});
	}
}