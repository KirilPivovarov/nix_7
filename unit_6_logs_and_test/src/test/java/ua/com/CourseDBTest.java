package ua.com;

import org.junit.jupiter.api.*;
import ua.com.db.CoursesDB;
import ua.com.entity.Course;
import ua.com.entity.Students;
import ua.com.service.CourseService;
import ua.com.service.Impl.CourseServiceImpl;
import ua.com.service.Impl.StudentServiceImpl;
import ua.com.service.StudentService;

public class CourseDBTest {

    private final static StudentService studentService = new StudentServiceImpl();
    private final static CourseService courseService = new CourseServiceImpl();
    private final static int STUDENTS_SIZE = 15;
    private final static int COURSE_SIZE = 10;

    @BeforeAll
    public static void setUp() {
        String variable = "I";
        for (int i = 0; i < STUDENTS_SIZE; i++) {
            Students student = StudentGeneretionUtil.generateStudent("test" + variable);
            studentService.createStudent(student);
            variable = variable + "I";
        }
        for (int i = 0; i < COURSE_SIZE; i++) {
            Course course = CourseGeneretionUtil.generateCourse("test" + i);
            courseService.createCourse(course);
        }
        Course course = courseService.findAllCourse()[0];
        for(int i = 0; i < STUDENTS_SIZE; i++){
            courseService.addStudentInList(course, studentService.findAllStudents()[i].getId());
        }
        Assertions.assertEquals(COURSE_SIZE, courseService.findAllCourse().length);
    }
    @AfterAll
    public static void clearAll(){
        Course [] courses= courseService.findAllCourse();
        for (Course course: courses) {
            courseService.deleteCourse(course.getId());
        }
        Students[] students = studentService.findAllStudents();
        for (Students student: students) {
            studentService.deleteStudent(student.getId());
        }
    }

    @Test
    @Order(0)
    void getAllCourseObject() {
        Course[] courses = courseService.findAllCourse();
        Assertions.assertEquals(COURSE_SIZE, courses.length);
    }

    @Test
    @Order(1)
    void updateCourse() {
        Course course = courseService.findAllCourse()[0];
        String testName = "TestUpdate";
        course.setNameCourse(testName);
        courseService.updateCourse(course);
        Course courseAfterUpdate = courseService.findCourseById(course.getId());
        Assertions.assertEquals(testName, courseAfterUpdate.getNameCourse());
    }

    @Test
    @Order(2)
    void getCourseByIdWithStudent() {
        Course course = courseService.findAllCourse()[0];
        Students[] studentList = courseService.findListStudentByCourseID(course.getId());
        Assertions.assertEquals(STUDENTS_SIZE, studentList.length);
    }


    @Test
    @Order(3)
    void getCoursesListByStudentOrNull() {
        Students student = studentService.findAllStudents()[0];
        Course[] course = studentService.findListCoursesByStudentID(student.getId());
        Assertions.assertNotEquals(null, course);
    }

    @Test
    @Order(4)
    void createCourse() {
        Course course = CourseGeneretionUtil.generateCourse("testCreate");
        courseService.createCourse(course);
        Course[] courses = courseService.findAllCourse();
        Assertions.assertEquals(COURSE_SIZE, courses.length);

    }

    @Test
    @Order(5)
    void deleteCourseById() {
        Course course = courseService.findAllCourse()[0];
        courseService.deleteCourse(course.getId());
        Course[] courses = courseService.findAllCourse();
        Assertions.assertEquals(COURSE_SIZE - 1 , courses.length);
    }



}
