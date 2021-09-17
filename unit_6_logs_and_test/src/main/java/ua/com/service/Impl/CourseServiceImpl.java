package ua.com.service.Impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ua.com.dao.CourseDao;
import ua.com.dao.Impl.CourseDaoImpl;
import ua.com.db.CoursesDB;
import ua.com.entity.Course;
import ua.com.entity.Students;
import ua.com.service.CourseService;

public class CourseServiceImpl implements CourseService {

    private static final Logger LOGGER_INFO = LoggerFactory.getLogger("info");
    private static final Logger LOGGER_WARN = LoggerFactory.getLogger("warn");

    private CourseDao courseDao = new CourseDaoImpl();

    @Override
    public void createCourse(Course course){
        LOGGER_INFO.info("create new course: " + course.getNameCourse());
        courseDao.createCourse(course);
    }


    @Override
    public void updateCourse(Course course){
        LOGGER_INFO.info("update course: " + course.getNameCourse());
        courseDao.updateCourse(course);
    }


    @Override
    public void deleteCourse(String id){
        LOGGER_WARN.warn("Course was removed. ID: " + id);
        courseDao.deleteCourse(id);
    }


    @Override
    public Course findCourseById(String id){
        try {
            LOGGER_INFO.info("find student with Id: " + id);
            return courseDao.findCourseById(id);
        }catch (NullPointerException e){
            LOGGER_WARN.warn("Student with ID: " + id + " not found");
            return createExceptionStudent(id);
        }
    }


    @Override
    public Course[] findAllCourse(){
        return courseDao.findAllCourse();
    }


    @Override
    public Students[] addStudentInList(Course course, String studentId){
        return courseDao.addStudentInList(course, studentId);
    }


    @Override
    public Students[] deleteStudentInList(Course course, String studentId){
      return CoursesDB.getInstance().deleteStudentInList(course, studentId);
    }


    @Override
    public Students[] findListStudentByCourseID(String id){
        return CoursesDB.getInstance().findListStudentByCourseID(id);
    }

    private Course createExceptionStudent(String id){
        Course foundCourse = new Course();
        foundCourse.setNameCourse("Course with this id not found");
        foundCourse.setId(id);
        return foundCourse;
    }
}
