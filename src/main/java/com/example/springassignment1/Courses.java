package com.example.springassignment1;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.id;
import javax.persistence.Table;

@Entity
@Table
public class Courses {
    @id
    @Column
    private int courseid;
    @Column
    private String coursename;
    @Column

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
}
