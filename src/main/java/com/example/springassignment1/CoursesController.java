package com.example.springassignment1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    // Get all courses
    @GetMapping
    public ResponseEntity<List<Course>> getCourses() {
        return new ResponseEntity<>(courseService.getAllCourses(), HttpStatus.OK);
    }

    // Get a specific course by name
    @GetMapping("/{name}")
    public ResponseEntity<Course> getCourse(@PathVariable String name) {
        return courseService.getCourseByName(name)
                .map(course -> new ResponseEntity<>(course, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Add a new course
    @PostMapping
    public ResponseEntity<String> addCourse(@RequestBody @Valid Course course) {
        courseService.addCourse(course);
        return new ResponseEntity<>("Course added successfully", HttpStatus.CREATED);
    }

    // Update an existing course
    @PutMapping("/{name}")
    public ResponseEntity<String> updateCourse(@PathVariable String name, @RequestBody @Valid Course course) {
        boolean updated = courseService.updateCourse(name, course);
        return updated ?
                new ResponseEntity<>("Course updated successfully", HttpStatus.OK) :
                new ResponseEntity<>("Course not found", HttpStatus.NOT_FOUND);
    }

    // Delete a course
    @DeleteMapping("/{name}")
    public ResponseEntity<String> deleteCourse(@PathVariable String name) {
        boolean deleted = courseService.deleteCourse(name);
        return deleted ?
                new ResponseEntity<>("Course deleted successfully", HttpStatus.OK) :
                new ResponseEntity<>("Course not found", HttpStatus.NOT_FOUND);
    }
}
