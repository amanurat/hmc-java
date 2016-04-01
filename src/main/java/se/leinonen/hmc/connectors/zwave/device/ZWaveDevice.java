package se.leinonen.hmc.connectors.zwave.device;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by leinonen on 2016-03-31.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ZWaveDevice {
    private String deviceType;
    private String id;
    private ZWaveDeviceMetrics metrics;

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ZWaveDeviceMetrics getMetrics() {
        return metrics;
    }

    public void setMetrics(ZWaveDeviceMetrics metrics) {
        this.metrics = metrics;
    }
}
