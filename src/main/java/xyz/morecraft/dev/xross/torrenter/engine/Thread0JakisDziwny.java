package xyz.morecraft.dev.xross.torrenter.engine;

public abstract class Thread0JakisDziwny implements Runnable {
    private Thread0JakisDziwny thread0JakisDziwny;
    private String threadName;

    Thread0JakisDziwny(String name) {
        String
     threadName = name;
        System.out.println("Creating" + threadName);
    }

    @Override
    public void run() {
        System.out.println("Running" + threadName);
    }
}
