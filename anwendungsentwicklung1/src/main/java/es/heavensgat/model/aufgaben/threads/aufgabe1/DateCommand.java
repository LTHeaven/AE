package es.heavensgat.model.aufgaben.threads.aufgabe1;

import java.time.ZonedDateTime;

public class DateCommand extends Thread {
    @Override
    public void run() {
        while (true){
            System.out.println(this.getName() + "(" + this.getPriority() + "): " + ZonedDateTime.now());
            try {
                Thread.sleep(700);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
