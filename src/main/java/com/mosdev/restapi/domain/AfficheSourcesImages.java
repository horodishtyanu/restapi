package com.mosdev.restapi.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AfficheSourcesImages {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String type;
    private String url;

    private Integer affiche_sources_id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getAffiche_sources_id() {
        return affiche_sources_id;
    }

    public void setAffiche_sources_id(Integer affiche_sources_id) {
        this.affiche_sources_id = affiche_sources_id;
    }
}
