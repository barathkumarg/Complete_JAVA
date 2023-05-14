package exception_handling;

public class ThrowDemo {
    static void throws_demo(){
        try {
            throw new NullPointerException("demo");
        }
        catch (Exception e){
            System.out.println("inside");
            throw e;
        }
    }
    public static void main(String[] args) {

        try {
            throws_demo();
        }
        catch(Exception e){
            System.out.println("outside");
        }
    }
}
/*
* OUTPUT:
* java.lang.NullPointerException: demo
*
* nOTE: Every throw here should be handled by catch in its function or parent function.
*
* */