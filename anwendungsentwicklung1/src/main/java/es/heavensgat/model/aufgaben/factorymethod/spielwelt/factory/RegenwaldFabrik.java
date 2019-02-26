package es.heavensgat.model.aufgaben.factorymethod.spielwelt.factory;

import es.heavensgat.model.aufgaben.factorymethod.spielwelt.model.*;

public class RegenwaldFabrik extends SpielweltFabrik {
    @Override
    public Ozelot createTier() {
        return new Ozelot();
    }

    @Override
    public Erde createUntergrund() {
        return new Erde();
    }

    @Override
    public Titanenwurz createPflanze() {
        return new Titanenwurz();
    }
}
