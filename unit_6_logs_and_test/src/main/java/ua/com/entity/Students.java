package ua.com.entity;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Students {

    private static final int SIZE = 10;

    private String firstName;
    private String lastName;
    private String id;
    private Course[] studentsCourses = new Course[SIZE];
    private int indexForCourses = 0;


    @Override
    public String toString() {
        return "student with the first name : " + firstName + " and the last name : " + lastName + " has an ID " + id;
    }
}