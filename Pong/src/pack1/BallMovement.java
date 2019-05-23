package pack1;

import java.util.Timer;
import java.util.TimerTask;

public class BallMovement {
	Timer move;

	public BallMovement() {
		move = new Timer();
		move.scheduleAtFixedRate(new TimerTask() {

			@Override
			public void run() {
				// Draw.BallXLocation += Properties.BALLDIRECTION_X;
				// Draw.BallYLocation += Properties.BALLDIRECTION_Y;

			}
		}, 0, 4);

	}
}
