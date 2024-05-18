package org.gfg.jbdlMinor.repository;

import org.gfg.jbdlMinor.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AuthorRepository extends JpaRepository<Author,Integer> {

    //1st way of writing query
    @Query(value = "select * from author where email=:email",nativeQuery = true) //mysql
    Author getAuthor(String email);

    //2nd way of writing query
    @Query("select a from Author a where a.email=:email") //hibernate
    Author getAuthorWithoutNative(String email);

    //3rd way of writing query
    Author findByEmail(String email);


}
