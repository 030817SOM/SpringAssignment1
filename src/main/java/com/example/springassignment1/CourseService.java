package com.example.springassignment1;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@Service
public class CourseService {
    private final List<Course>courses = new ArrayList<>();
    private final CourseController course;

    public CourseService(CourseController course) {
        this.course = course;
    }

    public List<Course> getAllCourses() {
        return courses;
    }

    public Stream<Course> getCoursebyName(String name){
        return courses.stream().filter( course -> course.getName().equals(name));
    }


    public  void addCourse(Course course){
        courses.add(course);
    }

    public  boolean updateCourse(String name, Course updatedCourse){
        Stream<Course> existingCourse = getCoursebyName(name);
          return existingCourse.findFirst().map(course -> ){
            Course.set(updatedCourse.getName);
            course.setDescription(updatedCourse.getDescription());
            return true;
        }
        return false;
    }
    public boolean deleteCourse(String name) {
        return courses.removeIf(course ->courses.getName().equals(name));
    }
}

