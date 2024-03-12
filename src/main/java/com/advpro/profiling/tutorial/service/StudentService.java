package com.advpro.profiling.tutorial.service;

import com.advpro.profiling.tutorial.model.Student;
import com.advpro.profiling.tutorial.model.StudentCourse;
import com.advpro.profiling.tutorial.repository.StudentCourseRepository;
import com.advpro.profiling.tutorial.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.*;

/**
 * @author muhammad.khadafi
 */
@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StudentCourseRepository studentCourseRepository;

    public List<StudentCourse> getAllStudentsWithCourses() {
        List<Student> students = studentRepository.findAll();
        List<StudentCourse> studentCourses = new ArrayList<>();
        for (Student student : students) {
            List<StudentCourse> studentCoursesByStudent = studentCourseRepository.findByStudentId(student.getId());
            studentCourses.addAll(studentCoursesByStudent);
        }
        return studentCourses;
    }

    public Optional<Student> findStudentWithHighestGpa() {
        return studentRepository.findFirstByOrderByGpaDesc();
    }

    public String joinStudentNames() {
        List<Student> students = studentRepository.findAll();
        StringBuilder str = new StringBuilder();
        for (Student student : students) {
            str.append(student.getName());
            str.append(", ");
        }
        return str.substring(0, str.length() - 2);
    }
}

