package com.tct.rest12.repository;

import com.tct.rest12.entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {

    @Query(nativeQuery = true, value = "select * from department")
    Optional<List<Department>> getDepartments();

    @Modifying
    @Query(nativeQuery = true, value = "update department Set name = :name " +
            "where department_id = :departmentId")
    Integer updateDepartment(@Param("name")String name,
                                          @Param("departmentId")Integer id);
}
