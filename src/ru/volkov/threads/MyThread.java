package ru.volkov.threads;

import java.util.Objects;
import java.util.concurrent.Semaphore;

public class MyThread implements Runnable {
    String name;
    Semaphore sem;
    int counter;

    public MyThread(String name, Semaphore sem) {
        this.name = name;
        this.sem = sem;
        this.counter = 0;
    }

    public void run() {
        try {
            System.out.println(name + " запущен и ожидает семафор");
            sem.acquire();
            System.out.println(name + " занял семафор");
            System.out.println(name + " в семафоре");
            Thread.sleep(1000);
            if (Objects.equals(name, "J")) {
                System.out.println(name + " всё ещё в семафоре. Переменная семафора: " + sem.availablePermits());
                Thread.sleep(2000);
                sem.release();
                System.out.println(name + " освободил семафор. Переменная семафора: " + sem.availablePermits());

            }
            else {
                sem.release();
                System.out.println(name + " освободил семафор. Переменная семафора: " + sem.availablePermits());
            }
            this.counter++;
        } catch (InterruptedException e) {
            System.out.println("Ошибка в потоке " + name + ": " + e);
        }
        switch (name) {
            case "A" -> ThreadRunner.RunP1(sem);
            case "B", "C", "I" -> ThreadRunner.RunP2(sem);
            case "D", "E", "F" -> ThreadRunner.RunP3(sem);
            case "J", "G", "H" ->  ThreadRunner.RunK(sem);
        }
    }
}