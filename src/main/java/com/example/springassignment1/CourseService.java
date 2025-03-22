package com.example.springassignment1;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ServiceLoader;

@Service
public class CourseService {
    private final List<CourseService>course = new ArrayList<>();

    public List<CourseService> getAllCourses() {
        return course;
    }
    public Optional<Courses>getCoursebyName(String name){
        return course.stream();
                filter(course ->courses.getName().equals(name))
                .findFirst();
    }
    private ServiceLoader<Object> filter(Object o) {
            return null;
    }

    public void addCourse(Course course){
        course.add(course);
    }
    public boolean updateCourse(String name, Course updateCourse){
        Optional<Course>existingCourse = getCoursebyName(name);
        if(existingCourse.isPresent()){
            existingCourse.get().setName(updateCourse.getName());
            existingCourse.get().getDescription(updateCourse.getDescription());
            return true;
        }
        return false;
    }
    public boolean deleteCourse(String name) {
        return Course.removeIf(course.getName().equals(name));
    }
}

