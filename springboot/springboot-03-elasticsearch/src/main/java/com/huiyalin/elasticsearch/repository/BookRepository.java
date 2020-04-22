package com.huiyalin.elasticsearch.repository;

import com.huiyalin.elasticsearch.bean.Book;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.data.elasticsearch.repository.ReactiveElasticsearchRepository;

public interface BookRepository extends ElasticsearchRepository<Book,Integer> {

    }
