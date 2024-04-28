package com.example.Springdatajpa.repository;

import com.example.Springdatajpa.entity.Course;
import com.example.Springdatajpa.entity.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseMaterialRepositoryTest {
    @Autowired
    private CourseMaterialRepository courseMaterialRepository;

    @Test
    public void saveCourseMaterial() {
        Course course = Course
                .builder()
                .title("Android")
                .credit(5)
                .build();

        CourseMaterial courseMaterial = CourseMaterial
                .builder()
                .url("https://developer.android.com/?gad_source=1&gclid=CjwKCAjwxLKxBhA7EiwAXO0R0P8TpKLdcFBaaVb4KtGcnIXgbWSUDrvPlCxv6VFg6BYXJC32xEPy-xoCN14QAvD_BwE&gclsrc=aw.ds")
                .course(course)
                .build();

        courseMaterialRepository.save(courseMaterial);
    }
}