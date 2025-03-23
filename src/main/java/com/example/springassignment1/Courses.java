package com.example.springassignment1;
import org.jetbrains.annotations.NotNull;


public class Courses {

    @NotNull
    private String name;

    @NotNull
    private String description;

    public Courses(String name, String description){
        this.name = name;
        this.description = description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getDescription() {
        return description;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
