package ExecutorFramework;
/*
* As Runnable
*
*
* */
import java.util.concurrent.Callable;
import java.util.Random;

public class NewThreadSpawnCallable implements Callable<Integer> {

    NewThreadSpawnCallable(){
        System.out.println("Initiating");
    }
    @Override
    public Integer call() throws Exception {
        return new Random().nextInt();
    }
}
