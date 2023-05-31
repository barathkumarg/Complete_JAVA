package ExecutorFramework;

/*
* Thread executor of Fixed thread pool of size 10 for execution
*
* Included the Callable with future variable to get the result back after on calling the get method.
* */


import java.util.ArrayList;
import java.util.concurrent.*;

public class SingleExecutor {
    public static void main(String[] args) throws Exception{


        //Thread class implementation

        ExecutorService service = Executors.newFixedThreadPool(10);
//        for (int i=0;i<100;i++){
//            service.submit(new NewThreadSpawn("Thread"+i));
//        }


        //Spawn thread using the callable
        ArrayList <Future> futurelist = new ArrayList<Future>();

        //lets submit the 100 tasks to get the random number
        for (int i = 0;i<100;i++){
            Future<Integer> future = service.submit(new NewThreadSpawnCallable()); // Acts as Blocking state
            futurelist.add(future);
        }

        //non dependent tasks can be performed
        System.out.println("Intermediate task");

        for (int i =0; i<100;i++){
            Future future = futurelist.get(i); //here we can add the wait time that is to time till some time for result if not throws the exeception and move on to the next
            System.out.println(future.get());
        }
        service.shutdown();

    }
}
