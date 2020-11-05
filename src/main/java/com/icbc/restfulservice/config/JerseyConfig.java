package com.icbc.restfulservice.config;


import com.icbc.restfulservice.controller.CorsFilter;
import com.icbc.restfulservice.controller.GetFileController;
import com.icbc.restfulservice.controller.HelloController;
import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;



@Component
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        register(HelloController.class);
        register(GetFileController.class);
        register(MultiPartFeature.class);
        register(CorsFilter.class);//解决跨域请求问题
    }
}