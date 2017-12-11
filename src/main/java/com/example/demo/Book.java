package com.example.demo;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by vortex on 2017/7/11.
 */
@Entity
public class Book implements Serializable{
    @Id
    @GeneratedValue
    private int id;

    private String author;

    private String name;

    public Book() {
    }

    public Book(int id,String author, String name) {
        this.author = author;
        this.name = name;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
