package se.leinonen.hmc.connectors.zwave.login;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by leinonen on 2016-03-31.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ZWaveLoginResponseData {
    private String sid;
    private String name;

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

/*
{data={sid=34e08b82-c1e5-f485-7a8f-69ee9aae212e, id=1, role=1, name=Administrator, lang=en, color=#dddddd, dashboard=[], interval=2000, rooms=[0], hide_all_device_events=false, hide_system_events=false, hide_single_device_events=[], expert_view=true}, code=200, message=200 OK, error=null}

* */