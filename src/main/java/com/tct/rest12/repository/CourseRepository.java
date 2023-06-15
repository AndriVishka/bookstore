package com.tct.rest12.repository;

import com.tct.rest12.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CourseRepository extends JpaRepository<Course,Integer> {

    @Query(nativeQuery = true, value = "Select * from course c join department d on d.department_id = c.department_id " +
            "join student s on s.department_id = d.department_id where s.id_student = :id ")
    Optional<List<Course>> getCoursesByStudentId(@Param("id") Integer id);
}
