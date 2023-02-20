package com.example.hanapp.repository;

import com.example.hanapp.entity.Lesson;
import com.example.hanapp.entity.LessonKeyValue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LessonKeyValueRepository extends JpaRepository<LessonKeyValue, Long> {

    List<LessonKeyValue> findAllByLesson(Lesson lesson);

}
