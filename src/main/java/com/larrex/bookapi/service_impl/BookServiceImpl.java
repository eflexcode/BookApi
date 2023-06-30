package com.larrex.bookapi.service_impl;

import com.larrex.bookapi.model.Book;
import com.larrex.bookapi.model.BookModel;
import com.larrex.bookapi.service.BookService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {
    @Override
    public Book createBook(BookModel bookModel) {
        return null;
    }

    @Override
    public Book updateBook(BookModel bookModel) {
        return null;
    }

    @Override
    public Book getBookById(Long id) {
        return null;
    }

    @Override
    public Page<Book> getBookByName(String bookName, Pageable pageable) {
        return null;
    }

    @Override
    public Page<Book> getBookByCategory(String category, Pageable pageable) {
        return null;
    }

    @Override
    public void deleteBook(Long id) {

    }
}
