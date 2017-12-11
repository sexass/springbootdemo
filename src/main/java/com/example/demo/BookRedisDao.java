package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;


/**
 * Created by vortex on 2017/7/14.
 */
@Repository
public class BookRedisDao {

    @Autowired
    RedisTemplate<Object,Object> redisTemplate;

    @Resource(name="redisTemplate")
    ValueOperations<Object,Object> valOps;

    public Book save(Book book){
        valOps.set(book.getId()+"",book);
        return book;
    }

    public Book getBook(){
        return (Book) valOps.get("1");
    }

}
