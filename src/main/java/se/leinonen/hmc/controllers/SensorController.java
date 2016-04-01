package se.leinonen.hmc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;
import se.leinonen.hmc.domain.Sensor;
import se.leinonen.hmc.services.SensorService;

import java.util.List;

/**
 * Created by leinonen on 2016-03-30.
 */
@RestController
public class SensorController {
    @Autowired
    private SensorService sensorService;

    @RequestMapping(value = "/sensors", produces = MediaType.APPLICATION_JSON_VALUE)
    public DeferredResult<ResponseEntity<List<Sensor>>> index() {
        DeferredResult<ResponseEntity<List<Sensor>>> deferredResult = new DeferredResult<>();

        List<Sensor> sensors = sensorService.getSensors().toList().toBlocking().first();

        deferredResult.setResult(ResponseEntity.accepted().body(sensors));

        return deferredResult;
    }
}
