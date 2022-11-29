package ru.volkov.threads;

import java.util.concurrent.Semaphore;

public class Main {
    public static Semaphore sem = new Semaphore(4);
    public static void main(String[] args) {
        new Thread(new MyThread("A", sem)).start();
    }
}