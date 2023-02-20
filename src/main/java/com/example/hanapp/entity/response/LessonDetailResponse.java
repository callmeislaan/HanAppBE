package com.example.hanapp.entity.response;

import java.util.ArrayList;
import java.util.List;

public class LessonDetailResponse {

    private Long id;

    private String name;

    private String description;

    private String backgroundColor;

    private String content;

    private List<LessonKeyValueResponse> keyValues = new ArrayList<>();

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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<LessonKeyValueResponse> getKeyValues() {
        return keyValues;
    }

    public void setKeyValues(List<LessonKeyValueResponse> keyValues) {
        this.keyValues = keyValues;
    }
}
