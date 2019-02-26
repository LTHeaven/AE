package es.heavensgat.model.aufgaben.factorymethod.spielwelt.factory;

import es.heavensgat.model.aufgaben.factorymethod.spielwelt.model.Pflanze;
import es.heavensgat.model.aufgaben.factorymethod.spielwelt.model.Tier;
import es.heavensgat.model.aufgaben.factorymethod.spielwelt.model.Untergrund;

public abstract class SpielweltFabrik {
    public abstract Tier createTier();
    public abstract Untergrund createUntergrund();
    public abstract Pflanze createPflanze();
}
