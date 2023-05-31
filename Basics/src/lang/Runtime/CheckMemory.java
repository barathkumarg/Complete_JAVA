package lang.Runtime;

import java.sql.SQLOutput;

public class CheckMemory {
    public static void main(String[] args) {
        Runtime rt = Runtime.getRuntime(); //get the runtime instance
        System.out.println("Total Memory " + rt.totalMemory());

        //creating the object
        Integer[] arr = new Integer[10000];

        System.out.println("Free Memory "+ rt.freeMemory());
        rt.gc(); // trigger the garbage collection
        System.out.println("Free Memory "+rt.freeMemory());
    }
}
