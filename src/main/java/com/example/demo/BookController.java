package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by vortex on 2017/7/12.
 */
@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private BookRedisDao bookRedisDao;

    @RequestMapping(value = "/hi",method = RequestMethod.GET)
    String index(int id){
        Book book=bookService.getOne(id);
        return book.getAuthor()+":"+book.getName();
    }

    @RequestMapping(value="/save")
    String save(Book book){
        Book book1=bookService.saveBook(book);
        return book1.getAuthor()+" : "+book1.getName();
    }
    @RequestMapping(value="/saveinredis")
    String save(){
        Book book=new Book(1,"t","c");
        bookRedisDao.save(book);
        return "save book "+book.getName();
    }

    @RequestMapping(value = "/getbookinredis")
    String getBookInRedis(){
        Book book=bookRedisDao.getBook();
        return book.getAuthor()+":"+book.getName();
    }
}
