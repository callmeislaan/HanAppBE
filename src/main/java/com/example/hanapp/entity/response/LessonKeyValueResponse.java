package com.example.hanapp.entity.response;

public class LessonKeyValueResponse {

    private Long id;

    private String transKey;

    private String transValue;

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
}
