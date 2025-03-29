package com.example.springassignment1;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Courses {
    @Id
    @Column
    private int courseid;
    @Column
    private String coursename;
    @Column
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
