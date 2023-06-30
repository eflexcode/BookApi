package com.larrex.bookapi.repository;

import com.larrex.bookapi.model.Author;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author,Long> {

    Page<Author> findByName(String name,Pageable pageable);

}
