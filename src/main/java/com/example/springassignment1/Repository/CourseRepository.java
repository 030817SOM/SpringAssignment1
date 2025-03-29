package com.example.springassignment1.Repository;
import org.springframework.data.Repository.CrudeRepository;
import com.example.springassignment1.Courses;
    public interface CoursesRepository extends CrudRepository<Courses, integer>
    {

}
