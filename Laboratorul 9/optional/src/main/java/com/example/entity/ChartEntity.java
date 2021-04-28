package com.example.entity;

import javax.persistence.*;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "CHART", schema = "STUDENT")
public class ChartEntity extends AbstractEntity {
    private Long id;
    private String name;
    private Time creation;

    @OneToMany(mappedBy = "MovieEntity")
    private List<MovieEntity> movies = new ArrayList<>();

    @Id
    @GeneratedValue
    @Column(name = "ID", nullable = false, precision = 0)
    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "NAME", nullable = false, length = 50)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "CREATION", nullable = false)
    public Time getCreation() {
        return creation;
    }

    public void setCreation(Time creation) {
        this.creation = creation;
    }

    public List<MovieEntity> getMovies() {
        return movies;
    }

    public void setMovies(List<MovieEntity> movies) {
        this.movies = movies;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChartEntity that = (ChartEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(creation, that.creation) && Objects.equals(movies, that.movies);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, creation, movies);
    }
}
