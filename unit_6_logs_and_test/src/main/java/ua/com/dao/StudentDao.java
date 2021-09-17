package ua.com.dao;

import ua.com.db.StudentsDB;
import ua.com.entity.Course;
import ua.com.entity.Students;

public interface StudentDao {

     void createStudents(Students student) ;

     void updateStudents(Students student);

     void deleteStudents(String id);

     Students findStudentsById(String id);

     Students[] findAllStudents();

     Course[] addCourseInList(Students student, String CoursesId);

     Course[] deleteCourseInList(Students student, String CoursesId);

     Course[] findListCoursesByStudentID(String id);

}
