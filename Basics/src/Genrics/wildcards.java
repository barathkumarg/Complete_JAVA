package Genrics;


// WIld card here used to compare the object equals check for the 2 different class Generics


class CustomArray<T extends Number>{

    T[] obj;
    CustomArray(T[] obj){
        this.obj = obj;
    }

    //To display the contents
    void display(){
        for(T arr: obj){
            System.out.println(arr);
        }
    }


    //Compute the average
    double compute(){
        double result = 0.0 ;
        for (T t : obj) {
            result += t.doubleValue();
        }
        return result / obj.length;
    }


    //use of wild cards here....
    void compare(CustomArray <?> cobj){
        if (compute() == cobj.compute()){
            System.out.println("Same result");
        }
        else{
            System.out.println("Not same");
        }
    }




}
public class wildcards {
    public static void main(String[] args) {

        Integer [] num = {1,2,3,4,5};
        Double [] dnum = {1.0,2.0,3.0,4.0,5.0};

    CustomArray<Integer> iobj = new CustomArray<>(num);
    CustomArray<Double> dobj = new CustomArray<>(dnum);

    iobj.compare(dobj);


    }
}
