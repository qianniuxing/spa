package com.qianniuxing.filter;

import org.apache.commons.lang.StringUtils;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * 全局过滤器
 */
@Component
public class TokenGlobalFilter implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        //如何获取参数呢？
//        String token = exchange.getRequest().getQueryParams().getFirst("token");
//        if (StringUtils.isEmpty(token)) {
//            ServerHttpResponse response = exchange.getResponse();
//            response.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR);
//            String msg = "token not is null ";
//            DataBuffer buffer = response.bufferFactory().wrap(msg.getBytes());
//            return response.writeWith(Mono.just(buffer));
//        }
        // 直接转发到我们真实服务
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 0;
    }


}
