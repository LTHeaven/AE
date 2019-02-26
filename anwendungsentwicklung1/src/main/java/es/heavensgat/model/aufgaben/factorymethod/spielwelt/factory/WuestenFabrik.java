package es.heavensgat.model.aufgaben.factorymethod.spielwelt.factory;

import es.heavensgat.model.aufgaben.factorymethod.spielwelt.model.*;

public class WuestenFabrik extends SpielweltFabrik {
    @Override
    public Kamel createTier() {
        return new Kamel();
    }

    @Override
    public Sand createUntergrund() {
        return new Sand();
    }

    @Override
    public Kaktus createPflanze() {
        return new Kaktus();
    }
}
