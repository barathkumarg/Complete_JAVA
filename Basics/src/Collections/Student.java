package Collections;

import java.util.Objects;

//custom class to implement the comparable, hash code and equals t implement things
public class Student implements Comparable<Student> {
    int english;
    int tamil;

    @Override
    public boolean equals(Object o) {
        System.out.println("Overridden equals called");
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return english == student.english && tamil == student.tamil;
    }

    @Override
    public int hashCode() {
        return Objects.hash(english, tamil);
    }

    Student(int english, int tamil) {
        this.english = english;
        this.tamil = tamil;
    }

    @Override
    public int compareTo(Student student) {
        return this.english - student.english;
    }

    @Override
    public String toString() {
        return "English: " + english + ", Tamil: " + tamil;
    }
}
