package multithread.printInOrder;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;

/**
 * @description: 打印零与奇偶数
 * @author: xuefei
 * @date: 2021/12/23 22:48
 */
public class PrintZeroEvenOdd {
}

/**
 * Semaphore
 */
class SemaphoreZeroEvenOdd {
    private int n;
    private Semaphore zeroSema = new Semaphore(1);
    /**
     * 奇数
     */
    private Semaphore oddSema = new Semaphore(0);
    /**
     * 偶数
     */
    private Semaphore evenSema = new Semaphore(0);

    public SemaphoreZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            zeroSema.acquire();
            printNumber.accept(0);
            //奇数
            if ((i & 1) == 1) {
                oddSema.release();
            } else {
                evenSema.release();
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            //偶数 打印偶数 并释放zero的线程
            if ((i & 1) == 0) {
                evenSema.acquire();
                printNumber.accept(i);
                zeroSema.release();
            }
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            // 奇数，打印奇数，并释放zero的线程
            if ((i & 1) == 1) {
                oddSema.acquire();
                printNumber.accept(i);
                zeroSema.release();
            }
        }
    }
}

/**
 * CountDownLatch
 */
class CountDownLatchZeroEvenOdd {
    private int n;

    private CountDownLatch zeroLatch = new CountDownLatch(0);
    /**
     * 偶数
     */
    private CountDownLatch evenLatch = new CountDownLatch(1);
    /**
     * 奇数
     */
    private CountDownLatch oddLatch = new CountDownLatch(1);

    public CountDownLatchZeroEvenOdd(int n) {
        this.n = n;
    }

    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            zeroLatch.await();
            //打印0
            printNumber.accept(0);
            zeroLatch = new CountDownLatch(1);
            //如果是奇数，就打印奇数
            if ((i & 1) == 1) {
                oddLatch.countDown();
            } else {
                evenLatch.countDown();
            }

        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            if ((i & 1) == 0) {
                // 开始打印偶数
                evenLatch.await();
                printNumber.accept(i);
                evenLatch = new CountDownLatch(1);
                // 是否zero线程
                zeroLatch.countDown();
            }
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            if ((i & 1) == 1) {
                // 开始打印奇数
                oddLatch.await();
                printNumber.accept(i);
                oddLatch = new CountDownLatch(1);
                // 是否zero线程
                zeroLatch.countDown();
            }
        }
    }
}

/**
 * Thread.yield()
 */
class YieldZeroEvenOdd {

    private int n;

    private volatile int state;

    private volatile boolean control = true;

    public YieldZeroEvenOdd(int n) {
        this.n = n;
    }

    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            while (state != 0) {
                Thread.yield();
            }
            printNumber.accept(0);
            if (control) {
                state = 1;
            } else {
                state = 2;
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 2; i <= n; i += 2) {
            // 当state不为2的时候，为就绪状态
            while (state != 2) {
                Thread.yield();
            }
            printNumber.accept(i);
            control = true;
            state = 0;
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i += 2) {
            while (state != 1) {
                Thread.yield();
            }
            printNumber.accept(i);
            control = false;
            state = 0;
        }
    }
}

/**
 * LockSupport
 */
class LockSupportZeroEvenOdd {
    private int n;
    private Map<String, Thread> map = new ConcurrentHashMap<>();
    /**
     * 0 打印 0 ， 1 打印奇数， 2 打印偶数
     */
    volatile int state = 0;


    public LockSupportZeroEvenOdd(int n) {
        this.n = n;
    }

    public void zero(IntConsumer printNumber) throws InterruptedException {
        map.put("zero", Thread.currentThread());
        for (int i = 1; i <= n; i++) {
            while (state != 0) {
                LockSupport.park();
            }
            printNumber.accept(0);
            // 偶数
            if ((i & 1) == 0) {
                state = 2;
            } else {
                state = 1;
            }
            // 通知其他两个线程
            map.forEach((k, v) -> LockSupport.unpark(v));
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        map.put("even", Thread.currentThread());
        for (int i = 2; i <= n; i += 2) {
            while (state != 2) {
                LockSupport.park();
            }
            printNumber.accept(i);
            state = 0;
            // 通知zero线程
            LockSupport.unpark(map.get("zero"));
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        map.put("odd", Thread.currentThread());
        for (int i = 1; i <= n; i += 2) {
            while (state != 1) {
                LockSupport.park();
            }
            printNumber.accept(i);
            state = 0;
            LockSupport.unpark(map.get("zero"));
        }
    }
}

/**
 * ReentrantLock+Condition
 */
class ReentrantLockZeroEvenOdd {
    private int n;

    private volatile int start = 1;

    private volatile int state;
    private Lock lock = new ReentrantLock();
    private Condition zero = lock.newCondition();
    private Condition even = lock.newCondition();
    private Condition odd = lock.newCondition();

    public ReentrantLockZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        lock.lock();
        try {
            while (start <= n) {
                if (state != 0) {
                    zero.await();
                }
                printNumber.accept(0);
                if (start % 2 == 0) {
                    state = 2;
                    even.signal();
                } else {
                    state = 1;
                    odd.signal();
                }
                zero.await();
            }
            odd.signal();
            even.signal();
        } finally {
            lock.unlock();
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        lock.lock();
        try {
            while (start <= n) {
                if (state != 2) {
                    even.await();
                } else {
                    printNumber.accept(start++);
                    state = 0;
                    zero.signal();
                }
            }
        } finally {
            lock.unlock();
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        lock.lock();
        try {
            while (start <= n) {
                if (state != 1) {
                    odd.await();
                } else {
                    printNumber.accept(start++);
                    state = 0;
                    zero.signal();
                }
            }
        } finally {
            lock.unlock();
        }
    }
}

