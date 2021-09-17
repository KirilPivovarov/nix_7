package ua.com.service.Impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.com.dao.Impl.StudentDaoImpl;
import ua.com.dao.StudentDao;
import ua.com.entity.Course;
import ua.com.entity.Students;
import ua.com.service.StudentService;

public class StudentServiceImpl implements StudentService {

    private static final Logger LOGGER_INFO = LoggerFactory.getLogger("info");
    private static final Logger LOGGER_WARN = LoggerFactory.getLogger("warn");

    private static final StudentDao studentDao = new StudentDaoImpl();

    @Override
    public void createStudent(Students student){
        LOGGER_INFO.info("create new student: " + student.getFirstName() + " "+ student.getLastName());
            studentDao.createStudents(student);
    }

    @Override
    public void updateStudent(Students students){
        LOGGER_INFO.info("update student: " + students.getFirstName() + " "+ students.getLastName());
        studentDao.updateStudents(students);
    }

    @Override
    public void deleteStudent(String id){
        LOGGER_WARN.warn("Student was removed. ID: " + id);
        studentDao.deleteStudents(id);
    }

    @Override
    public Students findStudentByID(String id) {
        try {
            LOGGER_INFO.info("find student with Id: " + id);
            return studentDao.findStudentsById(id);
        }catch (NullPointerException e){
            LOGGER_WARN.warn("Student with ID: " + id + " not found");
            return createExceptionStudent(id);
        }
    }

    @Override
    public Students[] findAllStudents(){
        return studentDao.findAllStudents();
    }

    @Override
    public Course[] addCourseInList(Students student, String CourseId){
           return studentDao.addCourseInList(student, CourseId);
    }

    @Override
    public Course[] deleteCourseInList(Students student, String CourseId){
        return studentDao.deleteCourseInList(student, CourseId);
    }

    @Override
    public Course[] findListCoursesByStudentID(String id){
        return studentDao.findListCoursesByStudentID(id);
    }

    private Students createExceptionStudent(String id){
        Students foundStudent = new Students();
        foundStudent.setFirstName("Exception");
        foundStudent.setLastName("Student with this id not found");
        foundStudent.setId(id);
        return foundStudent;
    }


}
