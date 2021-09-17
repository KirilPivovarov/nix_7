package ua.com.service;

import ua.com.entity.Course;
import ua.com.entity.Students;

public interface StudentService {

     void createStudent(Students students);

     void updateStudent(Students students);

     void deleteStudent(String id);

     Students findStudentByID(String id);

     Students[] findAllStudents();

     Course[] addCourseInList(Students student, String CoursesId);

     Course[] deleteCourseInList(Students student, String CoursesId);

     Course[] findListCoursesByStudentID(String id);
}
