package exception_handling;

public class ThrowsDemo {
    static void function() throws ArithmeticException{
        int a = 2/0;
    }
    public static void main(String[] args) {

        try {
            function();
            System.out.println("After exception function");
        }catch (Exception e){
            System.out.println("Divide by zero");
        }
        System.out.println("After");
    }
}
