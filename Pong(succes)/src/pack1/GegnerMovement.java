package pack1;

import java.util.Timer;
import java.util.TimerTask;

public class GegnerMovement {
	Timer move;

	public GegnerMovement() {
		move = new Timer();
		move.scheduleAtFixedRate(new TimerTask() {

			@Override
			public void run() {

				if (Var.moveupgegner == true) {

					if (Var.gegnery >= 0) {
						Var.gegnery -= 2;
					}
				} else if (Var.movedowngegner == true) {

					if (Var.gegnery <= Var.screenheight - 95) {
						Var.gegnery += 2;
					}
				}

			}

		}, 0, 6);
	}

}
