package com.qianniuxing.controller;

import com.qianniuxing.api.UserApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RefreshScope
@RestController
public class UserController implements UserApi {

    @Value("${company.name}")
    private String company_name;

    @Value("${server.port}")
    private String server_port;


    @Override
    public Map getName() {
        Map map = new HashMap();
        map.put("company_name", this.company_name);
        map.put("server_port", this.server_port);
        return map;
    }


}
