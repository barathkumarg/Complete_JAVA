package serialization;


/*
Serialze the Object using the objectinput / objet output stream

write back the result in file using filestream

* */


import java.io.*;

class CustomClass implements Serializable {

    private int num;
    private String str;
    private double db;

    CustomClass(int num, String str, double db) {
        this.num = num;
        this.str = str;
        this.db = db;

    }

    @Override
    public String toString() {
        return "CustomClass{" +
                "num=" + num +
                ", str='" + str + '\'' +
                ", db=" + db +
                '}';
    }
}

public class SerialDeserialize {
    public static void main(String[] args) {


        //object serialization

        try(ObjectOutputStream objoutstream = new ObjectOutputStream(new FileOutputStream("serial.txt"))){

               CustomClass obj = new CustomClass(1,"barath",2.345);
               System.out.println(obj);
               objoutstream.writeObject(obj);

        }catch(Exception e){
            System.out.println(e);
        }

        //object deserialization
        try(ObjectInputStream objinstream = new ObjectInputStream(new FileInputStream("serial.txt"))){

            CustomClass myobj;
            myobj = (CustomClass) objinstream.readObject();
            System.out.println(myobj);

        }catch(Exception e){
            System.out.println(e);
        }


    }
}
