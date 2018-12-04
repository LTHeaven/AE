package es.heavensgat.model.aufgaben.collectionsundgenericsb;

import es.heavensgat.model.rollins.mitarbeiter.Buerohengst;
import es.heavensgat.model.rollins.mitarbeiter.Malocher;
import es.heavensgat.model.rollins.mitarbeiter.Manager;
import es.heavensgat.model.rollins.mitarbeiter.Mitarbeiter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Aufgabe1 {
    public static void main(String[] args) {
        Buerohengst buerohengst = new Buerohengst(1, "Mein starker Hengst", 5000);
        Malocher malocher = new Malocher(2, "Dreckiger Malocher", 10);
        Manager manager = new Manager(3, "Immer diese CEOs", 6000, 1.99);
        List<Mitarbeiter> list = new ArrayList<>();
        list.add(buerohengst);
        list.add(malocher);
        list.add(manager);
        Collections.sort(list);
        System.out.println("--- Inner sort ---");
        for (Mitarbeiter m : list){
            System.out.println(m.getID());
        }
        System.out.println("--- Comparator sort ---");
        Collections.sort(list, new MitarbeiterComparator());
        for (Mitarbeiter m : list){
            System.out.println(m.getID());
        }
    }
}
