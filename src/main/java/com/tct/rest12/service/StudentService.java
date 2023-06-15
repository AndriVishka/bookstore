package com.tct.rest12.service;

import com.tct.rest12.entities.Student;
import com.tct.rest12.exceptions.TCTException;
import com.tct.rest12.repository.DepartmentRepository;
import com.tct.rest12.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    StudentRepository repository;

    public StudentService(StudentRepository repo){
        this.repository = repo;
    }

    public void saveStudent(Student student){
        repository.save(student);
    }

    public Student findStudentByName(String name) throws TCTException {

        Optional<Student> s = repository.findStudentByName(name);

        if(s.isPresent()){
            return s.get();
        }

        throw new TCTException("Student Not Found");
    }

    public List<Student> getAllStudents() throws TCTException{

        Optional<List<Student>> list = repository.getAllStudents();

        if(list.isPresent()){
            return list.get();
        }

        throw new TCTException("Empty Table");

    }

    public Student getStudentById(Integer idStudent) throws TCTException {

        Optional<Student> student = repository.findById(idStudent);

        if(student.isPresent()){
            return student.get();
        }

        throw new TCTException("Student Not Found");
    }


    @Transactional //kur ben ndryshim ne databaze
    public void updateStudent(Student student)  throws TCTException{
        Optional<Student> student1 = repository.findById(student.getIdStudent());
        if (student1.isPresent()){
            repository.updateStudent(student.getName(), student.getSurname(), student.getAge(),
                    student.getDepartmentId(), student.getIdStudent());
        }
        else {
            throw new TCTException("Student not found");
        }
    }

    @Transactional
    public void deleteStudent(Integer id){
        repository.deleteById(id);
    }

    public List<Student> getStudentsByCourseId(Integer id) throws TCTException{
        Optional<List<Student>> list = repository.getStudentsByCourseId(id);

        if(list.isPresent()){
            return list.get();
        } throw new TCTException("No list of students for this course!!!");

    }
}
