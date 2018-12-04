package es.heavensgat.model.aufgaben.collectionsundgenericsa;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Aufgabe2 {
    public static void main(String[] args) {
        List<String> namen = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i<5; i++){
            System.out.print("Namen eingeben: ");
            namen.add(scanner.next());
        }
        print(namen, "--- Eingabe ---");
        int benedikts = Collections.frequency(namen, "benedikt");
        benedikts += Collections.frequency(namen, "Benedikt");
        System.out.println("\"Benedikt\" frequency: " + benedikts);
        Collections.sort(namen);
        print(namen, "--- Sortiert ---");
        System.out.println("bald gelöschter an stelle 3: " + namen.remove(3));
        print(namen, "--- Nach löschung ---");
    }

    private static void print(List<String> namen, String header) {
        System.out.println(header);
        for(String name:namen){
            System.out.println(name);
        }
    }
}
