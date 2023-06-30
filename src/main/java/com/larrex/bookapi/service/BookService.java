package com.larrex.bookapi.service;

import com.larrex.bookapi.model.Book;
import com.larrex.bookapi.model.BookModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BookService {

    Book createBook(BookModel bookModel);

    Book updateBook(BookModel bookModel);

    Book getBookById(Long id);

    Page<Book> getBookByName(String bookName, Pageable pageable);

    Page<Book> getBookByCategory(String category, Pageable pageable);

    void deleteBook(Long id);
}
