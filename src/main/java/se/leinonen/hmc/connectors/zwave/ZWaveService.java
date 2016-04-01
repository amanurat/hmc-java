package se.leinonen.hmc.connectors.zwave;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import rx.Observable;
import se.leinonen.hmc.connectors.zwave.device.ZWaveDevice;
import se.leinonen.hmc.connectors.zwave.device.ZWaveDeviceResponse;
import se.leinonen.hmc.domain.Device;
import se.leinonen.hmc.domain.Sensor;

import java.util.*;

/**
 * Created by leinonen on 2016-03-30.
 */
@Service
public class ZWaveService {

    @Autowired
    @Qualifier("zwaveConnector")
    private ZWaveConnector connector;

    @Autowired
    private ObjectMapper objectMapper;

    public Observable<Device> getDevices() {
        ResponseEntity<Map<String, Object>> resp = connector.doGet(connector.DEVICE_PATH);
        ZWaveDeviceResponse response = objectMapper.convertValue(resp.getBody(), ZWaveDeviceResponse.class);
        return Observable
                .from(response.getData().getDevices())
                .filter(device ->  isDevice(device))
                .map(device -> convertDevice(device));
    }

    public Observable<Sensor> getSensors() {
        ResponseEntity<Map<String, Object>> resp = connector.doGet(connector.DEVICE_PATH);
        ZWaveDeviceResponse response = objectMapper.convertValue(resp.getBody(), ZWaveDeviceResponse.class);
        return Observable
                .from(response.getData().getDevices())
                .filter(device ->  isSensor(device))
                .map(device -> convertSensor(device));
    }

    private Boolean isDevice(ZWaveDevice device) {
        return "switchBinary".equals(device.getDeviceType());
    }

    private Boolean isSensor(ZWaveDevice device) {
        return "sensorMultilevel".equals(device.getDeviceType());
    }

    private Device convertDevice(ZWaveDevice source) {
        Device device = new Device();
        device.setName(source.getMetrics().getTitle());
        device.setId(source.getId());
        device.setType(source.getDeviceType());
        device.setLevel(source.getMetrics().getLevel());
        return device;
    }

    private Sensor convertSensor(ZWaveDevice source) {
        Sensor sensor = new Sensor();
        sensor.setTitle(source.getMetrics().getTitle());
        sensor.setId(source.getId());
        sensor.setType(source.getDeviceType());
        sensor.setLevel(source.getMetrics().getLevel());
        sensor.setProbeTitle(source.getMetrics().getProbeTitle());
        sensor.setScaleTitle(source.getMetrics().getScaleTitle());
        return sensor;
    }
}
