package com.mosdev.restapi.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
public class AfficheSources {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private Integer affiche_id;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "affiche_sources_id")
    @OrderBy
    private Set<AfficheSourcesImages> images;

    private String sourceDescription;

    public Set<AfficheSourcesImages> getImages() {
        return images;
    }

    public void setImages(Set<AfficheSourcesImages> images) {
        this.images = images;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAffiche_id() {
        return affiche_id;
    }

    public void setAffiche_id(Integer affiche_id) {
        this.affiche_id = affiche_id;
    }

    public String getSourceDescription() {
        return sourceDescription;
    }

    public void setSourceDescription(String sourceDescription) {
        this.sourceDescription = sourceDescription;
    }
}
