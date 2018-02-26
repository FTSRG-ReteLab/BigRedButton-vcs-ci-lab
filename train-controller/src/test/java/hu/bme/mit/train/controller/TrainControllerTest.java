package hu.bme.mit.train.controller;

import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainSensor;
import hu.bme.mit.train.interfaces.TrainUser;
import hu.bme.mit.train.system.TrainSystem;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TrainControllerTest {

	TrainController controller;
	TrainSensor sensor;

	@Before
	public void before() {
		TrainSystem system = new TrainSystem();
		controller = system.getController();
		sensor = system.getSensor();
	}
	
	@Test
	public void CheckSetSpeedLimit() {
		controller.setSpeedLimit(-50);
		Assert.assertEquals(0, controller.getReferenceSpeed());

		controller.setSpeedLimit(15);
		Assert.assertEquals(0, controller.getReferenceSpeed());
	}




	
}
