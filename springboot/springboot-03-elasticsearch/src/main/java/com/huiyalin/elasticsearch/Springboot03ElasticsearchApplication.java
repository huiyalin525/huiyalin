package com.huiyalin.elasticsearch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *  SpringBoot默认支持两种技术来和ES交互
 *  1、Jest (默认不生效)
 *  2、SpringData ElasticSearch
 *      1）TransportClient节点信息； clusterNodes clusterName
 *      2）ReactiveElasticsearchTemplate 操作ES
 *      3）编写一个ReactiveElasticsearchRepository的子接口来操作ES
 */
@SpringBootApplication
public class Springboot03ElasticsearchApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springboot03ElasticsearchApplication.class, args);
    }

}
