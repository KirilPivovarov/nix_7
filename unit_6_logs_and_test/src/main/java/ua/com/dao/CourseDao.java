package ua.com.dao;

import ua.com.controllers.CourseController;
import ua.com.entity.Course;
import ua.com.entity.Students;

public interface CourseDao {

    void createCourse(Course course);

    void updateCourse(Course course);

    void deleteCourse(String id);

    Course findCourseById(String id);

    Course[] findAllCourse();

    Students[] addStudentInList(Course course, String studentId);

    Students[] deleteStudentInList(Course course, String studentId);

    Students[] findListStudentByCourseID(String id);
}
