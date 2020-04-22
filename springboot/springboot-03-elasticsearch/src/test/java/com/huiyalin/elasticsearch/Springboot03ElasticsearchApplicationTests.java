package com.huiyalin.elasticsearch;

import com.huiyalin.elasticsearch.bean.Book;
import com.huiyalin.elasticsearch.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Springboot03ElasticsearchApplicationTests {

    @Autowired
    BookRepository bookRepository;

    @Test
    void contextLoads() {
        Book book=new Book();
        bookRepository.index(book);
    }

}
