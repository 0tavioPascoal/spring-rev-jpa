package com.Tavin.spring_rev_jpa.controller;

import com.Tavin.spring_rev_jpa.infra.projection.AuthorResponseProjection;
import com.Tavin.spring_rev_jpa.infra.service.AuthorService;
import com.Tavin.spring_rev_jpa.infra.entity.Author;
import com.Tavin.spring_rev_jpa.infra.entity.InfoAuthor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("authors")
public class AuthorController {

    private final AuthorService AuthorService;

    public AuthorController(AuthorService AuthorService) {
        this.AuthorService = AuthorService;
    }

    @PostMapping()
    public Author Save(@RequestBody Author author) {
        AuthorService.SaveAuthor(author);
        return author;
    }

    @PutMapping()
    public Author Update(@RequestBody Author author) {
        AuthorService.UpdateAuthor(author);
        return author;
    }

    @DeleteMapping("{id}")
    public String Delete(@PathVariable Long id) {
        AuthorService.DeleteAuthor(id);
        return "Success";
    }

    @GetMapping("{id}")
    public Author FindByIdAuthor(@PathVariable Long id) {
        return AuthorService.FindById(id);
    }

    @GetMapping()
    public List<Author> FindAllAuthors() {
        return AuthorService.findAll();
    }

    @GetMapping("nameOrLastName")
    public List<Author> FindAllAuthorsOrNameOrLastName(@RequestParam String termo) {
        return AuthorService.findAllByNameOrLastName(termo);
    }

    @GetMapping("quantity")
    public Long  FindAllAuthorsQuantity() {
        return AuthorService.Quantity();
    }

    @PutMapping("{id}/info")
    public Author UpdateAuthor(@RequestBody InfoAuthor author, @PathVariable Long id) {
        return AuthorService.SaveInfoAuthor(author, id);
    }

    @GetMapping("Cargo")
    public List<Author> FindByCargo(@RequestParam String cargo) {
        return AuthorService.FindByCargo(cargo);
    }

    @GetMapping("infoAuthor")
    public AuthorResponseProjection FindAuthorInfoByID(@RequestParam Long id) {
        return AuthorService.findAuthorInfoById(id);
    }
}
