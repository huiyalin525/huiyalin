package com.huiyalincloudalibaba.service;

import com.huiyalincloudalibaba.domain.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
//利用open直接对其进行操作如果没有这个的话还得用RestTemplate先注册进服务利用服务名转发
@FeignClient(value = "seata-storage-service")
public interface StorageService {
    @PostMapping(value = "/storage/decrease")
    CommonResult decrease(@RequestParam("productId")Long productId,@RequestParam("count") Integer count);

}
