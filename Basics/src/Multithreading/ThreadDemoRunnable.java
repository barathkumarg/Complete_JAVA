package Multithreading;



/*
* As mentioned that the runnable interface internally calls the thread to execute and run methid overrides the implementaion.
*
*
*
*
* */
class Newthread implements Runnable{

Thread thread;
Newthread(){
    thread = new Thread(this,"NewThread");
    System.out.println("New thread created");
}

    @Override
    public void run() {
    try{
        for(int i=0;i<5;i++){
            System.out.println("Child Thread Execution :" +i);
            Thread.sleep(1000);
        }
    }
    catch(InterruptedException e){
        System.out.println("New thread Interrupted......");
    }
    finally {
        System.out.println("New thread Cleaning up.....");
    }
    }
}

public class ThreadDemoRunnable {
    public static void main(String[] args) {
        Newthread newthread = new Newthread();
        newthread.thread.start(); //start method internally calls run

        //Main thread Execution
        try{
            for(int i =0;i<5;i++){
                System.out.println("Main Thread Execution "+i);
                Thread.sleep(1000);
            }
        }
        catch(InterruptedException e1){
            System.out.println("Main Thread Interrupted "+ e1);

        }
        finally {
            System.out.println("Main thread clean up");
        }

    }
}

/* OUTPUT:
 * New thread created
 * Child Thread Execution :0
 * Main Thread Execution 0
 * Child Thread Execution :1
 * Main Thread Execution 1
 * Child Thread Execution :2
 * Main Thread Execution 2
 * Child Thread Execution :3
 * Main Thread Execution 3
 * Child Thread Execution :4
 * Main Thread Execution 4
 * New thread Cleaning up.....
 * Main thread clean up
 */

