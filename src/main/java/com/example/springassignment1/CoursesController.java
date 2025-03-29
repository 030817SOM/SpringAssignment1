package com.example.springassignment1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class CoursesController {
    @Autowired
    CourseService courseService;

    @GetMapping("/Courses")
    private List<Courses> getAllCourses() {
        return courseService.getAllCourses();
    }

    @GetMapping("/course/{courseid}")
    private Courses getCourses(@PathVariable("courseid") int courseid) {
        return courseService.getCoursesbyid(courseid);
    }

    @DeleteMapping("/course/{courseid}")
    private void deleteCourse(@PathVariable(courseid) int courseid) {
        courseService.delete(courseid);
    }

    @PostMapping("/course")
    private int saveCourse(@RequestBody Courses courses) {
        courseService.saveOrUpdate(courses);
        return courses.getCourseid();
    }

    @PutMapping
    private Courses update(@RequestBody Courses courses) {
        courseService.saveOrUpdate(courses);
        return courses;
    }
}


