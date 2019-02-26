package es.heavensgat.model.aufgaben.observerpattern;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class NewsObservable {
    private List<NewsObserver> observersList = new ArrayList<>();

    private void updateSport(){
        for (NewsObserver observer : observersList) {
            observer.notifySport();
        }
    }

    private void updatePolitics(){
        for (NewsObserver observer : observersList) {
            observer.notifyPolitics();
        }
    }

    private void updateEconomy(){
        for (NewsObserver observer : observersList) {
            observer.notifyEconomy();
        }
    }

    private void addObserver(NewsObserver observer) {
        this.observersList.add(observer);
    }

    private boolean removeObserver(NewsObserver observer){
        return this.observersList.remove(observer);
    }
}
