package Collections;

import java.util.Iterator;
/*
 Creating the custom collections on array list
* */
public class CustomCollection {

    public static void main(String[] args) {
        GenericList<Integer> list = new GenericList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.display();

        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
