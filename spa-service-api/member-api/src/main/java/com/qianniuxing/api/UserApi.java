package com.qianniuxing.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@RequestMapping("/user")
public interface UserApi {

    @GetMapping("/getName")
    Map getName();

}
