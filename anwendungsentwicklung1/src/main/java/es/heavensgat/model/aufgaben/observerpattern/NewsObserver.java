package es.heavensgat.model.aufgaben.observerpattern;

import java.util.Observer;

public abstract class NewsObserver {
    public abstract void notifySport();
    public abstract void notifyPolitics();
    public abstract void notifyEconomy();
}
