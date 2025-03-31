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
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/courses")
public class CoursesController {
    @Autowired
    CourseService courseService;

    @GetMapping("/Courses")
    private List<Courses> getAllCourses() {
        return courseService.getAllCourses();
    }

    @GetMapping("/courses/{coursesId}")
    private Courses getCourses(@PathVariable("coursesId") int coursesId) {
        return courseService.getCoursesById(coursesId);
    }

    @DeleteMapping("/course/{coursesId}")
    private void deleteCourse(@PathVariable("coursesId") int coursesId) {
        courseService.delete(coursesId);
    }

    @PostMapping("/course")
    private int saveCourse(@Valid @RequestBody Courses courses) {
        courseService.saveOrUpdate(courses);
        return courses.getCourseid();
    }

    @PutMapping
    private Courses update(@Valid @RequestBody Courses courses) {
        courseService.saveOrUpdate(courses);
        return courses;
    }
}


