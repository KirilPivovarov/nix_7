package ua.com.db;

import ua.com.entity.Course;
import ua.com.entity.Students;

import java.util.Arrays;
import java.util.UUID;

public class StudentsDB {

    private static int SIZE = 10;

    private Students[] studentsDB = new Students[SIZE];
    private Course[] listCourse = new Course[SIZE];
    private int indexForStudent = 0;
    private int indexForList = 0;

    private static StudentsDB instance;

    Course course = new Course();
    Students students = new Students();
    CoursesDB coursesDB = new CoursesDB();

    protected StudentsDB() {}

    public static StudentsDB getInstance() {
        if (instance == null) {
           instance = new StudentsDB();
       }
        return instance;
    }

    public void createStudents(Students student) {
        if (studentsDB[studentsDB.length - 1] != null) {
            increaseArray();
        }
        student.setId(generateId());
        studentsDB[indexForStudent] = student;
        indexForStudent++;
    }

    public void updateStudents(Students student) {
        Students current = findStudentsById(student.getId());
        current.setFirstName(student.getFirstName());
        current.setLastName(student.getLastName());
    }

    public void deleteStudents(String id) {
        int indexStudent = getIndexById(id);
        studentsDB[indexStudent] = null;
        rebuildArray(studentsDB.length);
    }

    public Students findStudentsById(String id) {
        for(int i = 0; i < studentsDB.length; i++) {
            if (studentsDB[i].getId().equals(id)){
                return studentsDB[i];
            }
        }
        return null;
    }

    public Students[] findAllStudents() {
        Students[] students;
        if (indexForStudent > 0) {
            students = Arrays.copyOfRange(studentsDB, 0, indexForStudent);
        } else {
            students = null;
        }
        return students;

    }

    public void addCourseInList(){
        listCourse = students.getStudentsCourses();
        if (listCourse[listCourse.length - 1] != null) {
            increaseArrayForList();
        }
            listCourse[indexForList] = coursesDB.findCoursesById(course.getId());
            indexForList++;
        students.setStudentsCourses(listCourse);
    }

    public void deleteCourseInList(){
        listCourse = students.getStudentsCourses();
        int indexForCourse = getIndexById(course.getId());
        listCourse[indexForCourse] = null;
        rebuildArrayForList(listCourse.length);
        students.setStudentsCourses(listCourse);
    }

    public Course[] findListCoursesByStudentID(String id){
        Students student = findStudentsById(id);
        return student.getStudentsCourses();
    }

    private String generateId() {
        String id = UUID.randomUUID().toString();
        for (int i = 0; i < studentsDB.length; i++) {
            if (studentsDB[i].getId().equals(id)) {
                return generateId();
            }
        }
        return id;
    }

    private void increaseArray() {
        int newLength = studentsDB.length + (studentsDB.length >> 1);
        rebuildArray(newLength);
    }

    private void rebuildArray(int newLength) {
        Students[] newStudentDb = new Students[newLength];
        int indexCount = 0;
        for (int i = 0; i < studentsDB.length; i++) {
            if (studentsDB[i] != null) {
                newStudentDb[indexCount] = studentsDB[i];
                indexCount++;
            }
        }
        studentsDB = newStudentDb;
        indexForStudent = indexCount;
    }

    private int getIndexById(String id) {
        for (int i = 0; i < studentsDB.length; i++) {
            if (studentsDB[i] != null && studentsDB[i].getId() == id) {
                return i;
            }
        }
        return -1;
    }


    private void increaseArrayForList() {
        int newLength = listCourse.length + (listCourse.length >> 1);
        rebuildArray(newLength);
    }

    private void rebuildArrayForList(int newLength) {
        Course[] newCourseList = new Course[newLength];
        int indexCount = 0;
        for (int i = 0; i < listCourse.length; i++) {
            if (listCourse[i] != null) {
                newCourseList[indexCount] = listCourse[i];
                indexCount++;
            }
        }
        listCourse = newCourseList;
        indexForList = indexCount;
    }

}
