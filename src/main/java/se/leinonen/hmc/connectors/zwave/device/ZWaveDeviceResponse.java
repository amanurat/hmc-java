package se.leinonen.hmc.connectors.zwave.device;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by leinonen on 2016-03-31.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ZWaveDeviceResponse {
    private Integer code;
    private String message;
    private String error;
    private ZWaveDeviceResponseData data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public ZWaveDeviceResponseData getData() {
        return data;
    }

    public void setData(ZWaveDeviceResponseData data) {
        this.data = data;
    }
}
