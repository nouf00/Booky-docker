package com.booky_bakend.contoller;

import com.booky_bakend.entity.book;
import com.booky_bakend.services.bookService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import com.booky_bakend.entity.book;
import com.booky_bakend.repositry.*;
import com.booky_bakend.DAO.mainBookDao;

import java.util.List;
import java.util.Optional;

@Data
@RestController
@RequestMapping(path = "/api/newbook")
@RequiredArgsConstructor

public class AddMainBookController {

    @Autowired
    private final bookService bookService;
    @Autowired
    private final mainBookDao mainbookdao;
@Autowired
    private final bookrepo bookrepos;

    @PostMapping("/addbook")
    public ResponseEntity<String> addMainBook(@RequestParam("isbn") String isbn) {
        String result = bookService.process(isbn);

    
        if (result.equals("Book added successfully to the reading list.")) {
            return ResponseEntity.status(HttpStatus.CREATED).body(result);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(result);
        }
    }

       
  @GetMapping(path ="/books")
    public List<book> getallbooks(){
        return this.mainbookdao.getallbooks();
    }

    @GetMapping(path ="/book")
    public book getbook(@RequestParam String isbn){
        return this.mainbookdao.getbooks(isbn);
    }
   /*  @GetMapping
    public ResponseEntity getBooks(){
        return ResponseEntity.status(200).body(bookrepos.findAll());
    }*/

}

