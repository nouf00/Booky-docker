package com.booky_bakend.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name ="list")
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class list {


    
    @Id
    @Column(name="id")
    private String isbn ;

    @Column(name="title")
    private String title ;


    @Column(name="author")
    private String author ;

    @Column(name="number_page")
    private int numberPage;


    @Column(name="cover")
    private String cover;


}