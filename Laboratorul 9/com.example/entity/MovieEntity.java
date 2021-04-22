package com.example.entity;

import javax.persistence.*;
import java.sql.Time;
import java.util.Objects;

@Entity
@Table(name = "MOVIE", schema = "STUDENT")
@NamedQueries({
        @NamedQuery(name = "MovieEntity.findAll()", query = "SELECT m FROM MovieEntity m"),
        @NamedQuery(name = "MovieEntity.findByName", query = "SELECT m FROM MovieEntity m WHERE m.title =: name")
})

public class MovieEntity {
    private Long id;
    private String title;
    private Time releaseDate;
    private long duration;
    private Long score;

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
    @Column(name = "TITLE", nullable = false, length = 30)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "RELEASE_DATE", nullable = false)
    public Time getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Time releaseDate) {
        this.releaseDate = releaseDate;
    }

    @Basic
    @Column(name = "DURATION", nullable = false, precision = 0)
    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    @Basic
    @Column(name = "SCORE", nullable = true, precision = 0)
    public Long getScore() {
        return score;
    }

    public void setScore(Long score) {
        this.score = score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MovieEntity that = (MovieEntity) o;
        return duration == that.duration && Objects.equals(id, that.id) && Objects.equals(title, that.title) && Objects.equals(releaseDate, that.releaseDate) && Objects.equals(score, that.score);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, releaseDate, duration, score);
    }
}
