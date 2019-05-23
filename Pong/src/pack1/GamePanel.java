package pack1;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GamePanel extends JPanel {

	private int locationPlayer1Y = 185;
	private int Location_player2_y = 185;
	private int BallXLocation = 200;
	private int BallYLocation = 200;
	private int Diameter = 20;
	private int Radius = 10;

	public GamePanel() {
		final Image rightBarImage = new ImageIcon(this.getClass().getResource("/rechts.PNG")).getImage();

		JLabel rightGamer = new JLabel("New label");
		rightGamer.setIcon(new ImageIcon(rightBarImage));

		// rightGamer.setBounds(RIGHT_GAMER_BAR_X, y1, GAMER_BAR_WIDTH,
		// GAMER_BAR_HEIGHT);
		rightGamer.setBounds(1, 40, 30, 30);
		add(rightGamer);

		final Image leftBarImage = new ImageIcon(this.getClass().getResource("/links.PNG")).getImage();
		JLabel leftGamer = new JLabel("");
		leftGamer.setIcon(new ImageIcon(leftBarImage));
		// leftGamer.setBounds(10, y2, GAMER_BAR_WIDTH, GAMER_BAR_HEIGHT);
		rightGamer.setBounds(51, 40, 30, 30);
		add(leftGamer);
	}

	protected void paintComponent(Graphics g) {

		super.paintComponent(g);

		Graphics2D g2d = (Graphics2D) g;

		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, Properties.SCREEN_WIDTH, Properties.SCREEN_HEIGHT);

		g.setColor(Color.WHITE);
		g.setFont(new Font("TimesRoman", Font.PLAIN, 32));// right players score table properties
		g.drawString(Properties.player1Points + "      - ", Properties.SCREEN_WIDTH / 2 - 95, 75);// right players score
																									// table

		g.setFont(new Font("TimesRoman", Font.PLAIN, 32));// left players score table properties
		g.drawString("" + Properties.player2Points, Properties.SCREEN_WIDTH / 2 + 50, 75);// left players score table
		g.fillOval(BallXLocation, BallYLocation, Diameter, Diameter);

		Image leftBarImage = new ImageIcon(this.getClass().getResource("/links.PNG")).getImage();// left players
																									// bar

		JLabel leftGamer = new JLabel("New label");
		leftGamer.setIcon(new ImageIcon(leftBarImage));
		leftGamer.setBounds(Properties.LOCATION_PLAYER_X1, locationPlayer1Y, 11, 53);// 11 pixel width 53 pixel height
		add(leftGamer);

		Image rightBarImage = new ImageIcon(this.getClass().getResource("/rechts.PNG")).getImage();// right
																									// players

		JLabel rightGamer = new JLabel("New label");
		rightGamer.setIcon(new ImageIcon(rightBarImage));

		rightGamer.setBounds(Properties.location_player2_x, Location_player2_y, 11, 53);// 11 pixel width 53 pixel

		add(rightGamer);

	}

	public int getLocationPlayer1Y() {
		return locationPlayer1Y;
	}

	public void setLocationPlayer1Y(int locationPlayer1Y) {
		this.locationPlayer1Y = locationPlayer1Y;
	}

	public int getLocation_player2_y() {
		return Location_player2_y;
	}

	public void setLocation_player2_y(int location_player2_y) {
		Location_player2_y = location_player2_y;
	}

	public int getBallXLocation() {
		return BallXLocation;
	}

	public void setBallXLocation(int ballXLocation) {
		BallXLocation = ballXLocation;
	}

	public int getBallYLocation() {
		return BallYLocation;
	}

	public void setBallYLocation(int ballYLocation) {
		BallYLocation = ballYLocation;
	}

	public int getDiameter() {
		return Diameter;
	}

	public void setDiameter(int diameter) {
		Diameter = diameter;
	}

	public int getRadius() {
		return Radius;
	}

	public void setRadius(int radius) {
		Radius = radius;
	}

}
