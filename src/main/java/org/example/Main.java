package org.example;

public class Main {

    public static void main(String[] args) {
        Runnable runnable = new NewState();
        Thread t = new Thread(runnable);
        System.out.println(t.getState());
        t.start();
        System.out.println(t.getState());
    }

}
