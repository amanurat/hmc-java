package se.leinonen.hmc.connectors.zwave.login;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by leinonen on 2016-03-30.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ZWaveLoginResponse {
    private Integer code;
    private String message;
    private ZWaveLoginResponseData data;

    public ZWaveLoginResponse() {
    }

    public ZWaveLoginResponse(Integer code) {
        this.code = code;
    }

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

    public ZWaveLoginResponseData getData() {
        return data;
    }

    public void setData(ZWaveLoginResponseData data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return String.format("[code=%d, message=%s, data.sid=%s]",
                code, message, data.getSid());
    }
}
