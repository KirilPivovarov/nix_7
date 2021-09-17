package ua.com.db;

import ua.com.entity.Course;
import ua.com.entity.Students;

import java.util.Arrays;
import java.util.UUID;

public class CoursesDB {

    private static final int SIZE = 10;

    private static Course[] courseDB = new Course[SIZE];
    private int indexForCourse = 0;
    private static CoursesDB instance;

    private CoursesDB() {}

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
        int indexCourse = getIndexById(course.getId());
        if(indexCourse < 0){
            System.out.println("exception");
        }else {
            courseDB[indexCourse].setNameCourse(course.getNameCourse());
        }

    }

    public void deleteCourse(String id) {
        int indexStudent = getIndexById(id);
        if(indexStudent < 0){
            System.out.println("exception");
        }else {
            courseDB[indexStudent] = null;
            rebuildArray(courseDB.length);
        }
    }

    public static Course findCoursesById(String id) {
        int indexCourse = instance.getIndexById(id);
        if(indexCourse == -1){
            return instance.createExceptionCourse(id);
        }else {
            return courseDB[indexCourse];
        }

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

    public Students[] addStudentInList(Course course, String studentId){
        if (course.getStudentsInCourses()[course.getStudentsInCourses().length - 1] != null) {
            increaseArrayForStudent(course);
        }
        course.getStudentsInCourses()[course.getIndexForStudent()] = StudentsDB.findStudentsById(studentId);
        course.setIndexForStudent(course.getIndexForStudent() + 1);
        return course.getStudentsInCourses();
    }

    public Students[] deleteStudentInList(Course course, String studentId){
        int indexForCourse = getIndexById(studentId);
        if(indexForCourse >= 0) {
            course.getStudentsInCourses()[indexForCourse] = null;
            rebuildArrayForStudent(course.getStudentsInCourses().length,course);
        }
        return course.getStudentsInCourses();
    }

    public Students[] findListStudentByCourseID(String id){
        Course course = findCoursesById(id);
        return course.getStudentsInCourses();
    }


    private String generateId() {
        String id = UUID.randomUUID().toString();
        for (Course course : courseDB) {
            if (course != null) {
                if (course.getId().equals(id)) {
                    return generateId();
                }
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
        for (Course course : courseDB) {
            if (course != null) {
                newCourseDb[indexCount] = course;
                indexCount++;
            }
        }
        courseDB = newCourseDb;
        indexForCourse = indexCount;
    }

    private int getIndexById(String id) {
        for (int i = 0; i < courseDB.length; i++) {
            if (courseDB[i] != null && courseDB[i].getId().equals(id)) {
                return i;
            }
        }
        return -1;
    }

    private void increaseArrayForStudent(Course course) {
        int newLength = course.getStudentsInCourses().length + (course.getStudentsInCourses().length >> 1);
        rebuildArrayForStudent(newLength, course);
    }

    private void rebuildArrayForStudent(int newLength, Course course) {
        Students[] newListStudent = new Students[newLength];
        int indexCount = 0;
        for (Students student : course.getStudentsInCourses()) {
            newListStudent[indexCount] = student;
            indexCount++;
        }
        course.setStudentsInCourses(newListStudent);
        course.setIndexForStudent(indexCount);
    }

    private Course createExceptionCourse(String id){
       Course foundCourse = new Course();
        foundCourse.setNameCourse("Course with this id  not found" );
        foundCourse.setId(id);
        return foundCourse;
    }
}

