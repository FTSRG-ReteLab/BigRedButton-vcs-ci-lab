package hu.bme.mit.train.user;

import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainUser;

import java.util.Timer;
import java.util.TimerTask;

public class TrainUserImpl implements TrainUser {

	private TrainController controller;
	private int joystickPosition;

	public TrainUserImpl(TrainController controller) {
		this.controller = controller;
	}

	@Override
	public boolean getAlarmFlag() {
		return false;
	}

	@Override
	public int getJoystickPosition() {
		return joystickPosition;
	}

	@Override
	public void overrideJoystickPosition(int joystickPosition) {
		this.joystickPosition = joystickPosition;

		Timer timer = new Timer();
		int delay = 2000;

		if(joystickPosition > 0){
			timer.schedule(new TimerTask() {
				@Override
				public void run() {
					controller.setSpeedLimit(controller.getReferenceSpeed()+5);
				}
			}, delay);

		} else if (joystickPosition < 0) {
			timer.schedule(new TimerTask() {
				@Override
				public void run() {
					controller.setSpeedLimit(controller.getReferenceSpeed()-5);
				}
			}, delay);
		}


	}

}
