package com.example.springassignment1.controller;

import com.example.springassignment1.model.Courses;
import com.example.springassignment1.service.CourseService;
import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;



 @RestController
 @RequestMapping("/Courses")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService){
        this.courseService = courseService;
    }

     @GetMapping("/")
     private List<Courses> getAllCourses() {
         return courseService.getAllCourses();
     }

     @GetMapping("/{id}")
     public ResponseEntity<Courses> getCourses(@PathVariable("id") Long id) {
        Optional<Courses>courses = courseService.getCoursesById(id);
         return courses.map(ResponseEntity::ok)
         .orElseThrow(() -> new RuntimeException("course not found "+ id));
     }
     @PostMapping("/")
     @ResponseStatus(HttpStatus.CREATED)
     public Courses createCourses(@Valid @RequestBody Courses course, BindingResult bindingResult) {
         if (bindingResult.hasErrors()) {
             throw new RuntimeException("Invalid input data " + bindingResult.getAllErrors());
         }
         return courseService.createCourses(course);
     }

     @PutMapping("/{id}")
     public ResponseEntity<Courses> updateCourses( @PathVariable("id") Long id, @Valid @RequestBody Courses courses, BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            throw new RuntimeException("invalid input data "+ bindingResult.getAllErrors());
        }
         Courses updateCourses = courseService.updateCourses(id, courses)
                 .orElseThrow(() ->new RuntimeException("course not found with ID "+id));
        return ResponseEntity.ok(updateCourses);
     }
     @DeleteMapping("/{id}")
     public String deleteCourse(@PathVariable Long id) {
         if (courseService.deleteCourses(id)) {
             return "Course with ID " + id + " was deleted";
         } else {
             throw new RuntimeException("Course not found with ID: " + id);
         }
     }
 }


