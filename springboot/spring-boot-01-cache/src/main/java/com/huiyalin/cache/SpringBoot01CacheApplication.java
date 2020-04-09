package com.huiyalin.cache;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 *  搭建基本环境
 *   1、导入数据库文件 创建出department和employee
 *   2、创建javaBean封装数据
 *   3、整合mybatis操作数据库
 *      1.配置数据源
 *      2.使用注解版的mybatis；
 *              1).@MapperScan指定需要扫描的mapper接口所在的包
 *  快速体验缓存
 *    步骤：
 *       1、开启基于注解的缓存@EnableCaching
 *       2、标注缓存注解即可
 *              @Cacheable
 *              @CacheEvict
 *              @CachePut
 *  ConcurrentMapCacheManager==ConcurrentMapCache;将数据保存在ConcurrentMap<Object,Object>
 *  开发中使用缓存中间件：redis、memcahed、ehcache
 *  三、整合redis作为缓存
 *  Redis是一个开源(BSD许可)的，内存中的数据结构存储结构，它可以用作数据库、缓存和消息中间件
 *  1、安装redis
 *  2、引入redis的starter
 *  3、配置redis
 *  4、测试缓存
 *       原理：CacheManager===Cache缓存组件来实际给缓存中存取数据
 *       1)、引入redis的stater，容器中保存的是RedisCacheManager;
 *       2)、RedisCacheManager 帮我们创建RedisCache来作为缓存组件；RedisCache通过redis缓存数据的
 *       3)、默认保存数据k-v都是object；利用序列化保存；如何保存为json
 *              1、引入了redis的starter、cacheManager变为RedisCacheManager
 *              2、默认创建的RedisCacheManager 操作redis的时候是使用的是RedisTemplate<Object,Object>
 *              3、RedisTemplate<Object,Object>是默认使用的jdk的序列化机制
 *       4)、自定义CacheManager;
 */
@MapperScan(value ="com.huiyalin.cache.mapper")
@SpringBootApplication
@EnableCaching
public class SpringBoot01CacheApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBoot01CacheApplication.class, args);
    }

}
