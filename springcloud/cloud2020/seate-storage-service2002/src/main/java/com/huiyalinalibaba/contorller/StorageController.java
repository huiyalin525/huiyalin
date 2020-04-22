package com.huiyalinalibaba.contorller;

import com.huiyalinalibaba.domain.CommonResult;
import com.huiyalinalibaba.service.StorageService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class StorageController {

    @Resource
    private StorageService storageService;

    @RequestMapping(value = "/storage/decrease")
    CommonResult decrease(@RequestParam("productId")Long productId, @RequestParam("count") Integer count){
        storageService.decrease(productId,count);
        return new CommonResult(200,"扣除订单数量成功"+count);
    }

}
