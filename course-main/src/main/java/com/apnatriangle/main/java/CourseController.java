package com.apnatriangle.main.java;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {
    @GetMapping("/hello")
    public String getHelloMessage() {
        return "Hello World!!\n";
    }

    @GetMapping("/course/{courseCode}")
    public Course getCourse(@PathVariable String courseCode)
    {
        Course course = new Course("java101", "Java Language Fundamentals");
        return course;
    }
}
