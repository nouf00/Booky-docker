package com.booky_bakend.repositry;

import com.booky_bakend.entity.list;
import com.booky_bakend.entity.book;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository

public interface listRepo extends JpaRepository<list , String> {

}
