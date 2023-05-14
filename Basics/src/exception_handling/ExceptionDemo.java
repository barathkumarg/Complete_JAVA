package exception_handling;

public class ExceptionDemo {
    public static void main(String[] args) {
        System.out.println("Before Exception");
        try {
            int b = 2 / 0;
        }
        catch(Exception e){
            System.out.println(e);
        }
        System.out.println("After Exception");
    }
}
