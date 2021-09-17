package ua.com;

import ua.com.entity.Course;

public class CourseGeneretionUtil {

    public static final String NAME = "testName";

    public static Course generateCourse() {
        Course course = new Course();
        course.setNameCourse(NAME);
        return course;
    }

    public static Course generateCourse(String name, int credit) {
        Course course = new Course();
        course.setNameCourse(name);
        return course;
    }

    public static Course generateCourse(String name) {
        Course course = new Course();
        course.setNameCourse(name);
        return course;
    }
}
