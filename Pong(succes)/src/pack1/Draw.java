package pack1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JLabel;

public class Draw extends JLabel {

	protected void paintComponent(Graphics g) {

		super.paintComponent(g);

		Graphics2D g2d = (Graphics2D) g;

		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		g.setColor(Color.BLACK);
		g.fillRect(0, 0, Var.screenwidth, Var.screenheight);

		g.setColor(Color.BLUE);
		g.fillRect(Var.x, Var.y, 11, 53);
		g.setColor(Color.RED);
		g.fillRect(Var.gegnerx, Var.gegnery, 11, 53);

		/*
		 * final Image leftBarImage = new
		 * ImageIcon(this.getClass().getResource("/links.PNG")).getImage(); JLabel
		 * leftGamer = new JLabel(""); leftGamer.setIcon(new ImageIcon(leftBarImage));
		 * leftGamer.setBounds(Var.x, Var.y, 11, 53); add(leftGamer);
		 * 
		 * final Image rightBarImage = new
		 * ImageIcon(this.getClass().getResource("/rechts.PNG")).getImage(); JLabel
		 * rightGamer = new JLabel("New label"); rightGamer.setIcon(new
		 * ImageIcon(rightBarImage)); rightGamer.setBounds(Var.gegnerx, Var.gegnery, 11,
		 * 53); add(rightGamer);
		 */

		g.setFont(Var.pixelfont);
		g.setColor(Color.BLUE);
		g.drawString("" + Var.playerPoints, Var.screenwidth / 2 - 95, 75);
		g.setColor(Color.RED);
		g.drawString("" + Var.gegnerPoints, Var.screenwidth / 2 + 50, 75);
		g.setColor(Color.LIGHT_GRAY);
		g.fillOval(Var.ballx, Var.bally, 20, 20);

		repaint();

	}

}
