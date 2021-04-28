package com.example.entity;

import com.example.MovieforchartEntityPK;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "MOVIEFORCHART", schema = "STUDENT")
@IdClass(MovieforchartEntityPK.class)
public class MovieforchartEntity {
    private Long id;
    private long movieid;
    private long chartid;

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    @Column(name = "MOVIEID", nullable = false, precision = 0)
    public long getMovieid() {
        return movieid;
    }

    public void setMovieid(long movieid) {
        this.movieid = movieid;
    }

    @Id
    @Column(name = "CHARTID", nullable = false, precision = 0)
    public long getChartid() {
        return chartid;
    }

    public void setChartid(long chartid) {
        this.chartid = chartid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MovieforchartEntity that = (MovieforchartEntity) o;
        return movieid == that.movieid && chartid == that.chartid;
    }

    @Override
    public int hashCode() {
        return Objects.hash(movieid, chartid);
    }
}
