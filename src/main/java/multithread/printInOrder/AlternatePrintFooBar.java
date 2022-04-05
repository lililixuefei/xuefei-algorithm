package multithread.printInOrder;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @description: 交替打印 FooBar
 * @author: xuefei
 * @date: 2021/12/20 23:41
 */
public class AlternatePrintFooBar {
    public static void main(String[] args) {

    }
}

/**
 * ReentrantLock
 */
class LockConditionalFooBar {
    private int n;
    private ReentrantLock lock = new ReentrantLock(true);
    private Condition condition = lock.newCondition();
    volatile boolean fooExec = true;

    public LockConditionalFooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            lock.lock();
            try {
                if (!fooExec) {
                    condition.await();
                }
                printFoo.run();
                fooExec = false;
                condition.signal();
            } finally {
                lock.unlock();
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            lock.lock();
            try {
                if (fooExec) {
                    condition.await();
                }
                printBar.run();
                fooExec = true;
                condition.signal();
            } finally {
                lock.unlock();
            }
        }
    }
}


/**
 * Semaphore
 */
class SemaphoreFooBar {

    private int n;
    private Semaphore s1 = new Semaphore(1);
    private Semaphore s2 = new Semaphore(0);

    public SemaphoreFooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            s1.acquire();
            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();
            s2.release();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            s2.acquire();
            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
            s1.release();
        }
    }
}