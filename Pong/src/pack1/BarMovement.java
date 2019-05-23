package pack1;

import java.util.Timer;
import java.util.TimerTask;

public class BarMovement {
	Timer move;

	public BarMovement(GamePanel gamePanel) {
		move = new Timer();
		move.scheduleAtFixedRate(new TimerTask() {

			@Override
			public void run() {
				if (Properties.move_up == true) {
					if (gamePanel.getLocationPlayer1Y() > 20) {
						gamePanel.setLocationPlayer1Y(gamePanel.getLocationPlayer1Y() - 5);
					} else if (Properties.move_down == true) {

						if (gamePanel.getLocationPlayer1Y() <= Properties.SCREEN_HEIGHT - 20) {
							gamePanel.setLocationPlayer1Y(gamePanel.getLocationPlayer1Y() + 5);
						}
					}

				}
				gamePanel.repaint();
			};

		}, 0, 6);

	}
}
