package com.episodes.Episodes.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Episode {
    @Id
    private Integer id;
    private String name;
    private String hero;
    private Integer length;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHero() {
        return hero;
    }

    public void setHero(String hero) {
        this.hero = hero;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public Episode() {
    }

    public Episode(Integer id, String name, String hero, Integer length) {
        this.id = id;
        this.name = name;
        this.hero = hero;
        this.length = length;
    }
}
