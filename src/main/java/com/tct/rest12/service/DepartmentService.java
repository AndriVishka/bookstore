package com.tct.rest12.service;

import com.tct.rest12.entities.Course;
import com.tct.rest12.entities.Department;
import com.tct.rest12.exceptions.TCTException;
import com.tct.rest12.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {

    @Autowired
    DepartmentRepository repository;

    public void saveDepartment(Department department){

        repository.save(department);
    }

    public List<Department> getAll() throws TCTException {
        Optional<List<Department>>list = repository.getDepartments();

        if (list.isPresent()){
            return list.get();
        } throw new TCTException("No Departments!!!");
    }

    public Department findById(Integer id)throws TCTException{
        Optional<Department> dpt = repository.findById(id);

        if (dpt.isPresent()){
            return dpt.get();
        } throw new TCTException("No such department!!!");
    }
    @Transactional
    public Integer updateDepartment(Department dep) throws TCTException{

        repository.save(dep);
      return 1;
    }
    public void deleteDepartment(Department department){
        repository.delete(department);
    }


 }
