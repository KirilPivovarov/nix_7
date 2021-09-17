package ua.com;

import org.junit.jupiter.api.*;
import ua.com.entity.Course;
import ua.com.entity.Students;
import ua.com.service.Impl.StudentServiceImpl;
import ua.com.service.StudentService;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class StudentsDBTest {

    private final static StudentService studentService = new StudentServiceImpl();
    private final static int STUDENTS_SIZE = 10;

    @BeforeAll
    public static void setUp() {
        for (int i = 0; i < STUDENTS_SIZE; i++) {
            Students student = StudentGeneretionUtil.generateStudent(StudentGeneretionUtil.NAME + i);
            studentService.createStudent(student);
        }
        Assertions.assertEquals(STUDENTS_SIZE, studentService.findAllStudents().length);
    }

    @AfterAll
    public static void clearAll(){
        Students[] students = studentService.findAllStudents();
        for (Students student: students) {
            studentService.deleteStudent(student.getId());
        }
    }

    @Test
    @Order(0)
    public void createStudent() {
        Students user = StudentGeneretionUtil.generateStudent("lastName");
        studentService.createStudent(user);
        Students[] students = studentService.findAllStudents();
        Assertions.assertEquals(STUDENTS_SIZE + 1, students.length);
    }

    @Test
    @Order(1)
    public void findAll() {
        Students[] students = studentService.findAllStudents();
        Assertions.assertEquals(STUDENTS_SIZE + 1, students.length);
    }

    @Test
    @Order(2)
    public void delete() {
        Students[] students = studentService.findAllStudents();
        Assertions.assertEquals(STUDENTS_SIZE + 1, students.length);
        for (int i = 0; i < 5; i++) {
            studentService.deleteStudent(students[i].getId());
        }
        students = studentService.findAllStudents();
        Assertions.assertEquals(STUDENTS_SIZE - 4, students.length);
    }


}
