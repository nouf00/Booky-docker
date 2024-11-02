
package com.booky_bakend.contoller;

import com.booky_bakend.entity.book;
import com.booky_bakend.entity.list;
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
import com.booky_bakend.DAO.radingListDao;

import java.util.List;
@Data
@RestController
@RequestMapping(path = "/api/readinglist")
@RequiredArgsConstructor

public class addRedingListContoller {

 
    @Autowired
    private final radingListDao redinglistdao;

   

    @PostMapping("/add-to-list")
    public ResponseEntity<String> addReadinglist(@RequestParam("isbn") String isbn) {
        String result = redinglistdao.addBookToReadingList(isbn);
    
    if (result.equals("Book added successfully to the reading list.")) {
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    } else {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(result);
    }
}
    



  
  @GetMapping(path ="/get-list")
    public List<list> getallbooks(){
        return this.redinglistdao.getallbooks();
    }

 

}

