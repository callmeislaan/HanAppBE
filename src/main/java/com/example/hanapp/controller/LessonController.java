package com.example.hanapp.controller;

import com.example.hanapp.entity.request.LessonContentRequest;
import com.example.hanapp.entity.request.LessonContentResponse;
import com.example.hanapp.entity.request.LessonRequest;
import com.example.hanapp.entity.response.LessonDetailResponse;
import com.example.hanapp.entity.response.LessonResponse;
import com.example.hanapp.service.LessonKeyValueService;
import com.example.hanapp.service.LessonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lessons")
public class LessonController {

    private final LessonService lessonService;

    private final LessonKeyValueService lessonKeyValueService;

    public LessonController(LessonService lessonService, LessonKeyValueService lessonKeyValueService) {
        this.lessonService = lessonService;
        this.lessonKeyValueService = lessonKeyValueService;
    }

    @GetMapping
    public ResponseEntity<List<LessonResponse>> getLessons() {
        return ResponseEntity.ok(lessonService.getLessons());
    }

    @PostMapping
    public ResponseEntity<LessonResponse> createLesson(@RequestBody LessonRequest request) {
        return ResponseEntity.ok(lessonService.createLesson(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<LessonResponse> updateLesson(@PathVariable Long id,
                                                       @RequestBody LessonRequest request) {
        return ResponseEntity.ok(lessonService.updateLesson(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<List<LessonResponse>> deleteLesson(@PathVariable Long id) {
        return ResponseEntity.ok(lessonService.deleteLesson(id));
    }

    @PutMapping("/{id}/content")
    public ResponseEntity<LessonContentResponse> updateLessonContent(@PathVariable Long id,
                                                                     @RequestBody LessonContentRequest request) {
        return ResponseEntity.ok(lessonService.updateLessonContent(id, request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<LessonDetailResponse> getLessonDetail(@PathVariable Long id) {
        return ResponseEntity.ok(lessonService.getLessonDetail(id));
    }

    @DeleteMapping("/{id}/key")
    public ResponseEntity<Void> deleteLessonKey(@PathVariable Long id, @RequestParam String key) {
        return ResponseEntity.ok(lessonKeyValueService.deleteLessonKeyValue(id, key));
    }
}
