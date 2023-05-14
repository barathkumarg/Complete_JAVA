package text_wrappers;

public class TextWrapper {
    public static void main(String[] args) {
        Integer intobj = Integer.valueOf(10);  //conversion of int to integer object
        System.out.println(intobj);

        int i = intobj.intValue();
        System.out.println(i); // conversion back to integer from object.


        //auto boxing and unboxing feature introduced in jdk 5
        i = Integer.valueOf(10);
        intobj = 10;


    }
}
