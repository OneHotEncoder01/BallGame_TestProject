package window;

import java.awt.*;
import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
 
public class BouncingBall extends JPanel {
 
	private static final long serialVersionUID = 1L;
	
  int x1,y1,x2,y2 =34;

  int width;
  int height;
 

  float radius = 10; 
  float diameter = radius * 2;
 

  float X = radius + 20;
  float Y = radius + 20;
 

  float dx = 15;
  float dy = 7;
 
  public BouncingBall() {

  	setFocusable(true);
  	requestFocusInWindow();
  	setBackground(Color.BLACK);
  	setLayout(null);
  	
  	JLabel lblNewLabel = new JLabel("New label");
  	lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
  	lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Lenovo\\Desktop\\links.PNG"));
  	lblNewLabel.setBounds(x1, y1, 28, 204);
  	add(lblNewLabel);
  	
  	JLabel lblNewLabel_1 = new JLabel("New label");
  	lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Lenovo\\Desktop\\rechts.PNG"));
  	lblNewLabel_1.setBounds(730, 136, 28, 204);
  	add(lblNewLabel_1);
  	
  	addKeyListener(new KeyAdapter() {
  		@Override
  		public void keyPressed(KeyEvent e)	 {
  			if(e.getKeyCode()==KeyEvent.VK_S) {
  				x1 = (int) lblNewLabel.getBounds().getX();
  				y1 = (int) lblNewLabel.getBounds().getY();
  			  if(y1 < 650) y1 -=5;
  			}
  		}
  	});
 
    Thread thread = new Thread() {
      public void run() {
        while (true) {
 
          width = getWidth();
          height = getHeight();
 
          X = X + dx ;
          Y = Y + dy;
 
          if (X - radius < 0) {
            dx = -dx; 
            X = radius; 
          } else if (X + radius > width) {
            dx = -dx;
            X = width - radius;
          }
 
          if (Y - radius < 0) {
            dy = -dy;
            Y = radius;
          } else if (Y + radius > height) {
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
    thread.start();
  }
 
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    g.setColor(Color.white);
    g.fillOval((int)(X-radius), (int)(Y-radius), (int)diameter, (int)diameter);
  }
 
  public static void main(String[] args) {
    JFrame frame = new JFrame("Bouncing Ball");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(800, 600);
    frame.setContentPane(new BouncingBall());
    frame.setVisible(true);
  }
}
