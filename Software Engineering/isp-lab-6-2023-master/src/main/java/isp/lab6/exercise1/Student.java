package isp.lab6.exercise1;
import java.util.HashMap;

public class Student {
    public String name;
    private int id;
    private HashMap<String, Integer> grades;

    public Student(String name, int id) {
        this.name = name;
        this.id = id;
        this.grades = new HashMap<>();
    }

    public String getName() {
        return this.name;
    }

    public int getId() {
        return this.id;
    }

    public void addGrade(String subject, int grade) {
        this.grades.put(subject, grade);
    }

    public void removeGrade(String subject) {
        this.grades.remove(subject);
    }

    public double getAverageGrade() {
        int sum = 0;
        for (int grade : this.grades.values()) {
            sum += grade;
        }
        return (double)sum / this.grades.size();
    }

    public String toString() {
        return "Name: " + this.name + "\nID: " + this.id + "\nGrades: " + this.grades;
    }
}