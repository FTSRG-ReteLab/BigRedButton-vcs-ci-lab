package hu.bme.mit.train.tachograph;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.system.TrainSystem;

import java.util.Date;

/**
 * Created by meres on 2/26/18.
 */
public class TrainTachograph {

    Table<Long,Integer, Integer> tachoData = HashBasedTable.create();
    TrainSystem system = new TrainSystem();


    public TrainTachograph(){
        TrainController controller = system.getController();

        tachoData.put(System.currentTimeMillis() ,system.getUser().getJoystickPosition(), controller.getReferenceSpeed());
    }

    public int getTachoDataSize(){
        return tachoData.size();
    }


}
