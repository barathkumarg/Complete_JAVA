package LambdaOperations;


interface Function{
    int function(int n);
}
public class LambdaVariableCapture {
    public static void main(String[] args) {
        int num = 10;

        Function func = (n) -> {
            int v = num + n;


            return v;
        };
    }
}
