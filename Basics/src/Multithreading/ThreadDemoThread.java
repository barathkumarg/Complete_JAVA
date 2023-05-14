package Multithreading;


class NewThread extends Thread{
    NewThread(){
        super("Demothread"); //Passing the new thread name
        System.out.println("New thread started");
    }
    @Override
    public void run(){
        try {
            for (int i = 0; i < 5; i++) {
                System.out.println("New thread executing " + i);
                Thread.sleep(1000);
            }
        }
        catch(InterruptedException e){
            System.out.println("New thread Interrupted ");
            }

    }
}
public class ThreadDemoThread {

    public static void main(String[] args) {
        NewThread newthread  = new NewThread();
        newthread.start();


        //Main thread execution
        try{
            for (int i=0;i<5;i++){
                System.out.println("Main thread executing"+i);
                Thread.sleep(1000);
            }
        }
        catch(InterruptedException e1){
            System.out.println("Main thread Interrupted");
        }
    }

}
