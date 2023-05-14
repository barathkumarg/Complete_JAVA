package LambdaOperations;

/*
* Lambda expression, used as  simple example
*
*
* */

//Simple example for lambda operator
interface Calculate{
    int factorial(int num);
}


//Lambda operator with generics
interface GenericLambda <T>{
           T dofuncntion(T val);
        }


public class Factorial {
    public static void main(String[] args) {


        //factorial calculation as lambda expression
        Calculate calculate = (n) -> {
            int result = 1;
            for (int i=1;i<=n;i++){
                result*=i;
            }
            return result;
        };

        System.out.println(calculate.factorial(3));



        //Generic type example for string
        GenericLambda <String> lambdastring = (val) -> {
            String result = "";
            for (int i=val.length()-1;i>=0;i--){
                result+=val.charAt(i);
            }
            return result;
        };

        System.out.println(lambdastring.dofuncntion("India"));


        //Generic type example for Integer
        GenericLambda <Integer> lambdaint = (val) -> {
            int value = val;
            int result = 0;
            while(value > 0){
                int lastdigit = value % 10 ;
                result = result * 10 + lastdigit;
                value = value / 10;

            }
            return result;
        };

        System.out.println(lambdaint.dofuncntion(12345));
    }
}
