package com.Tavin.spring_rev_jpa.controller;

import com.Tavin.spring_rev_jpa.infra.dao.AuthorDao;
import com.Tavin.spring_rev_jpa.infra.entity.Author;
import com.Tavin.spring_rev_jpa.infra.entity.InfoAuthor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("authors")
public class AuthorController {

    private final AuthorDao AuthorDao;

    public AuthorController(AuthorDao AuthorDao) {
        this.AuthorDao = AuthorDao;
    }

    @PostMapping()
    public Author Save(@RequestBody Author author) {
        AuthorDao.SaveAuthor(author);
        return author;
    }

    @PutMapping()
    public Author Update(@RequestBody Author author) {
        AuthorDao.UpdateAuthor(author);
        return author;
    }

    @DeleteMapping("{id}")
    public String Delete(@PathVariable Long id) {
        AuthorDao.DeleteAuthor(id);
        return "Success";
    }

    @GetMapping("{id}")
    public Author FindByIdAuthor(@PathVariable Long id) {
        return AuthorDao.FindById(id);
    }

    @GetMapping()
    public List<Author> FindAllAuthors() {
        return AuthorDao.findAll();
    }

    @GetMapping("nameOrLastName")
    public List<Author> FindAllAuthorsOrNameOrLastName(@RequestParam String query) {
        return AuthorDao.findAllByNameOrLastName(query);
    }

    @GetMapping("quantity")
    public Long  FindAllAuthorsQuantity() {
        return AuthorDao.Quantity();
    }

    @PutMapping("{id}/info")
    public Author UpdateAuthor(@RequestBody InfoAuthor author, @PathVariable Long id) {
        return AuthorDao.SaveInfoAuthor(author, id);
    }

    @GetMapping("Cargo")
    public List<Author> FindByCargo(@RequestParam String termo) {
        return AuthorDao.FindByCargo(termo);
    }
}
