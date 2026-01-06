package com.Tavin.spring_rev_jpa.infra.service;

import com.Tavin.spring_rev_jpa.infra.entity.Author;
import com.Tavin.spring_rev_jpa.infra.entity.InfoAuthor;
import com.Tavin.spring_rev_jpa.infra.projection.AuthorResponseProjection;
import com.Tavin.spring_rev_jpa.infra.repository.AuthorRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AuthorService {

    private final AuthorRepository  authorRepository;

    @PersistenceContext
    private EntityManager  entityManager;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Transactional(readOnly = false)
    public void SaveAuthor(Author author) {
        this.authorRepository.save(author);
    }

    @Transactional(readOnly = false)
    public void UpdateAuthor(Author author) {
        this.authorRepository.save(author);
    }

    @Transactional(readOnly = false)
    public void DeleteAuthor(Long id) {
        this.authorRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    public Author FindById(Long id) {
        return  this.authorRepository.findById(id).orElseThrow( () -> new RuntimeException("Id not found!"));
    }

    @Transactional(readOnly = true)
    public List<Author> findAll() {
        return this.authorRepository.findAll();
    }

    @Transactional(readOnly = true)
    public List<Author> findAllByNameOrLastName(String termo) {
        return this.authorRepository.findByNameOrLastName("%" + termo + "%");
    }

    @Transactional(readOnly = true)
    public Long Quantity(){
        return this.authorRepository.count();
    }

    @Transactional(readOnly = false)
    public Author SaveInfoAuthor(InfoAuthor infoAuthor, Long id) {
        var author = authorRepository.findById(id).orElseThrow( () -> new RuntimeException("Id not found!"));
        author.setInfo_author(infoAuthor);
        return this.authorRepository.save(author);
    }

    @Transactional(readOnly = true)
    public List<Author> FindByCargo(String cargo){
        return this.authorRepository.findByCargo("%" + cargo + "%");
    }

    public AuthorResponseProjection findAuthorInfoById(Long id){
        return this.authorRepository.findAuthorInfoById(id);
    }
}
