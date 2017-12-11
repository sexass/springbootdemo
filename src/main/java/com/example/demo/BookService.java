package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;


/**
 * Created by vortex on 2017/7/13.
 */
@Service
public class BookService {
    @Autowired
    BookDao bookDao;


    @Cacheable(value = "book",key = "#id+''")
    public Book getOne(int id){
        Book book=bookDao.findById(id).get(0);
        System.out.print("执行一数据库查询");
        return book;
    }

    @CachePut(value = "book",key="#book.id+''")
    public Book saveBook(Book book){
        Book b=bookDao.save(book);
        System.out.print("缓存了author是"+b.getAuthor()+"，name是"+b.getName()+"的书");
        return b;
    }
}
