package ru.volkov.threads;

import java.util.Objects;
import java.util.concurrent.Semaphore;

public class MyThread implements Runnable {
    String name;
    Semaphore sem;

    public MyThread(String name, Semaphore sem) {
        this.name = name;
        this.sem = sem;
    }

    public void run() {
        try {
            System.out.println(name + " running and in queue for semaphore");
            sem.acquire();
            System.out.println(name + " acquired semaphore");
            System.out.println(name + " in semaphore");
            Thread.sleep(1000);
            if (Objects.equals(name, "J")) {
                System.out.println(name + " still in semaphore. Variable: " + sem.availablePermits());
                Thread.sleep(2000);
                sem.release();
                System.out.println(name + " released the semaphore. Variable: " + sem.availablePermits());

            }
            else {
                sem.release();
                System.out.println(name + " released the semaphore. Variable: " + sem.availablePermits());
            }
        } catch (InterruptedException e) {
            System.out.println("Thread exception " + name + ": " + e);
        }
        switch (name) {
            case "A" -> ThreadRunner.RunP1(sem);
            case "B", "C", "I" -> ThreadRunner.RunP2(sem);
            case "D", "E", "F" -> ThreadRunner.RunP3(sem);
            case "J", "G", "H" ->  ThreadRunner.RunK(sem);
        }
    }
}