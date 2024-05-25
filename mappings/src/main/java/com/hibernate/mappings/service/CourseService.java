package com.hibernate.mappings.service;

import com.hibernate.mappings.model.Course;

import java.util.List;
import java.util.Optional;

public interface CourseService {
    List<Course> getAllCourses();
    Optional<Course> getCourseById(Long id);
    Course createCourse(Course course);
    Course updateCourse(Long id, Course courseDetails);
    void deleteCourse(Long id);
}
