package se.leinonen.hmc.connectors.zwave;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import se.leinonen.hmc.connectors.zwave.login.ZWaveLoginRequest;
import se.leinonen.hmc.connectors.zwave.login.ZWaveLoginResponse;

import java.util.Collections;
import java.util.Map;

/**
 * Created by leinonen on 2016-03-30.
 */
@Service
public class ZWaveConnector {

    public static final String DEVICE_PATH = "/ZAutomation/api/v1/devices";
    public static final String LOGIN_PATH = "/ZAutomation/api/v1/login";

    private String sessionId = null;
    private String endpoint;
    private String username;
    private String password;

    private ZWaveConnector() {}

    public ZWaveConnector(String url, String username, String password) {
        System.out.println(String.format("ZWaveConnector created with url: %s and username: %s", url, username));
        this.endpoint = url;
        this.username = username;
        this.password = password;
    }


    public ResponseEntity<Map<String, Object>> doGet(String resource) {
        updateSessionIdentifier();

        ParameterizedTypeReference<Map<String, Object>> typeRef = new ParameterizedTypeReference<Map<String, Object>>() {};
        HttpHeaders headers = new HttpHeaders();
        //headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.set("Cookie", "ZWAYSession=" + sessionId);
        HttpEntity entity = new HttpEntity(null, headers);
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.exchange(endpoint + resource, HttpMethod.GET, entity, typeRef);
    }

    private void updateSessionIdentifier() {
        if (sessionId == null) {
            ZWaveLoginResponse loginResponse = login();
            if (loginResponse.getCode() == 200 && loginResponse.getData() != null) {
                sessionId = loginResponse.getData().getSid();
            }
        }
    }

    private ZWaveLoginResponse login() {
        HttpEntity<ZWaveLoginRequest> request = new HttpEntity<>(new ZWaveLoginRequest(username, password));
        try {
            ParameterizedTypeReference<Map<String, Object>> typeRef = new ParameterizedTypeReference<Map<String, Object>>() {};
            RestTemplate restTemplate = new RestTemplate();
            return getLoginResponse(restTemplate.exchange(endpoint + LOGIN_PATH, HttpMethod.POST, request, typeRef));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ZWaveLoginResponse(401);
        }
    }

    private ZWaveLoginResponse getLoginResponse(ResponseEntity<Map<String, Object>> response) {
        return new ObjectMapper().convertValue(response.getBody(), ZWaveLoginResponse.class);
    }
}
