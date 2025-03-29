package com.example.springassignment1;

import com.example.springassignment1.Repository.CoursesRepository;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.Optional;


@Service
public class CourseService {
    @Autowired
    CoursesRepository courseRepository;

    public List<Courses> getAllCourses() {
        List<Courses> courses = new ArrayList<>();
        courseRepository.findAll().forEach(courses ::add);
        return courses;
    }

    public Courses getCoursesById(int id) {
        Optional<Courses> courses = courseRepository.findById(id);
        if(courses.isPresent()){
            return courses.get();

        }else{
            throw new RuntimeException("course  not found with ID: " + id);
        }
    }

    public void delete(int id) {
        if(courseRepository.existsById(id)){
            courseRepository.deleteById(id);
        }else {
            throw new RuntimeException("course not found with ID " +id);
        }

    }
    public void saveOrUpdate(Courses courses){
        courseRepository.save(courses);
    }
}



