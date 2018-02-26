package hu.bme.mit.train.tachograph.test;

import hu.bme.mit.train.tachograph.TrainTachograph;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
/**
 * Created by meres on 2/26/18.
 */
public class TrainTachographTest {

    TrainTachograph tachograph;

    @Before
    public void before() {
        tachograph = new TrainTachograph();
    }

    @Test
    public void TachographTest(){
        Assert.assertEquals(1, tachograph.getTachoDataSize());
    }

}