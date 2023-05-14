package oops_basics;

public class oops_static {

    static int a = 10;

    static{
        System.out.println("The value of a is "+ a);
    }

    static void calculate(int a){
        System.out.println("Inside static method "+ a);
    }

    public static void main(String[] args) {
        System.out.println("Inside main");
        calculate(12);

    }
}
//output
/*The value of a is 10
Inside main
Inside static method 12
 */