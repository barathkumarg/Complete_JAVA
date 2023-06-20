package ConcurrentStreams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class MyfirstStreamExample {
    public static void main(String[] args) {

        //creating the list
        List<Integer> mylist = Arrays.asList(100,25,36);

        //creating the stream
        Stream<Integer> mystream = mylist.stream();

        //fetching thr max value
        Optional<Integer> value = mystream.max(Integer::compare);
        System.out.println("The max value in list using the streams: " + value.get()+ "\n");

        //sorting operations
        //as once stream created cannot be reused so creating the another stream
        System.out.println("Sorted stream");
        Stream<Integer> sortstream = mylist.stream().sorted();

        sortstream.forEach((n) -> System.out.print(n + " "));
        System.out.println("\n");

        //filtering options to pull out the even numbers
        Stream<Integer> filterstream = mylist.stream()
                .filter((n) -> (n%2) == 0);

        System.out.println("Even filtered stream");
        filterstream.forEach((n) -> System.out.print(n + " "));
        System.out.println();


        //reducing operation - involves the operation to reduce to the least nominal value
        Stream<Integer> reducstream = mylist.stream();
        Optional<Integer> reducevalue = reducstream.reduce((m,n) -> { if (n ==0) return m; else return (m*n); });

        System.out.println("Reduced value "+ reducevalue.get() + "\n");

        //Parallel stream the first interface corresponds to accumulator and second argument corresponds to the combiner
        Stream<Integer> parallelstream = mylist.parallelStream();
        int parallelvalue = parallelstream.reduce(1, (m,n)-> (int) (m*Math.sqrt(n)), (m,n)->(m*n));
        System.out.println(parallelvalue);







    }
}

//output:
//
//        The max value in list using the streams: 100
//
//        Sorted stream
//        25 36 100
//
//        Even filtered stream
//        100 36
//        Reduced value 90000
