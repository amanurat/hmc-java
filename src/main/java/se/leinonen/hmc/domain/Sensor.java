package se.leinonen.hmc.domain;

/**
 * Created by leinonen on 2016-03-30.
 */
public class Sensor {
    private String id;
    private String type;
    private String level;
    private String probeTitle;
    private String scaleTitle;
    private String title;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getProbeTitle() {
        return probeTitle;
    }

    public void setProbeTitle(String probeTitle) {
        this.probeTitle = probeTitle;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getScaleTitle() {
        return scaleTitle;
    }

    public void setScaleTitle(String scaleTitle) {
        this.scaleTitle = scaleTitle;
    }
}
