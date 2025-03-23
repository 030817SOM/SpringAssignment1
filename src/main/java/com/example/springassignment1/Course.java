package com.example.springassignment1;

public interface Course {

    default Object getDescription() {
        return null;
    }
}
