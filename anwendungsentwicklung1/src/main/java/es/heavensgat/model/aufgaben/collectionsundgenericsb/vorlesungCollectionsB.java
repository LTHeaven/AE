package es.heavensgat.model.aufgaben.collectionsundgenericsb;

import es.heavensgat.model.rollins.mitarbeiter.Buerohengst;
import es.heavensgat.model.rollins.mitarbeiter.Malocher;
import es.heavensgat.model.rollins.mitarbeiter.Manager;
import es.heavensgat.model.rollins.mitarbeiter.Mitarbeiter;

import java.util.*;

public class vorlesungCollectionsB {
    public static void main(String[] args) {
        Buerohengst buerohengst = new Buerohengst(1, "Mein starker Hengst", 5000);
        Malocher malocher = new Malocher(2, "Dreckiger Malocher", 10);
        Manager manager = new Manager(3, "Rich bitch", 6000, 10000);

        try {

        } catch (Exception e) {
            e.printStackTrace();
        }
        Set<Mitarbeiter> setMitarbeiter = new TreeSet<>();
        setMitarbeiter.add(buerohengst);
        setMitarbeiter.add(malocher);
        setMitarbeiter.add(manager);
//        ArrayList<Mitarbeiter> arrListMitarbeiter = new ArrayList<Malocher>(); //funktioniert nicht, da eine collection eines bestimmten typs auch mit diesem initialisiert werdfen muss
//        arrListMitarbeiter.add(buerohengst);
//        arrListMitarbeiter.add(malocher);
//        arrListMitarbeiter.add(manager);
        List<Mitarbeiter> listMitarbeiter = new ArrayList<>();
        listMitarbeiter.add(buerohengst);
        listMitarbeiter.add(malocher);
        listMitarbeiter.add(manager);
//        LinkedList<Buerohengst> liliBuerohengst = new LinkedList<Manager>(); //siehe oben
//        liliBuerohengst.add(buerohengst);
//        liliBuerohengst.add(malocher);
//        liliBuerohengst.add(manager);
        List<Buerohengst> listBuerohengst = new LinkedList<>();
        listBuerohengst.add(buerohengst);
//        listBuerohengst.add(malocher);                                        //malocher leitet nicht von buerohengst ab
        listBuerohengst.add(manager);

//        ausgabe(setMitarbeiter);    //set ist keine liste
        ausgabe(listMitarbeiter);
//        ausgabe(listBuerohengst);
    }

    private static void ausgabe(List<Mitarbeiter> list) {
        for (Mitarbeiter m : list) {
            System.out.println(m.toString());
        }
    }
}
