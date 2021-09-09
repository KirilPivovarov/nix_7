package ua.com.dao.Impl;

import ua.com.dao.CourseDao;
import ua.com.db.CoursesDB;
import ua.com.entity.Course;
import ua.com.entity.Students;

public class CourseDaoImpl implements CourseDao {

    @Override
    public void createCourse(Course course){
        CoursesDB.getInstance().createCourse(course);
    }

    @Override
    public void updateCourse(Course course){
        CoursesDB.getInstance().updateCourse(course);
    }

    @Override
    public void deleteCourse(String id){
        CoursesDB.getInstance().deleteCourse(id);
    }

    @Override
    public Course findCourseById(String id){
       return CoursesDB.getInstance().findCoursesById(id);
    }

    @Override
    public Course[] findAllCourse(){
        return CoursesDB.getInstance().findAllCourse();
    }

    @Override
    public void addStudentInList(){
        CoursesDB.getInstance().addStudentInList();
    }

    @Override
    public void deleteStudentInList(){
        CoursesDB.getInstance().deleteStudentInList();
    }

    @Override
    public Students[] findListStudentByCourseID(String id){
        return CoursesDB.getInstance().findListStudentByCourseID(id);
    }

}
