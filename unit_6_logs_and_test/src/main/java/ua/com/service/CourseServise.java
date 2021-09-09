package ua.com.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ua.com.dao.CourseDao;
import ua.com.db.CoursesDB;
import ua.com.entity.Course;
import ua.com.entity.Students;

public class CourseServise {

    private static final Logger LOGGER_INFO = LoggerFactory.getLogger("info");
    private static final Logger LOGGER_WARN = LoggerFactory.getLogger("warn");

    public void createCourse(Course course){
        LOGGER_INFO.info("create new user: " + course.getNameCourse());
        CourseDao.
    }


    public void updateCourse(Course course){

    }


    public void deleteCourse(String id){

    }


    public Course findCourseById(String id){

    }


    public Course[] findAllCourse(){

    }


    public void addStudentInList(){
        CoursesDB.getInstance().addStudentInList();
    }


    public void deleteStudentInList(){
        CoursesDB.getInstance().deleteStudentInList();
    }


    public Students[] findListStudentByCourseID(String id){
        return CoursesDB.getInstance().findListStudentByCourseID(id);
    }
}
