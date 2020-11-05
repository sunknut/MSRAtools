package com.icbc.restfulservice.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ServerInfo {
    @Value("${server.port}")
    private String port;
    @Value("${server.address}")
    private String serverIp;

    public String getServerIp() {
        return serverIp;
    }

    public String getPort() {
        return port;
    }
}
