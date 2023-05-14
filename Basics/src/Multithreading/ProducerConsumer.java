package Multithreading;


/*
* Replicating the Consumer producer problem in java, where to consume the resource after it produced
*
*
*
*
* */
class Queue{
    int n;
    boolean isvalueset = false;
    synchronized void get() {

        while (!isvalueset) {
            System.out.println("Wait state");
            try {

                wait();
            } catch (InterruptedException e) {
                System.out.println("Interrupt...");
            }

        }
        System.out.println("Get element: " + this.n);
        isvalueset=false;
        notify(); //notify the thread to put now

    }
    synchronized void put(int n) {

        while (isvalueset) {
            try{
                wait();
            }
            catch(InterruptedException e){
                System.out.println("Interrupt...");
            }


        }
        this.n = n;

        System.out.println("Put element: " + this.n);
        isvalueset =  true;
        notify();  // notify the waiting thread
    }
}


class Producer extends Thread{
    Queue queue;
    Producer(Queue queue){
        super("ProducerThread");
        System.out.println("Producer Thread Intialized");
        this.queue = queue;
    }

    @Override
    public void run(){
       for (int i=0;i<10;i++){
           queue.put(i);
       }
    }
}

class Consumer extends Thread{
    Queue queue;
    Consumer(Queue queue){
        super("Consumer Thread");
        System.out.println("Consumer Thread Intialized");
        this.queue = queue;
    }

    @Override
    public void run(){
        for (int i=0;i<10;i++) {
            queue.get();
        }
    }
}

public class ProducerConsumer {
    public static void main(String[] args) {
        Queue q = new Queue();
        Producer pthread = new Producer(q);
        Consumer cthread = new Consumer(q);

        pthread.start();
        cthread.start();
    }
}
