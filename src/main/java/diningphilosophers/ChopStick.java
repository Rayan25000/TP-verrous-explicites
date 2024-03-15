package diningphilosophers;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ChopStick {

    private static int stickCount = 0;
    /*private boolean iAmFree = true;*/
    private final Lock lock = new ReentrantLock();
    private final int myNumber;

    public ChopStick() {
        myNumber = ++stickCount;
    }

    public boolean tryTake(int delay) throws InterruptedException {
        if (lock.tryLock(500, TimeUnit.MILLISECONDS)) {
            return true;
        }
        Thread.sleep(delay);
        return false;

    }

    public void release() {
        lock.unlock();
        System.out.println("Stick " + myNumber + " Released");
    }

    @Override
    public String toString() {
        return "Stick#" + myNumber;
    }
}
