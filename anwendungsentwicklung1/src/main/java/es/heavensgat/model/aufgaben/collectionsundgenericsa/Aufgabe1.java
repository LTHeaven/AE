package es.heavensgat.model.aufgaben.collectionsundgenericsa;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Aufgabe1 {
    public static void main(String[] args) {
        List<Double> numbers = new ArrayList<Double>();
        for (int i = 0; i < 5; i++){
            numbers.add(Math.random());
        }
        System.out.println("--- Unsortiert ---");
        for (double d : numbers){
            System.out.println(d);
        }
        Collections.sort(numbers);
        System.out.println("--- Sortiert ---");
        for (double d : numbers){
            System.out.println(d);
        }
        numbers.set(2, 999.);
        Collections.swap(numbers, 0, numbers.size()-1);
        System.out.println("--- Dingsbums ---");
        for (double d : numbers){
            System.out.println(d);
        }

    }
}
