package se.leinonen.hmc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;
import se.leinonen.hmc.connectors.zwave.ZWaveService;
import se.leinonen.hmc.domain.Device;
import se.leinonen.hmc.services.DeviceService;

import java.util.List;

/**
 * Created by leinonen on 2016-03-30.
 */
@RestController
public class DeviceController {
    @Autowired
    private DeviceService deviceService;

    @RequestMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public DeferredResult<ResponseEntity<List<Device>>> index() {
        DeferredResult<ResponseEntity<List<Device>>> deferredResult = new DeferredResult<>();

        List<Device> devices = deviceService.getDevices()
                .toList().toBlocking().first();

        deferredResult.setResult(ResponseEntity.accepted().body(devices));

        return deferredResult;
    }
}
