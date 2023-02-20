package com.example.hanapp.controller;

import com.example.hanapp.entity.request.FolderRequest;
import com.example.hanapp.entity.response.FolderResponse;
import com.example.hanapp.entity.response.LessonResponse;
import com.example.hanapp.service.FolderService;
import com.example.hanapp.service.LessonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/folders")
public class FolderController {

    private final FolderService folderService;

    private final LessonService lessonService;

    public FolderController(FolderService folderService, LessonService lessonService) {
        this.folderService = folderService;
        this.lessonService = lessonService;
    }

    @GetMapping
    public ResponseEntity<List<FolderResponse>> getFolders() {
        return ResponseEntity.ok(folderService.getFolders());
    }

    @GetMapping("/{id}/lessons")
    public ResponseEntity<List<LessonResponse>> getLessonsInFolder(@PathVariable Long id) {
        return ResponseEntity.ok(lessonService.getLessonsInFolder(id));
    }

    @PostMapping
    public ResponseEntity<FolderResponse> createFolder(@RequestBody FolderRequest request) {
        return ResponseEntity.ok(folderService.createFolder(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<FolderResponse> updateFolder(@PathVariable Long id,
                                                       @RequestBody FolderRequest request) {
        return ResponseEntity.ok(folderService.updateFolder(id, request));
    }

    @DeleteMapping("/id")
    public ResponseEntity<List<FolderResponse>> deleteFolder(@PathVariable Long id) {
        return ResponseEntity.ok(folderService.deleteFolder(id));
    }

}
