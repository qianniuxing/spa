package com.qianniuxing.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/order")
public interface OrderApi {

    @GetMapping("/orderToMember")
    String orderToMember();

}
