package org.example.MiniProject2StudentManagementSystem;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.*;


class Student {
    private String studentId;
    private String name;
    private List<Course> enrolledCourses;
    private Map<Course, Double> grades;

    public Student(String studentId, String name) {
        this.studentId = studentId;
        this.name = name;
        this.enrolledCourses = new ArrayList<>();
        this.grades = new HashMap<>();
    }

    public String getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public List<Course> getEnrolledCourses() {
        return enrolledCourses;
    }

    public Map<Course, Double> getGrades() {
        return grades;
    }

    public static void sortStudentsByName(List<Student> students) {
        Collections.sort(students, Comparator.comparing(Student::getName));
    }

    public static void sortStudentsById(List<Student> students) {
        Collections.sort(students, Comparator.comparing(Student::getStudentId));
    }

    public static Student searchStudentByName(List<Student> students, String name) {
        for (Student student : students) {
            if (student.getName().equalsIgnoreCase(name)) {
                return student;
            }
        }
        return null;
    }

    public static Student searchStudentById(List<Student> students, String studentId) {
        for (Student student : students) {
            if (student.getStudentId().equalsIgnoreCase(studentId)) {
                return student;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId='" + studentId + '\'' +
                ", name='" + name + '\'' +
                ", grade=" + grades +
                '}';
    }
}


class Course {
    private String courseId;
    private String name;
    private List<Student> enrolledStudents;
    private Map<Student, Double> studentGrades;

    public Course(String courseId, String name) {
        this.courseId = courseId;
        this.name = name;
        this.enrolledStudents = new ArrayList<>();
        this.studentGrades = new HashMap<>();
    }

    public String getCourseId() {
        return courseId;
    }

    public String getName() {
        return name;
    }

    public List<Student> getEnrolledStudents() {
        return enrolledStudents;
    }

    public Map<Student, Double> getStudentGrades() {
        return studentGrades;
    }

    public static Course searchCourseByName(List<Course> courses, String name) {
        for (Course course : courses) {
            if (course.getName().equalsIgnoreCase(name)) {
                return course;
            }
        }
        return null;
    }

    public static Course searchCourseById(List<Course> courses, String courseId) {
        for (Course course : courses) {
            if (course.getCourseId().equalsIgnoreCase(courseId)) {
                return course;
            }
        }
        return null;
    }

    public static void sortCoursesByName(List<Course> courses) {
        Collections.sort(courses, Comparator.comparing(Course::getName));
    }

    public static void sortCoursesById(List<Course> courses) {
        Collections.sort(courses, Comparator.comparing(Course::getCourseId));
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseId='" + courseId + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}


    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.METHOD)
    @interface Documentation {
        String value() default "";
        String author() default "Unknown";
    }

    enum UserRole {
        ADMIN("Administrator"),
        TEACHER("Teacher"),
        STUDENT("Student");

        private final String displayName;

        UserRole(String displayName) {
            this.displayName = displayName;
        }

        public String getDisplayName() {
            return displayName;
        }
    }






