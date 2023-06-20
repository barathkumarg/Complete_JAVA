package ConcurrentStreams;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
As the collection can be converted to the streams same can occur in reverse manner
where the stream can be converted to collection after the filter or map operation

* */


class NameEmailPhone {
    public String name;
    public String email;
    public String phone;
    NameEmailPhone(String name, String email, String phone){
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NameEmailPhone that = (NameEmailPhone) o;
        return Objects.equals(name, that.name) && Objects.equals(email, that.email) && Objects.equals(phone, that.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, email, phone);
    }
}

class NamePhone{
    public String name;

    public String phone;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NamePhone namePhone = (NamePhone) o;
        return Objects.equals(name, namePhone.name) && Objects.equals(phone, namePhone.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, phone);
    }

    NamePhone(String name, String phone){
        this.name = name;
        this.phone = phone;
    }

}


public class StreamstoCollection {
    public static void main(String[] args) {
        ArrayList<NameEmailPhone> mylist = new ArrayList<>();

        //creating the objects
        mylist.add(new NameEmailPhone("barath","barath@gmail.com","123-435-678"));
        mylist.add(new NameEmailPhone("barath","barath@gmail.com","123-435-678"));
        mylist.add(new NameEmailPhone("anoos","anoos@gmail.com","987-345-768"));
        mylist.add(new NameEmailPhone("Dhanush","dhanusg@gmail.com","678-456-980"));

        //filter out the name and phone and store it in stream
        Stream mystream = mylist.stream().map((n) -> (new NamePhone(n.name,n.phone)));

        //converted back to collection as list from stream
        List<NamePhone> modifiedlist = (List<NamePhone>) mystream.collect(Collectors.toList());

        //printing the result
        for (NamePhone obj:modifiedlist) {
            System.out.println("Name :"+obj.name + " Phone: "+obj.phone);
        }


        //Using the set as collection type
        //recreation of stream

        System.out.println("\n Set result");
        Stream mysetstream = mylist.stream().map((n) -> (new NamePhone(n.name,n.phone)));


        Set<NamePhone> modifiedset = (Set<NamePhone>) mysetstream.collect(Collectors.toSet());

        //printing the result
        for (NamePhone obj:modifiedset) {
            System.out.println("Name :"+obj.name + " Phone: "+obj.phone);
        }




    }
}
