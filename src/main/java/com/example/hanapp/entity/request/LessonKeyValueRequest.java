package com.example.hanapp.entity.request;

public class LessonKeyValueRequest {

    private Long lessonId;

    private String transKey;

    private String transValue;

    public Long getLessonId() {
        return lessonId;
    }

    public void setLessonId(Long lessonId) {
        this.lessonId = lessonId;
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
}
