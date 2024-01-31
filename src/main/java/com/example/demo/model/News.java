package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "news", schema = "public")
public class News {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String newsName;

    @Column(name = "date")
    private String newsDate;

    @Column(name = "heading_id")
    private Integer headingId;

    public News() { }

    public News(String newsName, String newsDate, Integer headingId) {
        this.newsName = newsName;
        this.newsDate = newsDate;
        this.headingId = headingId;
    }

    public News(Integer id, String newsName, String newsDate, Integer headingId) {
        this.id = id;
        this.newsName = newsName;
        this.newsDate = newsDate;
        this.headingId = headingId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNewsName() {
        return newsName;
    }

    public void setNewsName(String newsName) {
        this.newsName = newsName;
    }

    public String getNewsDate() {
        return newsDate;
    }

    public void setNewsDate(String newsDate) {
        this.newsDate = newsDate;
    }

    public Integer getHeadingId() {
        return headingId;
    }

    public void setHeadingId(Integer headingId) {
        this.headingId = headingId;
    }
}
