package ConcurrentUtils;

/*
To control the thread and to exchange the datbetween them using the excnage class

Make the one thread to produce the string and another to print the created string

*/

import java.util.concurrent.Exchanger;
import java.util.concurrent.Semaphore;


//Producer class
class Produce extends Thread{

    String name;
    Exchanger<String> exchange;

    //constructor
    Produce(String name, Exchanger<String> exchange){
        this.name = name;
        this.exchange = exchange;
    }

    @Override
    public void run(){
        String message = new String();
        char chr = 'A';
        try {
            //Producing the string 3 times:
            for (int i=0;i<3;i++){
                for(int j=0;j<5;j++)
                    message+=chr++;

                System.out.println("Message excahnged from "+this.name);
                exchange.exchange(message);
            }
            //excahnge the message


        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }
}



class Consumer extends Thread{
    String name;
    Exchanger<String> exchange;
    //constructor
    Consumer(String name, Exchanger<String> exchange){
        this.name = name;
        this.exchange = exchange;
    }
    @Override
    public void run(){
        String message;
        try {


            for (int i=0;i<3;i++) {
                //Get the message
                message = exchange.exchange(new String()); // exchange the original message with the empty string buffer
                System.out.println(this.name + " Got message " + message);
            }

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}



public class Exchangers {
    public static void main(String[] args) {

        Exchanger <String> exchange = new Exchanger<>(); //permits the n no of threadss to be executed
        new Produce("Thread1",exchange).start();
        new Consumer("Thread2",exchange).start();

    }
}

//output:
//
//        Message excahnged from Thread1
//        Message excahnged from Thread1
//        Thread2 Got message ABCDE
//        Thread2 Got message ABCDEFGHIJ
//        Message excahnged from Thread1
//        Thread2 Got message ABCDEFGHIJKLMNO