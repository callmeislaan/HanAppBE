package com.example.hanapp.repository;

import com.example.hanapp.entity.LessonDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LessonDetailRepository extends JpaRepository<LessonDetail, Long> {
}
