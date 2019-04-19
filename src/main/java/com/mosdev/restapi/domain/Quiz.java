package com.mosdev.restapi.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Quiz {

    public Quiz() {
    }

    public Quiz(String name, String image, String preview_image, String task_text, String prize_text, String sort, String active, Long time, Set<QuizQuest> quests) {
        this.name = name;
        this.image = image;
        this.preview_image = preview_image;
        this.task_text = task_text;
        this.prize_text = prize_text;
        this.sort = sort;
        this.active = active;
        this.time = time;
        this.quests = quests;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name,
            image,
            preview_image,
            task_text,
            prize_text,
            sort,
            active;
    private Long time;

    @OneToMany(mappedBy = "quiz_id")
    private Set<QuizQuest> quests;

    public Set<QuizQuest> getQuests() {
        return quests;
    }

    public void setQuests(Set<QuizQuest> quests) {
        this.quests = quests;
    }

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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPreview_image() {
        return preview_image;
    }

    public void setPreview_image(String preview_image) {
        this.preview_image = preview_image;
    }

    public String getTask_text() {
        return task_text;
    }

    public void setTask_text(String task_text) {
        this.task_text = task_text;
    }

    public String getPrize_text() {
        return prize_text;
    }

    public void setPrize_text(String prize_text) {
        this.prize_text = prize_text;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }
}
