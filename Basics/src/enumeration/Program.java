package enumeration;

import java.util.Random;

enum Decisions {YES,NO,NONE};

class Questions{
    Random rand = new Random();
    Decisions answer(){
        Double random_number = rand.nextDouble() * 100;

        if (random_number < 25){
            return Decisions.NONE;
        }
        else if(random_number < 50) {
            return Decisions.NO;
        }
        return Decisions.NONE;
    }
}

public class Program {
    static void display(Decisions result){
        switch(result){
            case YES:
                System.out.println("Yes");
                break;
            case NO:
                System.out.println("no");
                break;
            case NONE:
                System.out.println("None");
                break;
        }
    }


    public static void main(String[] args) {
        Questions q = new Questions();
        display(q.answer());
    }

}
