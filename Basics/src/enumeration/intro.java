package enumeration;

import java.util.Arrays;

public class intro {
    enum months {Monday,Tuesday,Wednesday,Thrusday,Friday,Saturday,Sunday }
    public static void main(String[] args) {
        months month;
        month = months.Monday;

        System.out.println(month);

        //values method  ->  Array of all values
        System.out.println(Arrays.toString(months.values()));

    }
}
