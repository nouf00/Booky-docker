package com.booky_bakend.repositry;
import com.booky_bakend.entity.book;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository


public interface bookrepo extends JpaRepository<book , String> {


    book findByisbn(String isbn );

}