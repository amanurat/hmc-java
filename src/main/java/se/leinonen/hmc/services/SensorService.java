package se.leinonen.hmc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rx.Observable;
import se.leinonen.hmc.connectors.zwave.ZWaveService;
import se.leinonen.hmc.domain.Device;
import se.leinonen.hmc.domain.Sensor;


/**
 * Created by leinonen on 2016-03-30.
 */
@Service
public class SensorService {

    @Autowired
    private ZWaveService zwave;

    public Observable<Sensor> getSensors() {
        return zwave.getSensors();
    }

}
