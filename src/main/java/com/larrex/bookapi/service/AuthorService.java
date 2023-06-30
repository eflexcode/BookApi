package com.larrex.bookapi.service;

import com.larrex.bookapi.model.Author;
import com.larrex.bookapi.model.AuthorModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AuthorService {

    Author createAuthor(AuthorModel author);

    Author readAuthor(Long id);

    Page<Author> readAuthors(Pageable pageable);

    Page<Author> readAuthorByName(String name,Pageable pageable);

    Author updateAuth(AuthorModel author, Long id);

    void  deleteAuthor(Long id);

}
