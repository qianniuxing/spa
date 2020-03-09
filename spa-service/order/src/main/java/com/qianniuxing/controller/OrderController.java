package com.qianniuxing.controller;

import com.alibaba.fastjson.JSONObject;
import com.qianniuxing.api.OrderApi;
import com.qianniuxing.openfeign.member.UserOpenfeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController implements OrderApi {

    @Autowired
    private UserOpenfeign UserOpenfeign;

    @Override
    public String orderToMember() {
        JSONObject result = (JSONObject) JSONObject.toJSON(this.UserOpenfeign.getName());
        return "订单调用会员服务。会员服务端口：" +result.getString("server_port")+ "，名称：" +result.getString("company_name");
    }



}
