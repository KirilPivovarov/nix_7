package ua.com.controllers;

import ua.com.dao.StudentDao;
import ua.com.db.StudentsDB;
import ua.com.entity.Course;
import ua.com.entity.Students;
import ua.com.service.Impl.StudentServiceImpl;
import ua.com.service.StudentService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class StudentController {

    private static final StudentService studentService = new StudentServiceImpl();

    public void start() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Select your option");
        String position;
        try {
            runNavigation();
            while ((position = reader.readLine()) != null) {
                crud(position, reader);
                position = reader.readLine();
                if (position.equals("0")) {
                    break;
                }
                crud(position, reader);
            }
        } catch (IOException e) {
            System.out.println("problem: = " + e.getMessage());
        }
    }

    private void runNavigation() {
        System.out.println();
        System.out.println("if you want create student, please enter 1");
        System.out.println("if you want update student, please enter 2");
        System.out.println("if you want delete student, please enter 3");
        System.out.println("if you want findById student, please enter 4");
        System.out.println("if you want findAll student, please enter 5");
        System.out.println("if you want findCoursesById student, please enter 6");
        System.out.println("if you want deleteCourseInList student, please enter 7");
        System.out.println("if you want exit, please enter 0");
        System.out.println();
    }

    private void crud(String position, BufferedReader reader) {
        switch (position) {
            case "1":
                createStudents(reader);
                break;
            case "2":
                updateStudents(reader);
                break;
            case "3":
                deleteStudents(reader);
                break;
            case "4":
                findStudentsById(reader);
                break;
            case "5":
                findAllStudents();
                break;
            case "6":
                findListCoursesByStudentID(reader);
                break;
            case "7":
                deleteCourseInList(reader);
                break;
        }
        runNavigation();
    }

    private void createStudents(BufferedReader reader) {
        System.out.println("StudentController.create");
        try {
            System.out.println("Please, enter your firstName");
            String firstName = reader.readLine();
            System.out.println("Please, enter your lastName");
            String lastName = reader.readLine();

            System.out.println("");
            Students student1 = new Students();
            student1.setFirstName(firstName);
            student1.setLastName(lastName);
                studentService.createStudent(student1);
               System.out.println("Our ID: " + student1.getId());
            System.out.println("If you want to attach a course to a student enter 1");
            System.out.println("otherwise enter 0");
            String choise = reader.readLine();
            switch (choise){
                case "1" : {
                    System.out.println("Enter id of the course you want add or null to stop");
                    while (true) {
                        System.out.print("ID : ");
                        String CoursesId = reader.readLine();
                        if(CoursesId.equals("null")){
                            break;
                        }
                        studentService.addCourseInList(student1, CoursesId);
                    }
                }
                case "0" :
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void updateStudents(BufferedReader reader){
        System.out.println("StudentController.update");
        try {
            System.out.println("Please, enter id");
            String id = reader.readLine();
            System.out.println("Please, enter your first name");
            String firstName = reader.readLine();
            System.out.println("Please, enter your last name");
            String lastName = reader.readLine();
            Students student = studentService.findStudentByID(id);
            student.setFirstName(firstName);
            student.setLastName(lastName);
            studentService.updateStudent(student);
            System.out.println("If you want to attach a course to a student enter 1");
            System.out.println("otherwise enter 0");
            String choose = reader.readLine();
            switch (choose){
                case "1" : {
                    System.out.println("Enter id of the course you want add or null to stop");
                    while (true) {
                        System.out.print("ID : ");
                        String CoursesId = reader.readLine();
                        if(CoursesId.equals("null")){
                            break;
                        }
                        studentService.addCourseInList(student, CoursesId);
                    }
                }
                case "0" :
            }
        } catch (IOException e) {
            System.out.println("problem: = " + e.getMessage());
        }
    }

    public void deleteStudents(BufferedReader reader){
        System.out.println("StudentController.delete");
        try {
            System.out.println("Please, enter id");
            String id = reader.readLine();
            studentService.deleteStudent(id);
        } catch (IOException e) {
            System.out.println("problem: = " + e.getMessage());
        }
    }


    public void findStudentsById(BufferedReader reader) {
        System.out.println("StudentController.findById");
        try {
            System.out.println("Please, enter id");
            String id = reader.readLine();
            System.out.println(studentService.findStudentByID(id).toString());
        } catch (IOException e) {
            System.out.println("problem: = " + e.getMessage());
        }
    }

    private void findAllStudents() {
        System.out.println("StudentController.findAll");
        Students[] students = studentService.findAllStudents();
        if(students == null){
            System.out.println("students do not exist");
        }else {
            for (Students student : students) {
                if (student != null) {
                    System.out.println(student);
                }
            }
        }
    }

    private void findListCoursesByStudentID(BufferedReader reader) {
        System.out.println("findListCoursesByStudentID");
        try {
            System.out.println("Enter your ID: ");
            String id = reader.readLine();
            Course[] courses = studentService.findListCoursesByStudentID(id);
            for (Course course : courses) {
                if(course != null) {
                    System.out.println(course);
                }
            }
        }catch (IOException e) {
            System.out.println("problem: = " + e.getMessage());
        }
    }

    private void deleteCourseInList(BufferedReader reader){
        System.out.println("deleteCourseInList");
        try{
            System.out.println("enter id Student with list course");
            System.out.print("ID Student: ");
            String idStudent = reader.readLine();
            Students student = studentService.findStudentByID(idStudent);
            System.out.println("enter the ID of the course you want to delete");
            String CourseId = reader.readLine();
            studentService.deleteCourseInList(student, CourseId);
        }catch (IOException e){
            System.out.println("problem: = " + e.getMessage());
        }
    }

}