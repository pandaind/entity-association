package com.example.association.service;

import com.example.association.domain.Course;
import com.example.association.domain.Student;
import com.example.association.repository.CourseRepository;
import com.example.association.repository.StudentRepository;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Log
@Service
@Profile({"!test"})
public class CourseService {

    private final CourseRepository repository;

    private final StudentRepository studentRepository;

    @Autowired
    public CourseService(CourseRepository repository, StudentRepository studentRepository){
        this.repository = repository;
        this.studentRepository = studentRepository;
    }

    @PostConstruct
    public void init(){
        saveCourse();
        fetchCourse();
    }

    public void saveCourse(){
        Student student = new Student();
        student.setName("Amy");
        Course course = new Course();
        course.setName("Chemistry");

        course.setStudent(student);
        student.setCourse(course);

        studentRepository.save(student);
        repository.save(course);
    }

    public void fetchCourse(){
        log.info("Any Course Student is "+repository.findAll().stream().findAny().get().getStudent().getName());
    }

}
