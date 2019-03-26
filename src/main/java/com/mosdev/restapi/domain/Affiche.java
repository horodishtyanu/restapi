package com.mosdev.restapi.domain;

import org.hibernate.FlushMode;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Affiche {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String url, name,description, age;

    private Integer date;

    @OneToMany(mappedBy = "affiche_id")
    @OrderBy
    private Set<AfficheSources> sources;

    public Set<AfficheSources> getSources() {
        return sources;
    }

    public void setSources(Set<AfficheSources> sources) {
        this.sources = sources;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public Integer getDate() { return date; }

    public void setDate(Integer date) { this.date = date; }
}
