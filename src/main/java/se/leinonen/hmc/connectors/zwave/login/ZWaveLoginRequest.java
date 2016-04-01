package se.leinonen.hmc.connectors.zwave.login;

/**
 * Created by leinonen on 2016-03-30.
 */
public class ZWaveLoginRequest {
    private String login;
    private String password;

    public ZWaveLoginRequest(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
