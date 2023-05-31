package ExecutorFramework;

import java.util.concurrent.*;

public class RejectScenario {
    public static void main(String[] args) {

        //setting the thread max pool and keep alive time to restrict the thread execution
        ExecutorService service = new ThreadPoolExecutor(8, 20, 120, TimeUnit.SECONDS, new ArrayBlockingQueue<>(50));


        try {
            for (int i = 0; i < 110; i++) {
                service.execute(new NewThreadSpawn("Thread " + i));
            }
        }catch (RejectedExecutionException e){
            System.out.println("Thread Rejected");
            }

        service.shutdown();
        }


   }


