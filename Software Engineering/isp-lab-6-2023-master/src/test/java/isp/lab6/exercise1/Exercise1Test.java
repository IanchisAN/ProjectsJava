package isp.lab6.exercise1;
import org.junit.Test;
import java.util.List;
import static org.junit.Assert.*;

public class Exercise1Test {
    @Test
    public void testStudentList() {
        // Create a student list
        StudentList studentList = new StudentList();

        // Add some students
        studentList.addStudent(new Student("Alice", 1));
        studentList.addStudent(new Student("Bob", 2));

        // Test removing a student
        studentList.removeStudent(2);
        List<Student> students = studentList.getStudents();
        assertEquals(students.size(), 1);
        assertEquals(students.get(0).getName(), "Alice");

        // Test updating a student's name
        studentList.updateStudent(1, "Carol");
        students = studentList.getStudents();
        assertEquals(students.size(), 1);
        assertEquals(students.get(0).getName(), "Carol");

        // Test calculating the average grade of a student
        Student student = new Student("Alice", 1);
        student.addGrade("Math", 90);
        student.addGrade("Science", 80);
        double expectedAverage = (90.0 + 80.0) / 2.0;
        assertEquals(student.getAverageGrade(), expectedAverage, 0.01);

        // Test adding and getting a student's grades
        student.addGrade("English", 85);
        assertEquals(student.getAverageGrade(), (90.0 + 80.0 + 85.0) / 3.0, 0.01);
        assertEquals(student.toString(), "Name: Alice\nID: 1\nGrades: {English=85, Science=80, Math=90}");
    }
}