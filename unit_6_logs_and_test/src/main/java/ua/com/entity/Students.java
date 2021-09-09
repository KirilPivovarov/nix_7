package ua.com.entity;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Students {

    private String id;
    private String firstName;
    private String lastName;
    private Course[] studentsCourses;



}
