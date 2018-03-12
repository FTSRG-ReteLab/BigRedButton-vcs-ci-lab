package hu.bme.mit.train.user;

import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainUser;

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
		controller.setJoystickPosition(joystickPosition);

		int _speed = controller.getReferenceSpeed();
		if(joystickPosition < 0){
			_speed += 5;
		}

		else{
			_speed -= 5;
		}


		final int speed = _speed;
		Thread t1 = new Thread(() -> {
			controller.setSpeedLimit(speed);
		});

		t1.start();
	}

}
