package com.example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

 @RestController
 @RequestMapping("/courses")
public class CourseController {
     @GetMapping("/courses")
     public CourseInfo GetCourses() {

         List<String> foundationCourses = List.of("2 Foundation courses offered in the Computer Science Department:");
         List<String> undergradCourses = List.of("5 Undergraduate courses offered in the Computer Science Department:");
         List<String> honoursCourses = List.of("4 Honours courses offered in the Computer Science Department:");

         return new CourseInfo(foundationCourses, undergradCourses, honoursCourses);
     }

     public static class CourseInfo {
         private List<String> foundationCourses;
         private List<String> undergradCourses;
         private List<String> honoursCourses;

         public CourseInfo(List<String> foundationCourses, List<String> undergradCourses, List<String> honoursCourses)
         {
             this.foundationCourses = foundationCourses;
             this.undergradCourses = undergradCourses;
             this.honoursCourses = honoursCourses;
         }

         public List<String> getFoundationCourses () {
             return foundationCourses;
         }

         public List<String> getundergradCourses () {
             return undergradCourses;
         }

         public List<String> gethonoursCourses () {
             return honoursCourses;
         }
     }
 }