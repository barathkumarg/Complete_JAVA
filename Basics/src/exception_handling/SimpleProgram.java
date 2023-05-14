package exception_handling;

public class SimpleProgram {
    public static void main(String[] args) {
        int a = 12;
        try{
            int b = a/0;
            System.out.println("Non printable statement"); // Unable to print this line
        }
        catch(Exception e){
            System.out.println(e);
        }
        System.out.println("After Exception");
    }
}
/*
Output:
java.lang.ArithmeticException: / by zero
After Exception
*/