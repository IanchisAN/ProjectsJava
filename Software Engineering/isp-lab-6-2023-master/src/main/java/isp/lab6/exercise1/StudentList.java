package isp.lab6.exercise1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StudentList {
    private List<Student> students;

    public StudentList() {
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        this.students.add(student);
    }

    public void removeStudent(int id) {
        Iterator<Student> iterator = this.students.iterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();
            if (student.getId() == id) {
                iterator.remove();
                return;
            }
        }
    }

    public void updateStudent(int id, String name) {
        for (Student student : this.students) {
            if (student.getId() == id) {
                student.name = name;
                return;
            }
        }
    }

    public List<Student> getStudents() {
        return this.students;
    }
}