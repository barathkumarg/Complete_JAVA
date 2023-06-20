package ConcurrentUtils;
/*
 To create the semaphores to locak the resorces so that only thread at a time can access the
 resource
*/

import java.util.concurrent.Semaphore;

class NewThread extends Thread{

    String name;
    Semaphore sem;

    //constructor
    NewThread(String name, Semaphore sem){
        this.name = name;
        this.sem = sem;
    }

    @Override
    public void run(){
        try {
            //acquiring the lock
            sem.acquire();
            System.out.println("Lock acquired for "+ this.name);

            for (int i=0;i<5;i++){
                System.out.println(i);
            }

            System.out.println("Releasing lock for "+this.name);
            sem.release();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }
}

public class Semaphores {
    public static void main(String[] args) {

        Semaphore sem = new Semaphore(1); //permits the n no of threadss to be executed
        new NewThread("Thread1",sem).start();
        new NewThread("Thread2",sem).start();
    }
}
