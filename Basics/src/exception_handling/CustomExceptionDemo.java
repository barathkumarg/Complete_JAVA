package exception_handling;

public class CustomExceptionDemo{
    static void function (int num) throws CustomException{
            if (num > 10){
                throw new CustomException("Value greater then 10");
            }
            else{
                System.out.println("Execution Successful");
            }


    }
    public static void main(String[] args){

        try {
            function(11);
        }
        catch(Exception e){
            System.out.println(e);
        }

    }
}
