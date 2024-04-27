package com.example.Springdatajpa.repository;

import com.example.Springdatajpa.entity.Guardian;
import com.example.Springdatajpa.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentRepositoryTest {
    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent() {
        Student student = Student
                .builder()
                .emailId("spring@test.com")
                .firstName("Spring")
                .lastName("Boot")
                /* .guardianName("C")
                 .guardianEmail("C@Test.com")
                 .guardianMobile("9999999999")*/
                .build();

        studentRepository.save(student);

    }

    @Test
    public void saveStudentWithGuardian() {
        Guardian guardian = Guardian
                .builder()
                .email("venkatest@gmail.com")
                .name("Venkatesh")
                .mobile("12333")
                .build();

        Student student = Student.builder()
                .firstName("nagaraju")
                .lastName("naroju")
                .emailId("nagaraju@gmail.com")
                .guardian(guardian)
                .build();

        studentRepository.save(student);
    }

    @Test
    public void printAllStudent() {
        List<Student> studentList = studentRepository.findAll();
        System.out.println("Students List : = " + studentList);
    }
}