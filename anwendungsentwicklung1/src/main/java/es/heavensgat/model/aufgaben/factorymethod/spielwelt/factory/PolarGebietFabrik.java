package es.heavensgat.model.aufgaben.factorymethod.spielwelt.factory;

import es.heavensgat.model.aufgaben.factorymethod.spielwelt.model.*;

public class PolarGebietFabrik extends SpielweltFabrik {
    @Override
    public Eisbaer createTier() {
        return new Eisbaer();
    }

    @Override
    public Schnee createUntergrund() {
        return new Schnee();
    }

    @Override
    public SchneeBlume createPflanze() {
        return new SchneeBlume();
    }
}
