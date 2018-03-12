package hu.bme.mit.train.sensor;

import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainUser;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import static org.mockito.Mockito.*;

public class TrainSensorTest {

    TrainSensorImpl trainSensor;
    TrainController controller;
    TrainUser user;

    @Before
    public void before() {

        controller =  mock(TrainController.class);
        user = mock(TrainUser.class);

        trainSensor = new TrainSensorImpl(controller, user);
    }

    @Test
    public void ThisIsAnExampleTestStub() {
        // TODO Delete this and add test cases based on the issues
    }

    @Test
    public void AbsoluteMarginMin() {
        int speed = -5;

        when(user.getAlarmState()).thenReturn(true);
        trainSensor.overrideSpeedLimit(speed);

        Assert.assertEquals(trainSensor.isUserAlarm(), true);
    }


    @Test
    public void AbsoluteMarginNormal() {
        int speed = 250;

        when(user.getAlarmState()).thenReturn(false);
        trainSensor.overrideSpeedLimit(speed);

        Assert.assertEquals(trainSensor.isUserAlarm(), false);
    }


    @Test
    public void AbsoluteMarginMax() {
        int speed = 550;

        when(user.getAlarmState()).thenReturn(true);
        trainSensor.overrideSpeedLimit(speed);

        Assert.assertEquals(trainSensor.isUserAlarm(), true);
    }


    @Test
    public void AbsoluteMarginRel() {
        int speed = 1;

        when(user.getAlarmState()).thenReturn(true);
        when(controller.getReferenceSpeed()).thenReturn(120);

        trainSensor.overrideSpeedLimit(speed);

        Assert.assertEquals(trainSensor.isUserAlarm(), true);
    }
}
