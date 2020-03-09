package com.qianniuxing.filter;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * 网关过滤器解决跨域问题
 */
@Component
public class CrossOriginFilter implements GlobalFilter {

    /**
     * 这里为支持的请求头，如果有自定义的header字段请自己添加
     */
//    private static final String ALLOWED_HEADERS = "X-Requested-With, Tenant-Id, kc-Auth, Content-Type, Authorization, credential, X-XSRF-TOKEN, token, username, client";
    private static final String ALLOWED_HEADERS = "*";
    private static final String ALLOWED_METHODS = "GET,POST,PUT,DELETE,OPTIONS,HEAD";
    private static final String ALLOWED_ORIGIN = "*";
    private static final String ALLOWED_EXPOSE = "*";
    private static final String MAX_AGE = "18000L";
    private static final String ALLOW_CREDENTIALS = "true";

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpResponse response = exchange.getResponse();
        HttpHeaders headers = response.getHeaders();
        headers.add(HttpHeaders.ACCESS_CONTROL_ALLOW_HEADERS, this.ALLOWED_HEADERS);
        headers.add(HttpHeaders.ACCESS_CONTROL_ALLOW_METHODS, this.ALLOWED_METHODS);
        headers.add(HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN, this.ALLOWED_ORIGIN);
        headers.add(HttpHeaders.ACCESS_CONTROL_EXPOSE_HEADERS, this.ALLOWED_EXPOSE);
        headers.add(HttpHeaders.ACCESS_CONTROL_MAX_AGE, this.MAX_AGE);
        headers.add(HttpHeaders.ACCESS_CONTROL_ALLOW_CREDENTIALS, this.ALLOW_CREDENTIALS);
        return chain.filter(exchange);
    }


}
