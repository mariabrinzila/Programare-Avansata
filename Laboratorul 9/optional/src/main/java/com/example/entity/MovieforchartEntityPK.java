package com.example.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class MovieforchartEntityPK implements Serializable {
    private long movieid;
    private long chartid;

    @Column(name = "MOVIEID", nullable = false, precision = 0)
    @Id
    public long getMovieid() {
        return movieid;
    }

    public void setMovieid(long movieid) {
        this.movieid = movieid;
    }

    @Column(name = "CHARTID", nullable = false, precision = 0)
    @Id
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
        MovieforchartEntityPK that = (MovieforchartEntityPK) o;
        return movieid == that.movieid && chartid == that.chartid;
    }

    @Override
    public int hashCode() {
        return Objects.hash(movieid, chartid);
    }
}
