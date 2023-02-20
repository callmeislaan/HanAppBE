package com.example.hanapp.service.util;

import com.example.hanapp.entity.Folder;
import com.example.hanapp.entity.Lesson;
import com.example.hanapp.entity.LessonKeyValue;
import com.example.hanapp.entity.response.FolderResponse;
import com.example.hanapp.entity.response.LessonKeyValueResponse;
import com.example.hanapp.entity.response.LessonResponse;
import org.springframework.beans.BeanUtils;

public class ConvertUtil {

    private ConvertUtil() {

    }

    public static FolderResponse convert(Folder folder) {
        if (folder == null) {
            return null;
        }
        FolderResponse folderResponse = new FolderResponse();
        BeanUtils.copyProperties(folder, folderResponse, FolderResponse.class);
        return folderResponse;
    }

    public static LessonKeyValueResponse convert(LessonKeyValue lessonKeyValue) {
        if (lessonKeyValue == null) {
            return null;
        }
        LessonKeyValueResponse lessonKeyValueResponse = new LessonKeyValueResponse();
        BeanUtils.copyProperties(lessonKeyValue, lessonKeyValueResponse, LessonKeyValueResponse.class);
        return lessonKeyValueResponse;
    }

    public static LessonResponse convert(Lesson lesson) {
        if (lesson == null) {
            return null;
        }
        LessonResponse lessonResponse = new LessonResponse();
        BeanUtils.copyProperties(lesson, lessonResponse, LessonResponse.class);
        return lessonResponse;
    }
}
