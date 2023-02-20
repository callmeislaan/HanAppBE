package com.example.hanapp.controller;

import com.example.hanapp.entity.request.LessonKeyValueRequest;
import com.example.hanapp.entity.response.LessonKeyValueResponse;
import com.example.hanapp.service.LessonKeyValueService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lesson-key-value")
public class LessonKeyValueController {

    private final LessonKeyValueService lessonKeyValueService;

    public LessonKeyValueController(LessonKeyValueService lessonKeyValueService) {
        this.lessonKeyValueService = lessonKeyValueService;
    }

    @GetMapping
    public ResponseEntity<List<LessonKeyValueResponse>> getLessonKeyValues() {
        return ResponseEntity.ok(lessonKeyValueService.getLessonKeyValues());
    }

    @PostMapping
    public ResponseEntity<LessonKeyValueResponse> createLessonKeyValue(@RequestBody LessonKeyValueRequest request) {
        return ResponseEntity.ok(lessonKeyValueService.createLessonKeyValue(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<LessonKeyValueResponse> updateLessonKeyValue(@PathVariable Long id,
                                                       @RequestBody LessonKeyValueRequest request) {
        return ResponseEntity.ok(lessonKeyValueService.updateLessonKeyValue(id, request));
    }

    @DeleteMapping("/id")
    public ResponseEntity<List<LessonKeyValueResponse>> deleteLessonKeyValue(@PathVariable Long id) {
        return ResponseEntity.ok(lessonKeyValueService.deleteLessonKeyValue(id));
    }

}
