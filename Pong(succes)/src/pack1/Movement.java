package pack1;

import java.util.Timer;
import java.util.TimerTask;

public class Movement {
	Timer move;

	public Movement() {
		move = new Timer();
		move.scheduleAtFixedRate(new TimerTask() {

			@Override
			public void run() {

				if (Var.moveup == true) {

					if (Var.y >= 0) {
						Var.y -= 2;
					}
				} else if (Var.movedown == true) {

					if (Var.y <= Var.screenheight - 95) {
						Var.y += 2;
					}
				}

			}

		}, 0, 6);
	}

}
