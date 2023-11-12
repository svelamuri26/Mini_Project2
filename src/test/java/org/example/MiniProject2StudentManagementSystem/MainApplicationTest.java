package org.example.MiniProject2StudentManagementSystem;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.Map;

public class MainApplicationTest {

    @Test
    public void testEnrollStudentInCourse() {
        Student student = new Student("S101", "John Doe");
        Course course = new Course("C101", "Mathematics");

        MainApplication.enrollStudentInCourse(student, course);

        assertTrue(student.getEnrolledCourses().contains(course));
        assertTrue(course.getEnrolledStudents().contains(student));
    }

    @Test
    public void testDisplayStudentDetails() {
        Student student = new Student("S101", "John Doe");


        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        MainApplication.displayStudentDetails(student);


        System.setOut(System.out);

        String expectedOutput = "Student details:\n" +
                "Student{studentId='S101', name='John Doe', grade={}}\n" +
                "Enrolled courses: []\n" +
                "Grades: {}\n\n";

        assertEquals(expectedOutput, outputStream.toString());
    }

    @Test
    public void testDisplayCourseDetails() {
        Course course = new Course("C101", "Mathematics");


        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        MainApplication.displayCourseDetails(course);


        System.setOut(System.out);

        String expectedOutput = "Course details:\n" +
                "Course{courseId='C101', name='Mathematics'}\n" +
                "Enrolled students: []\n" +
                "Student Grades: {}\n\n";

        assertEquals(expectedOutput, outputStream.toString());
    }



}
