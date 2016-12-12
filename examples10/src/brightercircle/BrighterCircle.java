package brightercircle;

import brightercircle.controller.Controller;
import brightercircle.view.MainFrame;

public class BrighterCircle {

	public static void main(String[] args) {
		new MainFrame().setVisible(true);

		new Controller();
	}

}
