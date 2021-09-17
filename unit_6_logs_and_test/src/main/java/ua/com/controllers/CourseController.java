package ua.com.controllers;

import ua.com.entity.Course;
import ua.com.entity.Students;
import ua.com.service.CourseService;
import ua.com.service.Impl.CourseServiceImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CourseController {

    private static final CourseService courseService = new CourseServiceImpl();



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
                    return;
                }
                crud(position, reader);
            }
        } catch (IOException e) {
            System.out.println("problem: = " + e.getMessage());
        }
    }

    private void runNavigation() {
        System.out.println();
        System.out.println("if you want create course, please enter 1");
        System.out.println("if you want update course, please enter 2");
        System.out.println("if you want delete course, please enter 3");
        System.out.println("if you want findById course, please enter 4");
        System.out.println("if you want findAll course, please enter 5");
        System.out.println("if you want findStudentsById course, please enter 6");
        System.out.println("if you want  deleteStudentInList, please enter 7");
        System.out.println("if you want exit, please enter 0");
        System.out.println();
    }

    private void crud(String position, BufferedReader reader) {
        switch (position) {
            case "1":
                createCourse(reader);
                break;
            case "2":
                updateCourse(reader);
                break;
            case "3":
                deleteCourse(reader);
                break;
            case "4":
                findCourseById(reader);
                break;
            case "5":
                findAllCourses();
                break;
            case "6":
                findListStudentByCourseID(reader);
                break;
            case"7":
                deleteStudentInList(reader);
                break;
        }
        runNavigation();
    }

    private void createCourse(BufferedReader reader) {
        System.out.println("CourseController.create");
        try {
            System.out.println("Please, enter your name course");
            String nameCourse = reader.readLine();

            System.out.println("");
            Course course = new Course();
            course.setNameCourse(nameCourse);
            courseService.createCourse(course);
            System.out.println("Your ID : " +  course.getId());
            System.out.println("If you want to attach a students to a course enter 1");
            System.out.println("otherwise enter 0");
            String choice = reader.readLine();
            switch (choice){
                case "1" : {
                    System.out.println("Enter id of the course you want add or null to stop");
                    while (true) {
                        System.out.print("ID : ");
                        String studentId = reader.readLine();
                        if(studentId.equals("null")){
                            break;
                        }
                        courseService.addStudentInList(course, studentId);
                    }
                }
                case "0" :
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void updateCourse(BufferedReader reader){
        System.out.println("CourseController.update");
        try {
            System.out.println("Please, enter id");
            String id = reader.readLine();
            System.out.println("Please, enter your name course");
            String nameCourse = reader.readLine();
            Course course = courseService.findCourseById(id);
            course.setId(id);
            course.setNameCourse(nameCourse);
            courseService.updateCourse(course);
            System.out.println("If you want to add a student to a course enter 1");
            System.out.println("otherwise enter 0");
            String choice = reader.readLine();
            switch (choice){
                case "1" : {
                    System.out.println("Enter id of the course you want add or null to stop");
                    while (true) {
                        System.out.print("ID : ");
                        String studentId = reader.readLine();
                        if(studentId.equals("null")){
                            break;
                        }
                        courseService.addStudentInList(course, studentId);
                    }
                }
                case "0" :
            }
        } catch (IOException e) {
            System.out.println("problem: = " + e.getMessage());
        }
    }

    public void deleteCourse(BufferedReader reader){
        System.out.println("CourseController.delete");
        try {
            System.out.println("Please, enter id");
            String id = reader.readLine();
            courseService.deleteCourse(id);
            System.out.println("If you want to delete a course to a student enter 1");
            System.out.println("otherwise enter 0");
            String choice = reader.readLine();
            switch (choice){
                case "1" : {
                    System.out.println("Enter id of the course you want delete or null to stop");
                    while (true) {
                        System.out.print("ID : ");
                        String studentId = reader.readLine();
                        if(studentId.equals("null")){
                            break;
                        }
                        courseService.deleteStudentInList(courseService.findCourseById(id),studentId);
                    }
                }
                case "0" :
            }
        } catch (IOException e) {
            System.out.println("problem: = " + e.getMessage());
        }
    }


    public void findCourseById(BufferedReader reader) {
        System.out.println("CourseController.findById");
        try {
            System.out.println("Please, enter id");
            String id = reader.readLine();
            System.out.println(courseService.findCourseById(id).toString());
        } catch (IOException e) {
            System.out.println("problem: = " + e.getMessage());
        }
    }

    private void findAllCourses() {
        System.out.println("CourseController.findAll");
        Course[] courses = courseService.findAllCourse();
        for (Course course : courses) {
            System.out.println(course.toString());
        }
    }

    private void findListStudentByCourseID(BufferedReader reader) {
        System.out.println("findListStudentsInCourseID");
        try {
            String id = reader.readLine();
            Students[] students = courseService.findListStudentByCourseID(id);
            for (Students student : students) {
                if(student != null) {
                    System.out.println(student.toString());
                }
            }
        }catch (IOException e) {
            System.out.println("problem: = " + e.getMessage());
        }
    }

    private void deleteStudentInList(BufferedReader reader){
        System.out.println("deleteStudentInList");
        try{
            System.out.println("enter id Course with list student");
            System.out.print("ID Course: ");
            String idCourse = reader.readLine();
            Course course = courseService.findCourseById(idCourse);
            System.out.println("enter the ID of the student you want to delete");
            String StudentId = reader.readLine();
            courseService.deleteStudentInList(course, StudentId);
        }catch (IOException e){
            System.out.println("problem: = " + e.getMessage());
        }
    }
}
