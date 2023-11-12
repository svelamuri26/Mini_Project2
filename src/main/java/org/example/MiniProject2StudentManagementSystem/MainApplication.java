package org.example.MiniProject2StudentManagementSystem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Calendar;

public class MainApplication {

    public static void main(String[] args) {

        Student student1 = new Student("S101", "John Doe");
        Student student2 = new Student("S102", "Jane Doe");


        Course course1 = new Course("C101", "Mathematics");
        Course course2 = new Course("C102", "Programming");


        enrollStudentInCourse(student1, course1);
        enrollStudentInCourse(student1, course2);
        enrollStudentInCourse(student2, course2);


        displayStudentDetails(student1);
        displayCourseDetails(course2);


        List<Student> students = new ArrayList<>();
        students.add(student2);
        students.add(student1);

        MainApplication.sortStudentsByName(students);
        System.out.println("Students sorted by name:");
        students.forEach(System.out::println);


        String studentNameToSearch = "John Doe";
        Student foundStudent = MainApplication.searchStudentByName(students, studentNameToSearch);
        System.out.println("Found student by name '" + studentNameToSearch + "': " + foundStudent);


        User adminUser = new Admin("admin", "admin123");
        User teacherUser = new Teacher("teacher", "teacher123");
        User studentUser = new StudentUser("student", "student123");


        displayUserRole(adminUser);
        displayUserRole(teacherUser);
        displayUserRole(studentUser);
    }

    private static Student searchStudentByName(List<Student> students, String studentNameToSearch) {
    return null;
    }

    private static void sortStudentsByName(List<Student> students) {
    }

    public static void enrollStudentInCourse(Student student, Course course) {
        student.getEnrolledCourses().add(course);
        course.getEnrolledStudents().add(student);
    }

    public static void displayStudentDetails(Student student) {
        System.out.println("Student details:");
        System.out.println(student);
        System.out.println("Enrolled courses: " + student.getEnrolledCourses());
        System.out.println("Grades: " + student.getGrades());
        System.out.println();
    }

    public static void displayCourseDetails(Course course) {
        System.out.println("Course details:");
        System.out.println(course);
        System.out.println("Enrolled students: " + course.getEnrolledStudents());
        System.out.println("Student Grades: " + course.getStudentGrades());
        System.out.println();
    }

    private static void displayUserRole(User user) {
        user.displayRole();
    }
}


class User {
    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public void displayRole() {
        System.out.println("Role: User");
    }
}

class Admin extends User {
    public Admin(String username, String password) {
        super(username, password);
    }

    @Override
    public void displayRole() {
        System.out.println("Role: Admin");
    }
}

class Teacher extends User {
    public Teacher(String username, String password) {
        super(username, password);
    }

    @Override
    public void displayRole() {
        System.out.println("Role: Teacher");
    }
}

class StudentUser extends User {
    public StudentUser(String username, String password) {
        super(username, password);
    }

    @Override
    public void displayRole() {
        System.out.println("Role: Student");
    }
}
