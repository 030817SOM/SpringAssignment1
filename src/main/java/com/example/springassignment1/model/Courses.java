package com.example.springassignment1.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import javax.persistence.Entity;


public class Courses {

    @Size(min = 1,max = 5,message = "course id cannot be more than 5")
    @NotBlank(message = "course id connot be blank")
    private Long courseid;

    @NotBlank(message = "Course name cannot be blank")
    @Size(min = 3,max = 100,message = "Course name must at least between 3 and 100 characters")
    private String coursename;


    @Size(min = 5,message = "Description must have at least 5 characters")
    @NotBlank(message = "Description cannot be blank")
    private String description;

    @NotBlank(message = "course description")
    private String coursedetails;

    public Courses(Long courseid, String coursename,String description,String coursedetails){
        this.courseid = courseid;
        this.coursedetails = coursedetails;
        this.coursename = coursename;
        this.description = description;
    }

    public String getCoursedetails() {
        return coursedetails;
    }

    public void setCoursedetails(String coursedetails) {
        this.coursedetails = coursedetails;
    }

    public Long getCourseid(){
        return courseid;
    }

    public void setCourseid(Long courseid) {
        this.courseid = courseid;
    }
    public String getCoursename(){
        return coursename;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
