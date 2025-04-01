package com.example.springassignment1.service;

import com.example.springassignment1.model.Courses;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

   private final List<Courses>courses = new ArrayList<>();
           private long idCounter = 0 ;

    public Courses createCourses(Courses course) {
        course.setCourseid(idCounter++);
        courses.add(course);
        return course;
    }

    public List<Courses> getAllCourses() {
        return courses;
    }

    public Optional<Courses> getCoursesById(Long id) {
       return  courses.stream().filter(course -> course.getCourseid().equals(id)).findFirst();
    }

    public Optional<Courses> updateCourses(Long id, Courses coursedetails){
        return getCoursesById(id).map(course ->{
            course.setCoursename(coursedetails.getCoursename());
            course.setDescription(coursedetails.getDescription());
            return course;
        });
    }
    public boolean deleteCourses(Long id) {
        return courses.removeIf(course -> course.getCourseid().equals(id));
    }
}




