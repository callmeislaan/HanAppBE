package com.example.hanapp.service;

import com.example.hanapp.entity.Lesson;
import com.example.hanapp.entity.LessonKeyValue;
import com.example.hanapp.entity.request.LessonKeyValueRequest;
import com.example.hanapp.entity.response.LessonKeyValueResponse;
import com.example.hanapp.repository.LessonKeyValueRepository;
import com.example.hanapp.repository.LessonRepository;
import com.example.hanapp.service.util.ConvertUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LessonKeyValueService {
    private final LessonKeyValueRepository lessonKeyValueRepository;

    private final LessonRepository lessonRepository;

    public LessonKeyValueService(LessonKeyValueRepository lessonKeyValueRepository, LessonRepository lessonRepository) {
        this.lessonKeyValueRepository = lessonKeyValueRepository;
        this.lessonRepository = lessonRepository;
    }

    public List<LessonKeyValueResponse> getLessonKeyValues() {
        return lessonKeyValueRepository.findAll()
                .stream().map(ConvertUtil::convert).collect(Collectors.toList());
    }

    public LessonKeyValueResponse createLessonKeyValue(LessonKeyValueRequest request) {
        LessonKeyValue lessonKeyValue = new LessonKeyValue();
        Lesson lesson = lessonRepository.findById(request.getLessonId()).orElseThrow(RuntimeException::new);
        Optional<LessonKeyValue> firstByTransKeyAndLesson = lessonKeyValueRepository.findFirstByTransKeyAndLesson(request.getTransKey(), lesson);
        if (firstByTransKeyAndLesson.isPresent()) {
            lessonKeyValue = firstByTransKeyAndLesson.get();
        }
        BeanUtils.copyProperties(request, lessonKeyValue, "id");
        lessonKeyValue.setLesson(lesson);
        return ConvertUtil.convert(lessonKeyValueRepository.save(lessonKeyValue));
    }

    public LessonKeyValueResponse updateLessonKeyValue(Long id, LessonKeyValueRequest request) {
        LessonKeyValue lessonKeyValue = lessonKeyValueRepository.findById(id).orElseThrow(RuntimeException::new);
        BeanUtils.copyProperties(request, lessonKeyValue, "id");
        return ConvertUtil.convert(lessonKeyValueRepository.save(lessonKeyValue));
    }

    public List<LessonKeyValueResponse> deleteLessonKeyValue(Long id) {
        if (!lessonKeyValueRepository.existsById(id)) {
            lessonKeyValueRepository.deleteById(id);
        }
        return getLessonKeyValues();
    }

    public Void deleteLessonKeyValue(Long id, String key) {
        Lesson lesson = lessonRepository.findById(id).orElseThrow(RuntimeException::new);
        Optional<LessonKeyValue> firstByTransKeyAndLesson = lessonKeyValueRepository.findFirstByTransKeyAndLesson(key, lesson);
        firstByTransKeyAndLesson.ifPresent(lessonKeyValueRepository::delete);
        return null;
    }

}
