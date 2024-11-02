package com.booky_bakend.services;

import com.booky_bakend.entity.*;
import com.booky_bakend.model.*;
import com.booky_bakend.repositry.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.context.annotation.Bean;

@Service
public class bookService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private final bookrepo booksrepo;

    public bookService(bookrepo booksrepo) {

        this.booksrepo = booksrepo;
    }
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public String process (String isbn){
        try {
    String isbnUrl = "https://openlibrary.org/isbn/" + isbn + ".json";
        BookRespons bookResponse = restTemplate.getForObject(isbnUrl, BookRespons.class);

        if (bookResponse != null) {
        book books = new book();
            books.setIsbn(bookResponse.getIsbn_10() != null && !bookResponse.getIsbn_10().isEmpty() ? bookResponse.getIsbn_10().get(0) : "Unknown ISBN");
            books.setTitle(bookResponse.getTitle());
            books.setAuthor(getAuthorName(bookResponse));
            books.setNumberPage(bookResponse.getNumber_of_pages());
            books.setCover(bookResponse.getCovers() != null && !bookResponse.getCovers().isEmpty() ? "https://covers.openlibrary.org/b/id/" + bookResponse.getCovers().get(0) + "-M.jpg" : null);
            booksrepo.save(books); 
    } return "Book added successfully.";

}  catch  (Exception e) {
        return "An error occurred: " + e.getMessage();
    }

}


private String getAuthorName(BookRespons bookResponse) {
    if (bookResponse.getAuthors() != null && !bookResponse.getAuthors().isEmpty()) {
        String olid = bookResponse.getAuthors().get(0).getOLID();
        String authorUrl = "https://openlibrary.org/authors/" + olid + ".json";
        AuthorResponse authorResponse = restTemplate.getForObject(authorUrl, AuthorResponse.class);
        return authorResponse != null ? authorResponse.getName() : "Unknown author";
    }
    return null;
}
}





