package es.heavensgat.model.aufgaben.threads.aufgabe1;

public class CounterCommand implements Runnable {
    @Override
    public void run() {
        int i = 0;
        while (true) {
            System.out.println(Thread.currentThread().getName() + "(" + Thread.currentThread().getPriority() + "): " + i++);
            try {
                Thread.sleep(900);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
