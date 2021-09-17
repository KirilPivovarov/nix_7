package ua.com;

import ua.com.entity.Students;

public class StudentGeneretionUtil {

    public static final String NAME = "test";

    public static Students generateStudent() {
        Students student = new Students();
        student.setFirstName(NAME);
        student.setLastName("lastNameTest");
        return student;
    }

    public static Students generateStudent(String firstName, String lastName) {
        Students student = new Students();
        student.setFirstName(firstName);
        student.setLastName(lastName);
        return student;
    }

    public static Students generateStudent(String lastName) {
        Students student = new Students();
        student.setFirstName(NAME);
        student.setLastName(lastName);
        return student;
    }
}
