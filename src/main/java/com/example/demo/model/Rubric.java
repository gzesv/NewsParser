package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "heading", schema="public")
public class Rubric {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String rubricText;

    @Column(name = "href")
    private String rubricHref;

    @Column(name = "link_id")
    private Integer linkId;

    public Rubric() { }

    public Rubric(String rubricText, String rubricHref, Integer linkId) {
        this.rubricText = rubricText;
        this.rubricHref = rubricHref;
        this.linkId = linkId;
    }

    public Rubric(Integer id, String rubricText, String rubricHref, Integer linkId) {
        this.id = id;
        this.rubricText = rubricText;
        this.rubricHref = rubricHref;
        this.linkId = linkId;
    }

    public String getRubricText() {
        return rubricText;
    }

    public void setRubricText(String rubricText) {
        this.rubricText = rubricText;
    }

    public String getRubricHref() {
        return rubricHref;
    }

    public void setRubricHref(String rubricHref) {
        this.rubricHref = rubricHref;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
