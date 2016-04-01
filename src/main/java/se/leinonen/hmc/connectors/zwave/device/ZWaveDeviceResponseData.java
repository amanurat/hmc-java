package se.leinonen.hmc.connectors.zwave.device;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

/**
 * Created by leinonen on 2016-03-31.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ZWaveDeviceResponseData {
    private List<ZWaveDevice> devices;

    public List<ZWaveDevice> getDevices() {
        return devices;
    }

    public void setDevices(List<ZWaveDevice> devices) {
        this.devices = devices;
    }
}
