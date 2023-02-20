package com.example.hanapp.service;

import com.example.hanapp.entity.Folder;
import com.example.hanapp.entity.Lesson;
import com.example.hanapp.entity.LessonDetail;
import com.example.hanapp.entity.LessonKeyValue;
import com.example.hanapp.entity.request.LessonContentRequest;
import com.example.hanapp.entity.request.LessonContentResponse;
import com.example.hanapp.entity.request.LessonRequest;
import com.example.hanapp.entity.response.LessonDetailResponse;
import com.example.hanapp.entity.response.LessonKeyValueResponse;
import com.example.hanapp.entity.response.LessonResponse;
import com.example.hanapp.repository.FolderRepository;
import com.example.hanapp.repository.LessonDetailRepository;
import com.example.hanapp.repository.LessonKeyValueRepository;
import com.example.hanapp.repository.LessonRepository;
import com.example.hanapp.service.util.ConvertUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LessonService {
    private final LessonRepository lessonRepository;

    private final LessonDetailRepository lessonDetailRepository;

    private final LessonKeyValueRepository lessonKeyValueRepository;

    private final FolderRepository folderRepository;

    public LessonService(LessonRepository lessonRepository, LessonDetailRepository lessonDetailRepository, LessonKeyValueRepository lessonKeyValueRepository, FolderRepository folderRepository) {
        this.lessonRepository = lessonRepository;
        this.lessonDetailRepository = lessonDetailRepository;
        this.lessonKeyValueRepository = lessonKeyValueRepository;
        this.folderRepository = folderRepository;
    }

    public List<LessonResponse> getLessons() {
        return lessonRepository.findAll()
                .stream().map(ConvertUtil::convert).collect(Collectors.toList());
    }

    public LessonResponse createLesson(LessonRequest request) {
        Folder folder = folderRepository.findById(request.getFolderId()).orElseThrow(RuntimeException::new);
        Lesson lesson = new Lesson();
        BeanUtils.copyProperties(request, lesson);
        lesson.setFolder(folder);
        LessonDetail detail = new LessonDetail();
        detail.setLesson(lesson);
        detail.setContent(request.getContent());
        lesson.setLessonDetail(detail);
        return ConvertUtil.convert(lessonRepository.save(lesson));
    }

    public LessonResponse updateLesson(Long id, LessonRequest request) {
        Lesson lesson = lessonRepository.findById(id).orElseThrow(RuntimeException::new);
        BeanUtils.copyProperties(request, lesson, "id");
        return ConvertUtil.convert(lessonRepository.save(lesson));
    }

    public List<LessonResponse> deleteLesson(Long id) {
        if (!lessonRepository.existsById(id)) {
            lessonRepository.deleteById(id);
        }
        return getLessons();
    }

    public LessonContentResponse updateLessonContent(Long id, LessonContentRequest request) {
        Lesson lesson = lessonRepository.findById(id).orElseThrow(RuntimeException::new);
        lesson.getLessonDetail().setContent(request.getContent());
        Lesson persisted = lessonRepository.save(lesson);
        LessonContentResponse response = new LessonContentResponse();
        response.setContent(persisted.getLessonDetail().getContent());
        return response;
    }

    public LessonDetailResponse getLessonDetail(Long id) {
        LessonDetail lessonDetail = lessonDetailRepository.findById(id).orElseThrow(RuntimeException::new);
        Lesson lesson = lessonRepository.findById(id).orElseThrow(RuntimeException::new);
        List<LessonKeyValue> keyValues = lessonKeyValueRepository.findAllByLesson(lesson);
        List<LessonKeyValueResponse> lessonKeyValueResponses = keyValues.stream().map(ConvertUtil::convert).collect(Collectors.toList());
        LessonDetailResponse response = new LessonDetailResponse();
        BeanUtils.copyProperties(lesson, response);
        BeanUtils.copyProperties(lessonDetail, response);
        response.setKeyValues(lessonKeyValueResponses);
        return response;
    }

    public List<LessonResponse> getLessonsInFolder(Long id) {
        return lessonRepository.findAllByFolder_Id(id)
                .stream().map(ConvertUtil::convert).collect(Collectors.toList());
    }
}
