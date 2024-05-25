package com.hibernate.mappings.service;

import com.hibernate.mappings.model.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    List<Student> getAllStudents();
    Optional<Student> getStudentById(Long id);
    Student createStudent(Student student);
    Student updateStudent(Long id, Student studentDetails);
    void deleteStudent(Long id);
}
