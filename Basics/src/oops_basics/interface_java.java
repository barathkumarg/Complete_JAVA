package oops_basics;



/* Gives the 100 % abstracttion to the class and its methods */
interface organisation{
    void getname();

}

class section implements organisation{
    @Override
    public void getname(){
        System.out.println("In section");
    }
}


public class interface_java {
    public static void main(String[] args) {
        var obj = new section();
        obj.getname();
    }
}
