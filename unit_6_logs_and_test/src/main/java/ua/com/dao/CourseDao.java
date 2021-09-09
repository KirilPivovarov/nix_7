package ua.com.dao;

import ua.com.entity.Course;
import ua.com.entity.Students;

public interface CourseDao {

    void createCourse(Course course);

    void updateCourse(Course course);

    void deleteCourse(String id);

    Course findCourseById(String id);

    Course[] findAllCourse();

    void addStudentInList();

    void deleteStudentInList();

    Students[] findListStudentByCourseID(String id);
}
