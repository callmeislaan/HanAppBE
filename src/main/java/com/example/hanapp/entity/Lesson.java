package com.example.hanapp.entity;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "lesson")
public class Lesson {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description", length = 2000)
    private String description;

    @Column(name = "background_color")
    private String backgroundColor;

    @ManyToOne
    private Folder folder;

    @OneToOne(mappedBy = "lesson", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private LessonDetail lessonDetail;

    @OneToMany(mappedBy = "lesson", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<LessonKeyValue> lessonKeyValues = new ArrayList<>();

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(String backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public Folder getFolder() {
        return folder;
    }

    public void setFolder(Folder folder) {
        this.folder = folder;
    }

    public LessonDetail getLessonDetail() {
        return lessonDetail;
    }

    public void setLessonDetail(LessonDetail lessonDetail) {
        this.lessonDetail = lessonDetail;
    }

    public List<LessonKeyValue> getLessonKeyValues() {
        return lessonKeyValues;
    }

    public void setLessonKeyValues(List<LessonKeyValue> lessonKeyValues) {
        this.lessonKeyValues = lessonKeyValues;
    }
}
