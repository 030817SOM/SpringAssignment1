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

    public CourseService(){

        Courses courseA = new Courses();
        courseA.setCoursedetails("foundation");
        courseA.setCourseid(idCounter++);
        courseA.setCoursename("elementary programming");
        courseA.setDescription("introduction to Coding");
        courses.add(courseA);

        Courses courseB = new Courses();
        courseB.setCoursedetails("foundation");
        courseB.setCourseid(idCounter++);
        courseB.setCoursename("programming fundamental");
        courseB.setDescription("introduction to programming languages syntax and program design");
        courses.add(courseB);


        Courses course1 = new Courses();
        course1.setCourseid(idCounter++);
        course1.setCoursename("Object oriented Program");
        course1.setDescription("learning java basics and Advanced programing,undergraduate course.");
        course1.setCoursedetails("undergraduate");
        courses.add(course1);

        Courses courses2 = new Courses();
        courses2.setDescription("learning about the importance and how operating System work ");
        courses2.setCoursename("Operating System,undergraduate course. ");
        course1.setCoursedetails("Undergraduate");
        courses2.setCourseid(idCounter++);
        courses.add(courses2);

        Courses courseX = new Courses();
        courseX.setDescription("understanding of the system,transmission techniques and control");
        courseX.setCoursename("Computer networks");
        courseX.setCourseid(idCounter++);
        courseX.setCoursedetails("postgraduate");
        courses.add(courseX);

        Courses courseY = new Courses();
        courseY.setCourseid(idCounter++);
        courseY.setCoursedetails("postgraduate");
        courseY.setCoursename("Advanced java");
        courseY.setDescription("advanced features of graphical user interface (GUI) design");
        courses.add(courseY);


    }

    public Courses createCourses(Courses course) {
        course.setCourseid(idCounter++);
        courses.add(course);
        return course;
    }

    public List<Courses> getAllCourses() {
        return new ArrayList<>(courses);
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




