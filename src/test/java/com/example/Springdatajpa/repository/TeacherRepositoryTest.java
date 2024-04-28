package com.example.Springdatajpa.repository;

import com.example.Springdatajpa.entity.Course;
import com.example.Springdatajpa.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository teacherRepository;


    @Test
    public void saveTeacher() {
        Course course1 = Course
                .builder().
                title("Design patterns")
                .credit(5)
                .build();

        Course course2 = Course
                .builder().
                title("Java")
                .credit(6)
                .build();
/*
        Teacher teacher = Teacher
                .builder()
                .firstName("Andy")
                .lastName("Rubin")
                .courses(List.of(course1, course2))
                .build();

        teacherRepository.save(teacher);*/
    }
}