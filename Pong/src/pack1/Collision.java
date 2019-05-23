package pack1;

import java.util.Timer;
import java.util.TimerTask;

public class Collision {
	Timer collision;

	public Collision() {
		collision = new Timer();
		collision.scheduleAtFixedRate(new TimerTask() {

			@Override
			public void run() {

			}

		}, 0, 4);

	}

}
