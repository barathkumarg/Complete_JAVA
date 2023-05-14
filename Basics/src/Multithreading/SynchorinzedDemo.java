package Multithreading;




class NewThreadSpawn extends Thread{
    private String msg;
    public static int count = 0;

    NewThreadSpawn(String msg){
        super("New Thread");
        this.msg = msg;
        System.out.println("New Thread Intialized");
    }

    @Override
    public void run(){
     display(this.msg);
    }

    public synchronized void display(String msg){

        try {
            System.out.println(msg + " Starts");
//            Thread.sleep(1000);
            System.out.println("Inside"+ count++);
            System.out.println(msg + " Completes");
        }
        catch(Exception e){
            System.out.println("Interrupted ....");
        }
    }

}


public class SynchorinzedDemo {
    public static void main(String[] args) {
        NewThreadSpawn thread_1 = new NewThreadSpawn("Thread 1");

        NewThreadSpawn thread_2 = new NewThreadSpawn("Thread 2");

        NewThreadSpawn thread_3 = new NewThreadSpawn("Thread 3");


        thread_1.start();
        thread_2.start();
        thread_3.start();


    }
}

/*
* Output when not used synchornized keyword

New Thread Intialized
New Thread Intialized
New Thread Intialized
Thread 3 Starts
Thread 2 Starts
Thread 1 Starts
Thread 2 Completes
Thread 1 Completes
Thread 3 Completes

When synchornized used
New Thread Intialized
New Thread Intialized
New Thread Intialized
Thread 2 Starts
Thread 3 Starts
Thread 1 Starts
Thread 2 Completes
Thread 3 Completes
Thread 1 Completes  -> compltese in order
* */