package com.qianniuxing.openfeign.member;

import com.qianniuxing.api.UserApi;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("member")
public interface UserOpenfeign extends UserApi {
}
