package com.example.springassignment1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    // Correcting the return type to List<Course> instead of List<CourseService>
    @GetMapping
    public ResponseEntity<List<Course>> getCourses() {
        return new ResponseEntity<>(courseService.getAllCourses(), HttpStatus.OK);
    }

    @GetMapping("/{name}")
    public HttpEntity<Course> getCourse(@PathVariable String name) {
        List<Course> courses=courseService.getCoursebyName(name).collect(Collectors.toList());
        if (courses.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(courses.get(0),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> addCourse(@RequestBody @Valid Course course) {
        courseService.addCourse(course);
        return new ResponseEntity<>("Course added successfully", HttpStatus.CREATED);
    }

    @PutMapping("/{name}")
    public ResponseEntity<String> updateCourse(@PathVariable String name, @RequestBody @Valid Course course) {
        boolean updated = courseService.updateCourse(name, course);
        return updated ?
                new ResponseEntity<>("Course updated successfully", HttpStatus.OK) :
                new ResponseEntity<>("Course not found", HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{name}")
    public ResponseEntity<String> deleteCourse(@PathVariable String name) {
        boolean deleted = courseService.deleteCourse(name);
        return deleted ?
                new ResponseEntity<>("Course deleted successfully", HttpStatus.OK) :
                new ResponseEntity<>("Course not found", HttpStatus.NOT_FOUND);
    }

    public void setDescription(Object description) {

    }
}
