package com.mosdev.restapi.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Ads implements Comparable<Ads>{

    public Ads() {
    }

    public Ads(String title, String name, String url, String image, String active, String type, Integer sort) {
        this.title = title;
        this.name = name;
        this.url = url;
        this.image = image;
        this.active = active;
        this.type = type;
        this.sort = sort;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String title,name,url,image,active, type;
    private Integer sort;

    @Override
    public int compareTo(Ads o){
        return this.getSort().compareTo((o.getSort()));
    }

    public String getType() {
        type = "ads";
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }
}
