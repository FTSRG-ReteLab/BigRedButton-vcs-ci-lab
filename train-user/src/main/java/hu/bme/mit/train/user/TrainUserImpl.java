package hu.bme.mit.train.user;

import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainUser;

public class TrainUserImpl implements TrainUser {

	private TrainController controller;
	private int joystickPosition;
	private boolean alarmState;


	public TrainUserImpl(TrainController controller) {
		this.controller = controller;
	}

	@Override
	public boolean getAlarmFlag() {
		return false;
	}

	@Override
	public boolean getAlarmState() {
		return alarmState;
	}

	@Override
	public void setAlarmState(boolean alarmState) {
		this.alarmState = alarmState;
	}

	@Override
	public int getJoystickPosition() {
		return joystickPosition;
	}

	@Override
	public void overrideJoystickPosition(int joystickPosition) {
		this.joystickPosition = joystickPosition;
		controller.setJoystickPosition(joystickPosition);

		int tempspeed = controller.getReferenceSpeed();
		if(joystickPosition > 0){
			tempspeed += 10;
		}

		else{
			tempspeed -= 10;
		}


		final int speed = tempspeed;
		Thread t1 = new Thread(() -> {
			controller.setSpeedLimit(speed);
		});

		t1.start();
	}

}
