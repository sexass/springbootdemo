package com.example.demo;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by vortex on 2017/7/12.
 */
public interface BookDao extends JpaRepository<Book,Integer> {
    List<Book> findById(int id);
}
