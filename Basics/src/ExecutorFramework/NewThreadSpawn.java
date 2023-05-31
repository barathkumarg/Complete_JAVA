package ExecutorFramework;


/*
* Normal thread class to run the the method and implementation
*
*
*
*
* */
public class NewThreadSpawn extends Thread{
    String name;
    NewThreadSpawn(String name){
        super(name);
        this.name = name;
    }

    @Override
    public void run(){
        try{
            System.out.println(name + " Executing" );
            Thread.sleep(1000);
            System.out.println(name+ " Completed");
        }catch(Exception e){
            System.out.println(name+ " got interrupted");
        }
    }
}
