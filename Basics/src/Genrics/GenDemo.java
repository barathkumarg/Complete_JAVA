package Genrics;

//Creating the custom Generic like the Array list, which it can be used in
// code usability, here can use the Integer and String type for the same class implementation.
class Gen <T>{
    T obj;

    Gen(T obj){
        this.obj = obj;
    }

    Object showtype(){
        return obj.getClass().getName();
    }
}
public class GenDemo {
    public static void main(String[] args) {
        Gen obj = new Gen<Integer>(10);
        System.out.println(obj.showtype());

        Gen sobj = new Gen<String>("String");
        System.out.println(sobj.showtype());
    }
}
