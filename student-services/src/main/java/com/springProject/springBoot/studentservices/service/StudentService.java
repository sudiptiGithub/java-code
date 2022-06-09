package com.springProject.springBoot.studentservices.service;

import com.springProject.springBoot.studentservices.model.Course;
import com.springProject.springBoot.studentservices.model.Student;
import org.springframework.stereotype.Component;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

@Component
public class StudentService {

    private static List<Student> students = new ArrayList<>();

    static {
        //Initialize Data
        Course course1 = new Course("Course1", "Spring", "10 Steps", Arrays
                .asList("Learn Maven", "Import Project", "First Example",
                        "Second Example"));
        Course course2 = new Course("Course2", "Spring MVC", "10 Examples",
                Arrays.asList("Learn Maven", "Import Project", "First Example",
                        "Second Example"));
        Course course3 = new Course("Course3", "Spring Boot", "6K Students",
                Arrays.asList("Learn Maven", "Learn Spring",
                        "Learn Spring MVC", "First Example", "Second Example"));
        Course course4 = new Course("Course4", "Maven",
                "Most popular maven course on internet!", Arrays.asList(
                "Pom.xml", "Build Life Cycle", "Parent POM",
                "Importing into Eclipse"));

        Student ranga = new Student("Student1", "Ranga Karanam",
                "Hiker, Programmer and Architect", new ArrayList<>(Arrays
                .asList(course1, course2, course3, course4)));

        Student satish = new Student("Student2", "Satish T",
                "Hiker, Programmer and Architect", new ArrayList<>(Arrays
                .asList(course1, course2, course3, course4)));

        students.add(ranga);
        students.add(satish);
    }

    public List<Student> retrieveAllStudents(){
        return students;
    }

    public Student retrieveStudent(String studentId){
        for (Student student:
             students) {
            if(student.getId().equals(studentId)){
                return student;
            }
        }
        return null;
    }

    public List<Course> retrieveCourses(String studentId){
        Student student = retrieveStudent(studentId);
        if(student == null)
            return null;
        return student.getCourses();
    }

    public Course retrieveCourse(String studentId, String courseId){
        List<Course> courses = retrieveCourses(studentId);
        for (Course course:
             courses) {
            if(course.getId().equals(courseId))
                return course;
        }
        return null;
    }

    private SecureRandom random = new SecureRandom();

    public boolean addCourse(String studentId, Course course){
        Student student = retrieveStudent(studentId);
        if(student == null)
            return false;
        if(retrieveCourse(studentId, course.getId())!=null){
            System.out.println("Course already exists");
            return false;
        }
        student.getCourses().add(course);

        return true;
    }

}
