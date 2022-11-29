package ru.volkov.threads;

import java.util.concurrent.Semaphore;

public class ThreadRunner {
    private static boolean p1 = false;
    private static boolean p2 = false;
    private static boolean p3 = false;
    private static boolean k = false;
    public static void RunP1(Semaphore sem) {
        if (p1) return;
        p1 = true;
        System.out.print("\n");
        new Thread(new MyThread("B", sem)).start();
        new Thread(new MyThread("C", sem)).start();
        new Thread(new MyThread("I", sem)).start();
        new Thread(new MyThread("J", sem)).start();
    }
    public static void RunP2(Semaphore sem) {
        if (p2) return;
        p2 = true;
        System.out.print("\n");
        new Thread(new MyThread("D", sem)).start();
        new Thread(new MyThread("E", sem)).start();
        new Thread(new MyThread("F", sem)).start();
    }
    public static void RunP3(Semaphore sem) {
        if (p3) return;
        p3 = true;
        System.out.print("\n");
        new Thread(new MyThread("G", sem)).start();
        new Thread(new MyThread("H", sem)).start();
    }
    public static void RunK(Semaphore sem) {
        if (k) return;
        k = true;
        System.out.print("\n");
        new Thread(new MyThread("K", sem)).start();
    }
}
