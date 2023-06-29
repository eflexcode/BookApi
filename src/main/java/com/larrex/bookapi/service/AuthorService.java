package com.larrex.bookapi.service;

import com.larrex.bookapi.model.Author;
import com.larrex.bookapi.model.AuthorModel;

public interface AuthorService {

    Author createAuthor(AuthorModel author);

    Author readAuthor(Long id);

    Author updateAuth(AuthorModel author, Long id);

    void  deleteAuthor(Long id);

}
