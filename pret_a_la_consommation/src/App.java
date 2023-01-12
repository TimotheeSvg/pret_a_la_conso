import business.Pret;


import java.util.*;
import java.time.LocalDate;
import java.time.Month;

public class App {
    public static void main(String[] args) {
        Map<Integer,String> map = new HashMap<Integer,String>();
        LocalDate date = LocalDate.of(2014, Month.JANUARY, 1);
        map.put(10000, date);

        for (Map.Entry<Integer,String> entry : map.entrySet()){
            System.out.println("id = " + entry.getKey() +
                    ", Value = " + entry.getValue());
        }
    }
}