package com.example.hanapp.entity;

import javax.persistence.*;

@Entity
@Table(name = "lesson_detail")
public class LessonDetail {

    @Id
    @Column(name = "lesson_id")
    private Long id;

    @Lob
    @Column(name = "content", columnDefinition = "BLOB")
    private String content;

    @OneToOne
    @MapsId
    @JoinColumn(name = "lesson_id")
    private Lesson lesson;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Lesson getLesson() {
        return lesson;
    }

    public void setLesson(Lesson lesson) {
        this.lesson = lesson;
    }
}
