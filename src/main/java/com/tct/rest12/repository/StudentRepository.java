package com.tct.rest12.repository;

import com.tct.rest12.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    @Query( nativeQuery = true, value = "Select * from student s where s.name = :name")
    Optional<Student> findStudentByName(@Param("name") String name);

    @Query(nativeQuery = true, value = "Select * from student")
    Optional<List<Student>> getAllStudents();

    @Modifying
    @Query(nativeQuery = true, value = "Update student " +
                                         "SET name=:name, surname=:surname, age=:age, department_id=:departmentId " +
                                            "WHERE id_student=:id")
    void updateStudent(@Param("name") String name, @Param("surname") String surname, @Param("age") Integer age,
                       @Param("departmentId") Integer departmentId, @Param("id") Integer id);

    @Query(nativeQuery = true, value = " select * from student s " +
            "join department d on d.department_id=s.department_id " +
            "join course c on c.department_id=d.department_id " +
            "where c.id_course =:id")
    Optional<List<Student>> getStudentsByCourseId(@Param("id") Integer id);
}
