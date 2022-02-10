package com.example.association.service;

import com.example.association.domain.Course;
import com.example.association.domain.Student;
import com.example.association.repository.StudentRepository;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Log
@Service
@Profile({"!test"})
public class StudentService {
    private final StudentRepository repository;

    @Autowired
    public StudentService(StudentRepository repository){
        this.repository = repository;
    }

    @PostConstruct
    public void init(){
        saveStudent();
        fetchStudent();
    }

    public void saveStudent(){
        Student student = new Student();
        student.setName("John");
        Course course = new Course();
        course.setName("Physics");

        course.setStudent(student);
        student.setCourse(course);

        repository.save(student);
    }

    public void fetchStudent(){
        log.info("Any student course is "+repository.findAll().stream().findAny().get().getCourse().getName());
    }

}
