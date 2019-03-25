package com.mosdev.restapi.domain;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
public class Affiche {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String url, name,description, age;
    private Date date;

    @OneToMany(fetch = FetchType.EAGER,mappedBy = "affiche_id")
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
