package com.booky_bakend.DAO;
import com.booky_bakend.entity.book;
import com.booky_bakend.entity.list;
import  com.booky_bakend.repositry.bookrepo;
import com.booky_bakend.repositry.listRepo;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.booky_bakend.DAO.mainBookDao;

import java.util.List;
@Service
@AllArgsConstructor
public class radingListDao {

    @Autowired
    private final bookrepo booksrepo;
    private final listRepo listrepo;


    
    public String addBookToReadingList(String isbn) {
        try{
        book existingBook = booksrepo.findById(isbn).orElse(null);

        if (existingBook != null) {
            list readingList = new list();
            readingList.setIsbn(existingBook.getIsbn());
            readingList.setTitle(existingBook.getTitle());
            readingList.setAuthor(existingBook.getAuthor());
            readingList.setNumberPage(existingBook.getNumberPage());
            readingList.setCover(existingBook.getCover());

            listrepo.save(readingList);
            return "Book added successfully to the reading list.";
        } else {
            return "Book not found";
        }} 
        
        
        catch  (Exception e) {
            return "An error occurred: " + e.getMessage();
        }
    }

        public List<list> getallbooks(){
            return this.listrepo.findAll();
        }
    
    
    }
    
