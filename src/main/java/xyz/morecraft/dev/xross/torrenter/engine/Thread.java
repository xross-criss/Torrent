package xyz.morecraft.dev.xross.torrenter.engine;

public abstract class Thread implements Runnable{
    private Thread thread;
    private String threadName;

    Thread(String name){
        String
     threadName = name;
        System.out.println("Creating" + threadName);
    }

    @Override
    public void run() {
        System.out.println("Running" + threadName);
    }
}
