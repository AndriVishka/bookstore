package com.tct.rest12.service;

import com.tct.rest12.entities.Course;
import com.tct.rest12.exceptions.TCTException;
import com.tct.rest12.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    CourseRepository repository;

    public void saveCourse(Course course){
        repository.save(course);
    }

    public List<Course> getCoursesByStudentId(Integer id) throws TCTException {

        Optional<List<Course>> optList = repository.getCoursesByStudentId(id);


        if(optList.isPresent()){
            return optList.get();
        }

        throw new TCTException("Nuk ka kurse per kete student!!!");

    }
}
