package pack1;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {

		if (e.getKeyCode() == KeyEvent.VK_UP) {
			Var.move_up = true;
		} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			Var.move_down = true;
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {

		if (e.getKeyCode() == KeyEvent.VK_UP) {
			Var.move_up = false;
		} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			Var.move_down = false;
		}

	}

}
