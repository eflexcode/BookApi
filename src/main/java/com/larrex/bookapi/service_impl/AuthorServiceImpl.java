package com.larrex.bookapi.service_impl;

import com.larrex.bookapi.exception.ResourceNotFoundException;
import com.larrex.bookapi.model.Author;
import com.larrex.bookapi.model.AuthorModel;
import com.larrex.bookapi.repository.AuthorRepository;
import com.larrex.bookapi.service.AuthorService;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthorServiceImpl implements AuthorService {

    AuthorRepository authorRepository;

    @Override
    public Author createAuthor(AuthorModel authorModel) {

        Author author = new Author();
        BeanUtils.copyProperties(authorModel,author);

        return authorRepository.save(author);
    }

    @Override
    public Author readAuthor(Long id) {
        return authorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No author found with id: " + id));
    }

    @Override
    public Page<Author> readAuthors(Pageable pageable) {
        return  authorRepository.findAll(pageable);
    }

    @Override
    public Page<Author> readAuthorByName(String name, Pageable pageable) {
        return authorRepository.findByName(name, pageable);
    }

    @Override
    public Author updateAuth(AuthorModel authorModel, Long id) {

        Author currentAuthor = readAuthor(id);
        currentAuthor.setName(authorModel.getName() != null ? authorModel.getName() : currentAuthor.getName());
        currentAuthor.setBiography(authorModel.getBiography() != null ? authorModel.getBiography() : currentAuthor.getBiography());
        currentAuthor.setImageUrl(authorModel.getImageUrl() != null ? authorModel.getImageUrl() : currentAuthor.getImageUrl());

        return authorRepository.save(currentAuthor);
    }

    @Override
    public void deleteAuthor(Long id) {
        Author deletetAuthor = readAuthor(id);
        authorRepository.delete(deletetAuthor);
    }
}
