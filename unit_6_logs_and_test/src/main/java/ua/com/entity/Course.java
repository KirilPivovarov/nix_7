package ua.com.entity;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Course {

    private String id;
    private String nameCourse;
    private Students[] studentsInCourses;

}
