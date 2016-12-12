package brightercircle.controller;

import java.util.Observable;
import java.util.Observer;

import brightercircle.model.Model;

public class Controller implements Observer {

	private final Model model;

	public Controller() {
		model = Model.getTheInstance();
		model.addObserver(this);

		run();
	}

	private void run() {
		Thread doSomethingThread = new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 200; i++) {
					model.brighter();
					try {
						Thread.sleep(20);
					} catch (InterruptedException e) {
					}
				}
			}

		});

		doSomethingThread.start();
	}

	@Override
	public void update(Observable o, Object arg) {
		System.out.println(String.format("Class %s sent me %s", o.getClass().getSimpleName(), arg));

	}

}