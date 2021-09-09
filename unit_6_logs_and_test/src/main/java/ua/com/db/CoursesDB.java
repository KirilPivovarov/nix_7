package ua.com.db;

import ua.com.entity.Course;
import ua.com.entity.Students;

import java.util.Arrays;
import java.util.UUID;

public class CoursesDB {

    private static int SIZE = 10;

    private Course[] courseDB = new Course[SIZE];
    private Students[] listStudents = new Students[SIZE];
    private int indexForCourse = 0;
    private int indexForStudent = 0;

    Students students = new Students();
    Course course = new Course();
    StudentsDB studentsDB = new StudentsDB();

    private static CoursesDB instance;

    protected CoursesDB() {}

    public static CoursesDB getInstance() {
        if (instance == null) {
            instance = new CoursesDB();
        }
        return instance;
    }

    public void createCourse(Course course) {
        if(courseDB[courseDB.length - 1] != null) {
            increaseArray();
        }
        course.setId(generateId());
        courseDB[indexForCourse] = course;
        indexForCourse++;

    }

    public void updateCourse(Course course) {
        Course current = findCoursesById(course.getId());
        current.setNameCourse(course.getNameCourse());

    }

    public void deleteCourse(String id) {
        int indexStudent = getIndexById(id);
        courseDB[indexStudent] = null;
        rebuildArray(courseDB.length);
    }

    public Course findCoursesById(String id) {
        for(int i = 0; i < courseDB.length; i++) {
            if (courseDB[i].getId().equals(id)){
                return courseDB[i];
            }
        }
        return null;

    }

    public Course[] findAllCourse() {
        Course[] course;
        if (indexForCourse > 0) {
            course = Arrays.copyOfRange(courseDB, 0, indexForCourse);
        } else {
            course = null;
        }
        return course;
    }

    public void addStudentInList(){
        listStudents = course.getStudentsInCourses();
        if (listStudents[listStudents.length - 1] != null) {
            increaseArrayForStudent();
        }
        listStudents[indexForStudent] = studentsDB.findStudentsById(students.getId());
        indexForStudent++;
        course.setStudentsInCourses(listStudents);
    }

    public void deleteStudentInList(){
        listStudents = course.getStudentsInCourses();
        int indexForCourse = getIndexById(students.getId());
        listStudents[indexForCourse] = null;
        rebuildArrayForStudent(listStudents.length);
       course.setStudentsInCourses(listStudents);
    }

    public Students[] findListStudentByCourseID(String id){
        Course course = findCoursesById(id);
        return course.getStudentsInCourses();
    }


    private String generateId() {
        String id = UUID.randomUUID().toString();
        for (int i = 0; i < courseDB.length; i++) {
            if (courseDB[i].getId().equals(id)) {
                return generateId();
            }
        }
        return id;
    }

    private void increaseArray() {
        int newLength = courseDB.length + (courseDB.length >> 1);
        rebuildArray(newLength);
    }

    private void rebuildArray(int newLength) {
        Course[] newCourseDb = new Course[newLength];
        int indexCount = 0;
        for (int i = 0; i < courseDB.length; i++) {
            if (courseDB[i] != null) {
                newCourseDb[indexCount] = courseDB[i];
                indexCount++;
            }
        }
        courseDB = newCourseDb;
        indexForCourse = indexCount;
    }

    private int getIndexById(String id) {
        for (int i = 0; i < courseDB.length; i++) {
            if (courseDB[i] != null && courseDB[i].getId() == id) {
                return i;
            }
        }
        return -1;
    }

    private void increaseArrayForStudent() {
        int newLength = listStudents.length + (listStudents.length >> 1);
        rebuildArray(newLength);
    }

    private void rebuildArrayForStudent(int newLength) {
        Students[] newListStudent = new Students[newLength];
        int indexCount = 0;
        for (int i = 0; i < listStudents.length; i++) {
            if (listStudents[i] != null) {
                listStudents[indexCount] = listStudents[i];
                indexCount++;
            }
        }
        listStudents = newListStudent;
        indexForStudent = indexCount;
    }

}
