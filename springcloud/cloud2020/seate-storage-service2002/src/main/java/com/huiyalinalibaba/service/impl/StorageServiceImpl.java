package com.huiyalinalibaba.service.impl;

import com.huiyalinalibaba.dao.StorageDao;
import com.huiyalinalibaba.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@Slf4j
public class StorageServiceImpl implements StorageService {

    @Resource
    private StorageDao storageDao;

    @Override
    public void decrease(Long productId, Integer count) {
        log.info("--------开始扣减数量");
        storageDao.decrease(productId,count);
        log.info("--------扣减完毕");
    }
}
