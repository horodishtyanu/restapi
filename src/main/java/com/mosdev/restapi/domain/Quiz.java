package com.mosdev.restapi.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Quiz implements Comparable<Quiz>{

    public Quiz() {
    }

    public Quiz(Integer points, String name, String image, String preview_image, String task_text, String prize_text, String active, String type, Long time, Integer sort, Set<QuizQuest> quests) {
        this.points = points;
        this.name = name;
        this.image = image;
        this.preview_image = preview_image;
        this.task_text = task_text;
        this.prize_text = prize_text;
        this.active = active;
        this.type = type;
        this.time = time;
        this.sort = sort;
        this.quests = quests;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Integer points;
    private String name,
            image,
            preview_image,
            task_text,
            prize_text,
            active,
            type;
    private Long time;
    private Integer sort;

    @OneToMany(mappedBy = "quiz_id")
    private Set<QuizQuest> quests;

    @Override
    public int compareTo(Quiz o){
        return this.getSort().compareTo(o.getSort());
    }

    public String getType() {
        type = "quiz";
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public Set<QuizQuest> getQuests() {
        return quests;
    }

    public void setQuests(Set<QuizQuest> quests) {
        this.quests = quests;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }
}
