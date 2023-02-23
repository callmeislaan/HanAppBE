package com.example.hanapp.entity.response;

import java.util.ArrayList;
import java.util.List;

public class FolderLessonResponse {

    private FolderResponse folder;

    private List<LessonResponse> lessons = new ArrayList<>();

    public FolderResponse getFolder() {
        return folder;
    }

    public void setFolder(FolderResponse folder) {
        this.folder = folder;
    }

    public List<LessonResponse> getLessons() {
        return lessons;
    }

    public void setLessons(List<LessonResponse> lessons) {
        this.lessons = lessons;
    }
}
