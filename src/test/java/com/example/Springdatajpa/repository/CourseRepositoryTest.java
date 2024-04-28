package com.example.Springdatajpa.repository;

import com.example.Springdatajpa.entity.Course;
import com.example.Springdatajpa.entity.Student;
import com.example.Springdatajpa.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseRepositoryTest {
    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void printCourses() {
        List<Course> courses = courseRepository.findAll();
        System.out.println("Courses = " + courses);
    }

    @Test
    public void saveCourseWithTeacherObject() {

        Teacher teacher = Teacher
                .builder()
                .firstName("Xyz")
                .lastName("abc")
                .build();

        Course course = Course
                .builder()
                .title("Python")
                .credit(6)
                .teacher(teacher)
                .build();

        courseRepository.save(course);

    }

    @Test
    public void findAllPagination() {
        Pageable firstPageWithThreeRecords =
                PageRequest.of(0, 3);

        Pageable secondPageWithTwoRecords = PageRequest.of(1, 2);

        List<Course> courses = courseRepository.findAll(firstPageWithThreeRecords).getContent();
        long totalElements = courseRepository.findAll(firstPageWithThreeRecords).getTotalElements();
        long totalPages = courseRepository.findAll(firstPageWithThreeRecords).getTotalPages();

        System.out.println("Courses = " + courses);
        System.out.println("Total Elements = " + totalElements);
        System.out.println("Total Pages = " + totalPages);
    }

    @Test
    public void findAllWithSorting() {
        Pageable sortByTitle = PageRequest
                .of(0,
                        2,
                        Sort.by("title")
                );
        Pageable sortByCreditDesc = PageRequest
                .of(0,
                        2,
                        Sort.by("credit")
                                .descending()
                );

        Pageable sortByTitleAndCreditDesc = PageRequest
                .of(0,
                        2,
                        Sort.by("title")
                                .descending()
                                .and(Sort.by("credit"))
                );

        List<Course> courseList = courseRepository.findAll(sortByTitle).getContent();

        System.out.println("Courses = " + courseList);
    }

    @Test
    public void printFindByTitleContaining() {
        Pageable firstPageWithTenRecords = PageRequest.of(0, 10);
        List<Course> courses = courseRepository.findByTitleContaining("a", firstPageWithTenRecords).getContent();
        System.out.println("Course = " + courses);
    }

    @Test
    public void saveCourseWithStudentAndTeacher() {

        Student student = Student
                .builder()
                .firstName("Nagender")
                .lastName("Naroju")
                .emailId("Nagender@gmail.com")
                .build();

        Teacher teacher = Teacher
                .builder()
                .firstName("James")
                .lastName("Gosling")
                .build();

        Course course = Course
                .builder()
                .title("AI")
                .credit(10)
                .teacher(teacher)
                .build();

        course.addStudents(student);

        courseRepository.save(course);
    }
}