package Collections;


import java.util.*;
import java.util.concurrent.Callable;


//custom comparator
class CustomComparator implements Comparator<Student>{

    @Override
    public int compare(Student t1, Student t2) {
        return t2.english - t1.english;
    }
}

public class PriorityQueueDemo {
    public static void main(String[] args) {
        List<Student> student_list = new ArrayList<>();
        student_list.add(new Student(50,90));
        student_list.add(new Student(90,80));
        student_list.add(new Student(80,70));
        student_list.add(new Student(60,40));

        //create the priority queue to order the student object
        //Note that using the iterating in priority doesn't make sense for ordering the priority

        //here using the comparator to give the priority in terms of tamil marks
        PriorityQueue<Student> pq = new PriorityQueue<>(new CustomComparator());
        pq.addAll(student_list);

        List<Student> top3 = new ArrayList<>();
        int index = 0;

        while (!pq.isEmpty()){

            if (index == 2) break;
            top3.add(pq.poll()); //poll function will pop the element based on priority
            index++;
        }
        System.out.println(top3); //displays the top 3 student based on tamil
        System.out.println(pq);
    }
}
