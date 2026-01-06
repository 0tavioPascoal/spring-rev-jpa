package com.Tavin.spring_rev_jpa.infra.repository;

import com.Tavin.spring_rev_jpa.infra.entity.Author;
import com.Tavin.spring_rev_jpa.infra.projection.AuthorResponseProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    @Query("""
    select a from Author a
    where a.info_author.cargo like :cargo
    order by a.name asc
""")
    List<Author> findByCargo(@Param("cargo") String cargo);

    @Query("""
    select a from Author a
    where a.name like :termo or a.lastName like :termo
""")
    List<Author> findByNameOrLastName(@Param("termo") String termo);

    @Query("""
    select a.name as name, a.lastName as lastName, a.info_author.cargo as cargo, a.info_author.bio as bio from Author a
    where a.id = :id
""")
    AuthorResponseProjection findAuthorInfoById(@Param("id") Long id);
}
