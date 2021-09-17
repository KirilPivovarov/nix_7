package ua.com.dao.Impl;

import ua.com.dao.StudentDao;
import ua.com.db.StudentsDB;
import ua.com.entity.Course;
import ua.com.entity.Students;

public class StudentDaoImpl implements StudentDao {

    @Override
    public void createStudents(Students student) {
        StudentsDB.getInstance().createStudents(student);
    }

    @Override
    public void updateStudents(Students student) {
      StudentsDB.getInstance().updateStudents(student);
    }

    @Override
    public void deleteStudents(String id) {
       StudentsDB.getInstance().deleteStudents(id);
    }

    @Override
    public Students findStudentsById(String id) {
       return StudentsDB.findStudentsById(id);
    }

    @Override
    public Students[] findAllStudents() {
        return StudentsDB.getInstance().findAllStudents();
    }

    @Override
    public Course[] addCourseInList(Students student, String CourseId){
      return StudentsDB.getInstance().addCourseInList(student, CourseId);
    }

    @Override
    public Course[] deleteCourseInList(Students student, String CourseId){
      return StudentsDB.getInstance().deleteCourseInList(student, CourseId);
    }

    @Override
    public Course[] findListCoursesByStudentID(String id){
      return StudentsDB.getInstance().findListCoursesByStudentID(id);
    }

}
