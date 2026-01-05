package com.Tavin.spring_rev_jpa.infra.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "info_author")
public class InfoAuthor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id_info;

    @Column(name = "cargo", nullable = false, length = 50)
    private String cargo;

    @Column(name = "bio")
    private String bio;

    public Long getId_info() {
        return id_info;
    }

    public void setId_info(Long id_info) {
        this.id_info = id_info;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        InfoAuthor that = (InfoAuthor) o;
        return Objects.equals(id_info, that.id_info);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id_info);
    }

    @Override
    public String toString() {
        return "Info_Author{" +
                "id_info=" + id_info +
                ", Cargo='" + cargo + '\'' +
                ", Bio='" + bio + '\'' +
                '}';
    }
}
