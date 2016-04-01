package se.leinonen.hmc.connectors.zwave.device;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by leinonen on 2016-03-31.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ZWaveDeviceMetrics {
    private String title;
    private String probeTitle;
    private String scaleTitle;
    private String level;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getProbeTitle() {
        return probeTitle;
    }

    public void setProbeTitle(String probeTitle) {
        this.probeTitle = probeTitle;
    }

    public String getScaleTitle() {
        return scaleTitle;
    }

    public void setScaleTitle(String scaleTitle) {
        this.scaleTitle = scaleTitle;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
}
