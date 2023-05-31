package lang.clone;


class TestClone implements Cloneable{

    public int a = 9;
    public int b = 10;

    TestClone doclone(){
        try{
            return (TestClone) super.clone();
        }catch(CloneNotSupportedException e){
            System.out.println("Clone exception");
        }
        return this;
    }
}
public class CloneObjects {
    public static void main(String[] args) {
        TestClone object1 = new TestClone();
        TestClone object2;

        object1.a = 0;
        object1.b = 0;

        //object 2 takes the value as the first object changed not from the class level object
        object2 = object1.doclone();
        System.out.println("Accessing the object1 data "+ object1.a +" "+object1.b);
        System.out.println("Accessing the object2 data "+ object2.a +" "+object2.b);


    }
}
