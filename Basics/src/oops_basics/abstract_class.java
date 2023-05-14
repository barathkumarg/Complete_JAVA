package oops_basics;


/* Gives the  1 - 100% of abstraction to class and methods*/

abstract class Organisation{
    abstract void showname();
    void showorgname(){
        System.out.println("Inside the organisation");
    }
}

class Section extends Organisation{

    @Override
    void showname() {
        System.out.println("Inside the section");
    }
}
public class abstract_class {
    public static void main(String[] args) {
        var obj = new Section();
        obj.showname();
        obj.showorgname();
        System.out.println(obj.toString());
    }
}
