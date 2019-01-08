package es.heavensgat.model.aufgaben.threads.aufgabe1;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Thread dateCommand = new DateCommand();
        Thread counterCommand = new Thread(new CounterCommand());
        dateCommand.setName("DateCommand");
        counterCommand.setName("CounterCommand");
        dateCommand.setDaemon(true);
        counterCommand.setDaemon(true);
        dateCommand.start();
        counterCommand.start();
        while (true){
            System.out.println("MainThread(" + Thread.currentThread().getPriority() + ")");
            Thread.sleep(500);
        }
    }
}
