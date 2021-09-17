package ua.com.entity;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Course {

    private static final int SIZE = 10;

    private String nameCourse;
    private String id;
    private Students[] studentsInCourses = new Students[SIZE];
    private int indexForStudent = 0;

    @Override
    public String toString() {
        return "Course with name "  + nameCourse + " has an ID " + id;
    }
}
