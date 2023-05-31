package lang.Processbuilder;

public class Main {
    public static void main(String[] args) {

        try{
        ProcessBuilder process = new ProcessBuilder("python3", "helloworld.py");
            System.out.println("print");
            process.start();
         }catch(Exception e){
            System.out.println("Unable to execute the command");
        }
    }
}
