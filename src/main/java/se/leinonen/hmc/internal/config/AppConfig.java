package se.leinonen.hmc.internal.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import se.leinonen.hmc.connectors.zwave.ZWaveConnector;

/**
 * Created by leinonen on 2016-03-31.
 */
@Configuration
public class AppConfig {

    @Bean(name = "zwaveConnector")
    public ZWaveConnector getZWaveConnector(
            @Value("${zwave.url}") String url,
            @Value("${zwave.username}") String username,
            @Value("${zwave.password}") String password) {
        return new ZWaveConnector(url, username, password);
    }
}
