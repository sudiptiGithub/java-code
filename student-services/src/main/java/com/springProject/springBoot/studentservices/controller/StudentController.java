package com.springProject.springBoot.studentservices.controller;


import com.springProject.springBoot.studentservices.model.Course;
import com.springProject.springBoot.studentservices.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.springProject.springBoot.studentservices.service.StudentService;

import java.util.*;

@RestController
@RequestMapping("api/students")

public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("getAllStudents")
    public List<Student> getAllStudentInfo(){
        return studentService.retrieveAllStudents();
    }

    @GetMapping("{studentId}/courses")
    public List<Course> retrieveCoursesForStudent(@PathVariable String studentId) {
        return studentService.retrieveCourses(studentId);
    }

    @GetMapping("{studentId}/courses/{courseId}")
    public Course retrieveDetailsForCourse(@PathVariable String studentId,
                                           @PathVariable String courseId) {
        return studentService.retrieveCourse(studentId,courseId);
    }

    @PostMapping("{studentId}/course")
    public boolean registerStudentForCourse(
            @PathVariable String studentId, @RequestBody Course newCourse) {
        boolean isAdded = studentService.addCourse(studentId,newCourse);
        return isAdded;

    }

}





//package controller;
//
//import model.Course;
//import model.Student;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
//import service.StudentService;
//
//import java.net.URI;
//import java.util.List;
//
//@RestController
//@RequestMapping("api/students")
//
//public class StudentController {
//
//    @Autowired
//     StudentService studentService;
//
//    @GetMapping("getAllStudents")
//    public List<Student> getAllStudentInfo(){
//        return studentService.retrieveAllStudents();
//    }
//
//    @GetMapping("{studentId}/courses")
//    public List<Course> retrieveCoursesForStudent(@PathVariable String studentId) {
//        System.out.println("avc");
//        return studentService.retrieveCourses(studentId);
//    }
//
//    @GetMapping("{studentId}/courses/{courseId}")
//    public Course retrieveDetailsForCourse(@PathVariable String studentId,
//                                           @PathVariable String courseId) {
//        return studentService.retrieveCourse(studentId,courseId);
//    }
//
//    @PostMapping("{studentId}/courses")
//    public ResponseEntity<Void> registerStudentForCourse(
//            @PathVariable String studentId, @RequestBody Course newCourse) {
//        Course course = studentService.addCourse(studentId,newCourse);
//        if(course == null){
//            return ResponseEntity.noContent().build();
//        }
//
//        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path(
//                "/{id}").buildAndExpand(course.getId()).toUri();
//
//        return ResponseEntity.created(location).build();
//    }
//
//    @RequestMapping("/")
//    public String home() {
//        System.out.println("Hello Home...");
//        return "home.html";
//    }
//
//    @PostMapping("courses")
//    public ResponseEntity<Void> registerStudentForCourse(){
//        return ResponseEntity.noContent().build();
//    }
//
//    }
