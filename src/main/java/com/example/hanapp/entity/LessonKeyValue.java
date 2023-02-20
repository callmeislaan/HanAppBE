package com.example.hanapp.entity;

import javax.persistence.*;

@Entity
@Table(name = "lesson_key_value")
public class LessonKeyValue {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "trans_key")
    private String transKey;

    @Column(name = "tran_value")
    private String transValue;

    @ManyToOne
    @JoinColumn(name = "lesson_id")
    private Lesson lesson;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTransKey() {
        return transKey;
    }

    public void setTransKey(String transKey) {
        this.transKey = transKey;
    }

    public String getTransValue() {
        return transValue;
    }

    public void setTransValue(String transValue) {
        this.transValue = transValue;
    }

    public Lesson getLesson() {
        return lesson;
    }

    public void setLesson(Lesson lesson) {
        this.lesson = lesson;
    }
}
