package com.example.hanapp.controller;

import com.example.hanapp.entity.request.LessonContentRequest;
import com.example.hanapp.entity.request.LessonContentResponse;
import com.example.hanapp.entity.request.LessonRequest;
import com.example.hanapp.entity.response.LessonDetailResponse;
import com.example.hanapp.entity.response.LessonResponse;
import com.example.hanapp.service.LessonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lessons")
public class LessonController {

    private final LessonService folderService;

    public LessonController(LessonService folderService) {
        this.folderService = folderService;
    }

    @GetMapping
    public ResponseEntity<List<LessonResponse>> getLessons() {
        return ResponseEntity.ok(folderService.getLessons());
    }

    @PostMapping
    public ResponseEntity<LessonResponse> createLesson(@RequestBody LessonRequest request) {
        return ResponseEntity.ok(folderService.createLesson(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<LessonResponse> updateLesson(@PathVariable Long id,
                                                       @RequestBody LessonRequest request) {
        return ResponseEntity.ok(folderService.updateLesson(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<List<LessonResponse>> deleteLesson(@PathVariable Long id) {
        return ResponseEntity.ok(folderService.deleteLesson(id));
    }

    @PutMapping("/{id}/content")
    public ResponseEntity<LessonContentResponse> updateLessonContent(@PathVariable Long id,
                                                                     @RequestBody LessonContentRequest request) {
        return ResponseEntity.ok(folderService.updateLessonContent(id, request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<LessonDetailResponse> getLessonDetail(@PathVariable Long id) {
        return ResponseEntity.ok(folderService.getLessonDetail(id));
    }
}
