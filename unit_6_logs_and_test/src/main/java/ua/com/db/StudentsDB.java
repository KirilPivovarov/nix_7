package ua.com.db;

import ua.com.entity.Course;
import ua.com.entity.Students;

import java.util.Arrays;
import java.util.UUID;

public class StudentsDB {

    private static final int SIZE = 10;

    private static Students[] studentsDB = new Students[SIZE];
    private int indexForStudent = 0;
    private static StudentsDB instance;
    private String id;
    private int indexList;

    private StudentsDB() {}

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
        int indexStudent = getIndexById(student.getId());
        if(indexStudent < 0){
            System.out.println("exception");
        }else {
            studentsDB[indexStudent].setFirstName(student.getFirstName());
            studentsDB[indexStudent].setLastName(student.getLastName());
        }
    }

    public void deleteStudents(String id) {
        int indexStudent = getIndexById(id);
        if(indexStudent < 0){
            System.out.println("exception");
        }else {
            studentsDB[indexStudent] = null;
            rebuildArray(studentsDB.length);
        }
    }

    public static Students findStudentsById(String id) {
        int indexStudent = instance.getIndexById(id);
        if(indexStudent == -1){
           return instance.createExceptionStudent(id);
        }else {
            return studentsDB[indexStudent];
        }
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

    public Course[] addCourseInList(Students student, String CourseId){
        if (student.getStudentsCourses()[student.getStudentsCourses().length - 1] != null) {
            increaseArrayForList(student);
        }
            student.getStudentsCourses()[student.getIndexForCourses()] = CoursesDB.findCoursesById(CourseId);
            student.setIndexForCourses(student.getIndexForCourses() + 1);
       return student.getStudentsCourses();
    }

    public Course[] deleteCourseInList(Students student, String CourseId){
        int indexCourses = getIndexById(CourseId);
        if (indexCourses >= 0) {
            student.getStudentsCourses()[indexCourses] = null;
            rebuildArrayForList(student.getStudentsCourses().length,student);
        }
        return student.getStudentsCourses();
    }

    public Course[] findListCoursesByStudentID(String id){
        Students student = findStudentsById(id);
        return student.getStudentsCourses();
    }

    private String generateId() {
        String id = UUID.randomUUID().toString();
        for (Students students : studentsDB) {
            if (students != null) {
                if (students.getId().equals(id)) {
                    return generateId();
                }
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
        for (Students students : studentsDB) {
            if (students != null) {
                newStudentDb[indexCount] = students;
                indexCount++;
            }
        }
        studentsDB = newStudentDb;
        indexForStudent = indexCount;
    }

    private int getIndexById(String id) {
        for (int i = 0; i < studentsDB.length; i++) {
            if (studentsDB[i] != null && studentsDB[i].getId().equals(id)) {
                return i;
            }
        }
        return -1;
    }


    private void increaseArrayForList(Students student) {
        int newLength = student.getStudentsCourses().length + (student.getStudentsCourses().length >> 1);
        rebuildArrayForList(newLength, student);
    }

    private void rebuildArrayForList(int newLength, Students student) {
        Course[] newCourseList = new Course[newLength];
        int indexCount = 0;
        for (Course course : student.getStudentsCourses()) {
            if (course != null) {
                newCourseList[indexCount] = course;
                indexCount++;
            }
        }
        student.setStudentsCourses(newCourseList);
        student.setIndexForCourses(indexCount);
    }


        private Students createExceptionStudent(String id){
            Students foundStudent = new Students();
            foundStudent.setFirstName("Exception");
            foundStudent.setLastName("Student with this id  not found" );
            foundStudent.setId(id);
            return foundStudent;
        }
}
