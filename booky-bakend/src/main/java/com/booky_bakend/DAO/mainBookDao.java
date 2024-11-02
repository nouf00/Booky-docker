package com.booky_bakend.DAO;
import com.booky_bakend.entity.book;
import  com.booky_bakend.repositry.bookrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class mainBookDao {

@Autowired
private final bookrepo booksrepo;

    public mainBookDao(bookrepo booksrepo) {
        this.booksrepo = booksrepo;
    }


    public List<book> getallbooks(){
        return this.booksrepo.findAll();
    }


    public book getbooks(String isbn){
        return this.booksrepo.findByisbn(isbn);

    }


}
