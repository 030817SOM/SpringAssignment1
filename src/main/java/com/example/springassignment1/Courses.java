package com.example.springassignment1;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table
public class Courses {

    @Size(min = 1,max = 5,message = "course id cannot be more than 5")
    @NotBlank(message = "course id connot be blank")
    @Column
    private int courseid;

    @Column
    @NotBlank(message = "Course name cannot be blank")
    @Size(min = 3,max = 100,message = "Course name must at least between 3 and 100 characters")
    private String coursename;

    @Column
    @Size(min = 5,message = "Description must have at least 5 characters")
    @NotBlank(message = "Description cannot be blank")
    private String description;

    public int getCourseid(){
        return courseid;
    }

    public void setCourseid(int courseid) {
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
