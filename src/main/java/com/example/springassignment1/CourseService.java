package com.example.springassignment1;

import com.example.springassignment1.Repository.CoursesRepository;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.CourseController;


@Service
public class CourseService {
    @Autowired
    CoursesRepository courseRepository;

    public List<Courses> getAllCourses() {
        List<Courses> courses = new ArrayList<Courses>();
        courseRepository.findAll().forEach(courses1 -> courses.add(courses1));
        return courses;
    }

    public Courses getCoursesbyid(int id) {
        return courseRepository.findbyid(id).get();
    }

    public void delete(int id) {
        courseRepository.save(courses);
    }
}



