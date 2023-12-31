package com.larrex.bookapi.controller;

import com.larrex.bookapi.model.Author;
import com.larrex.bookapi.model.AuthorModel;
import com.larrex.bookapi.service.AuthorService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("author")
@AllArgsConstructor
public class AuthorController {

    AuthorService authorService;

    @PostMapping("/create")
    public ResponseEntity<Author> createAuthor(@RequestBody AuthorModel author) {
        return new ResponseEntity<>(authorService.createAuthor(author), HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Author> updateAuthor(@PathVariable(name = "id") Long id, @RequestBody AuthorModel authorModel) {
        return new ResponseEntity<>(authorService.updateAuth(authorModel, id), HttpStatus.OK);
    }

    @GetMapping("/read/{id}")
    public ResponseEntity<Author> getAuthor(@PathVariable(name = "id") Long id) {
        return new ResponseEntity<>(authorService.readAuthor(id), HttpStatus.OK);
    }

    @GetMapping("/read")
    public ResponseEntity<List<Author>> getAuthors(Pageable page) {
        return new ResponseEntity<>(authorService.readAuthors(page).toList(), HttpStatus.OK);
    }

    @GetMapping("/read_by_name")
    public ResponseEntity<List<Author>> getAuthorsByName(@RequestParam String name, Pageable page) {
        return new ResponseEntity<>(authorService.readAuthorByName(name,page).toList(), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteAuthor(@PathVariable(name = "id") Long id) {
        authorService.deleteAuthor(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
