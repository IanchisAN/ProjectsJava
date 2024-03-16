package isp.lab6.exercise1;
public class Exercise1 {
    public static void main(String[] args) {
        // Create a student list
        StudentList studentList = new StudentList();

        // Add some students
        studentList.addStudent(new Student("Alice", 1));
        studentList.addStudent(new Student("Bob", 2));

        // Remove a student
        studentList.removeStudent(2);

        // Update a student's name
        studentList.updateStudent(1, "Carol");

        // Print the list of students
        for (Student student : studentList.getStudents()) {
            System.out.println(student);
        }
    }
}
