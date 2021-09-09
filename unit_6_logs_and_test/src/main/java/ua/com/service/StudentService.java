package ua.com.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.com.dao.StudentDao;
import ua.com.entity.Students;

import java.util.regex.Pattern;

public class StudentService {

    private static final Logger LOGGER_INFO = LoggerFactory.getLogger("info");
    private static final Logger LOGGER_WARN = LoggerFactory.getLogger("warn");

    private static StudentDao studentDao;

    public void createStudent(Students students){
        LOGGER_INFO.info("create new student: " + students.getFirstName() + " "+ students.getLastName());
        if (!checkName(students.getFirstName()) && !checkName(students.getLastName()))
            LOGGER_WARN.warn("invalid name: " + students.getFirstName() + " " + students.getLastName());
        else studentDao.createStudents(students);
    }

    public void updateStudent(Students students){
        LOGGER_INFO.info("update student: " + students.getFirstName() + " "+ students.getLastName());
        studentDao.updateStudents(students);
    }

    public void deleteStudent(String id){
        LOGGER_WARN.warn("Student was removed. ID: " + id);
        studentDao.deleteStudents(id);
    }

    public Students findStudentByID(String id) {
        try {
            LOGGER_INFO.info("find student with Id: " + id);
            return studentDao.findStudentsById(id);
        }catch (NullPointerException e){
            LOGGER_WARN.warn("Student with ID: " + id + " not found");
            return createExceptionStudent(id);
        }
    }

    public Students[] findAllStudents(){
        return studentDao.findAllStudents();
    }

    public void addCourseInList(){

    }

    public boolean checkName(String name) {
        return Pattern.matches("^[\\p{L} .'-]*$", name);
    }

    private Students createExceptionStudent(String id){
        Students foundStudent = new Students();
        foundStudent.setFirstName("Exception");
        foundStudent.setLastName("Student with this id not found");
        foundStudent.setId(id);
        return foundStudent;
    }

}
