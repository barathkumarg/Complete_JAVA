package Collections;


/*
here the on comparing the objects is equal are not for custom created class it fails because by default it points to the
hashcode generated in heap will not point the value
 */


import java.util.HashSet;
import java.util.Set;

public class SetEqualsProblem {

    public static void main(String[] args) {
        Set<Student> student = new HashSet<>();

        student.add(new Student(20,30));
        student.add(new Student(10,40));
        student.add(new Student(100,90));


        //interanlly calls the hashcode and equals method
        System.out.println(student.contains(new Student(20,30)));
    }

}
