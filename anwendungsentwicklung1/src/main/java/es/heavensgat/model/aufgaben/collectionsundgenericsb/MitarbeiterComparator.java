package es.heavensgat.model.aufgaben.collectionsundgenericsb;

import es.heavensgat.model.rollins.mitarbeiter.Mitarbeiter;

import java.util.Comparator;

public class MitarbeiterComparator implements Comparator<Mitarbeiter> {
    @Override
    public int compare(Mitarbeiter o1, Mitarbeiter o2) {
        return Double.compare(o1.einkommen(), o2.einkommen());
    }
}
