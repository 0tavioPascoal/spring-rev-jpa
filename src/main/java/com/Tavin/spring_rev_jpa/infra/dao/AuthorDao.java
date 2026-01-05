package com.Tavin.spring_rev_jpa.infra.dao;

import com.Tavin.spring_rev_jpa.infra.entity.Author;
import com.Tavin.spring_rev_jpa.infra.entity.InfoAuthor;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class AuthorDao {

    @PersistenceContext
    private EntityManager  entityManager;

    @Transactional(readOnly = false)
    public void SaveAuthor(Author author) {
        this.entityManager.persist(author);
    }

    @Transactional(readOnly = false)
    public void UpdateAuthor(Author author) {
        this.entityManager.merge(author);
    }

    @Transactional(readOnly = false)
    public void DeleteAuthor(Long id) {
        this.entityManager.remove(this.entityManager.getReference(Author.class, id));
    }

    @Transactional(readOnly = true)
    public Author FindById(Long id) {
        return  this.entityManager.find(Author.class, id);
    }

    @Transactional(readOnly = true)
    public List<Author> findAll() {
        String Query = "select a from Author a";
        return this.entityManager.createQuery(Query, Author.class).getResultList();
    }

    @Transactional(readOnly = true)
    public List<Author> findAllByNameOrLastName(String query) {
        String Query = "select a from Author a where a.name like :query or  a.lastName like :query";
        return this.entityManager.createQuery(Query, Author.class)
                .setParameter("query", "%"+query+"%")
                .getResultList();
    }

    @Transactional(readOnly = true)
    public Long Quantity(){
        String Query = "select count(*) from Author";
        return this.entityManager.createQuery(Query, Long.class).getSingleResult();
    }

    @Transactional(readOnly = false)
    public Author SaveInfoAuthor(InfoAuthor infoAuthor, Long id) {
        var author = this.entityManager.find(Author.class, id);
        author.setInfo_author(infoAuthor);
        this.entityManager.persist(infoAuthor);
        return author;
    }

    @Transactional(readOnly = true)
    public List<Author> FindByCargo(String termo){
        var Query = "Select a from Author a where a.info_author.cargo like :termo order by a.name asc";
        return this.entityManager.createQuery(Query, Author.class)
                .setParameter("termo", "%"+termo+"%")
                .getResultList();
    }
}
