package xuefei.done.multithread.printInOrder;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @description: 按序打印
 * @author: xuefei
 * @date: 2021/12/19 23:50
 */
public class PrintInOrder {


    /*
                给你一个类：

            public class Foo {
              public void first() { print("first"); }
              public void second() { print("second"); }
              public void third() { print("third"); }
            }
            三个不同的线程 A、B、C 将会共用一个 Foo 实例。

            线程 A 将会调用 first() 方法
            线程 B 将会调用 second() 方法
            线程 C 将会调用 third() 方法
            请设计修改程序，以确保 second() 方法在 first() 方法之后被执行，third() 方法在 second() 方法之后被执行。

            提示：

            尽管输入中的数字似乎暗示了顺序，但是我们并不保证线程在操作系统中的调度顺序。
            你看到的输入格式主要是为了确保测试的全面性。
             

            示例 1：

            输入：nums = [1,2,3]
            输出："firstsecondthird"
            解释：
            有三个线程会被异步启动。输入 [1,2,3] 表示线程 A 将会调用 first() 方法，线程 B 将会调用 second() 方法，线程 C 将会调用 third() 方法。正确的输出是 "firstsecondthird"。
            示例 2：

            输入：nums = [1,3,2]
            输出："firstsecondthird"
            解释：
            输入 [1,3,2] 表示线程 A 将会调用 first() 方法，线程 B 将会调用 third() 方法，线程 C 将会调用 second() 方法。正确的输出是 "firstsecondthird"。
             

            提示：
            nums 是 [1, 2, 3] 的一组排列

     */

    public static void main(String[] args) throws InterruptedException {

    }

}

/**
 * LockSupport
 * LockSupport类的核心方法其实就两个：park()和unpark()，其中park()方法用来阻塞当前调用线程，unpark()方法用于唤醒指定线程。
 * 这其实和Object类的wait()和signal()方法有些类似，但是LockSupport的这两种方法从语意上讲比Object类的方法更清晰，而且可以针对指定线程进行阻塞和唤醒。
 * LockSupport类使用了一种名为Permit（许可）的概念来做到阻塞和唤醒线程的功能，可以把许可看成是一种(0,1)信号量（Semaphore），但与 Semaphore 不同的是，许可的累加上限是1。
 * 初始时，permit为0，当调用unpark()方法时，线程的permit加1，当调用park()方法时，如果permit为0，则调用线程进入阻塞状态。
 */
class LockSupportFoo {
    private AtomicInteger counter = new AtomicInteger(0);
    private Map<String, Thread> threads = new HashMap<>();

    public LockSupportFoo() {

    }

    public void first(Runnable printFirst) throws InterruptedException {
        while (counter.get() != 0) {
            threads.put("first", Thread.currentThread());
            LockSupport.park();
        }
        printFirst.run();
        counter.getAndIncrement();
        threads.forEach((k, v) -> LockSupport.unpark(v));
    }

    public void second(Runnable printSecond) throws InterruptedException {
        while (counter.get() != 1) {
            threads.put("second", Thread.currentThread());
            LockSupport.park();
        }
        printSecond.run();
        counter.getAndIncrement();
        threads.forEach((k, v) -> LockSupport.unpark(v));
    }

    public void third(Runnable printThird) throws InterruptedException {
        while (counter.get() != 2) {
            threads.put("third", Thread.currentThread());
            LockSupport.park();
        }
        printThird.run();
        counter.getAndIncrement();
        threads.forEach((k, v) -> LockSupport.unpark(v));
    }
}

/**
 * ReentrantLock+Condition
 * Condition可以通俗的理解为条件队列。当一个线程在调用了await方法以后，直到线程等待的某个条件为真的时候才会被唤醒。这种方式为线程提供了更加简单的等待/通知模式。Condition必须要配合锁一起使用，
 * 因为对共享状态变量的访问发生在多线程环境下。一个Condition的实例必须与一个Lock绑定，因此Condition一般都是作为Lock的内部实现。
 *
 * await() ：造成当前线程在接到信号或被中断之前一直处于等待状态。
 * await(long time, TimeUnit unit) ：造成当前线程在接到信号、被中断或到达指定等待时间之前一直处于等待状态。
 * awaitNanos(long nanosTimeout) ：造成当前线程在接到信号、被中断或到达指定等待时间之前一直处于等待状态。返回值表示剩余时间，如果在nanosTimesout之前唤醒，
 * 那么返回值 = nanosTimeout - 消耗时间，如果返回值 <= 0 ,则可以认定它已经超时了。
 * awaitUninterruptibly() ：造成当前线程在接到信号之前一直处于等待状态。【注意：该方法对中断不敏感】。
 * awaitUntil(Date deadline) ：造成当前线程在接到信号、被中断或到达指定最后期限之前一直处于等待状态。如果没有到指定时间就被通知，则返回true，否则表示到了指定时间，返回返回false。
 * signal() ：唤醒一个等待线程。该线程从等待方法返回前必须获得与Condition相关的锁。
 * signalAll() ：唤醒所有等待线程。能够从等待方法返回的线程必须获得与Condition相关的锁。
 */
class ReentrantLockFoo {

    int num;
    Lock lock;
    //精确的通知和唤醒线程
    Condition condition1, condition2, condition3;

    public ReentrantLockFoo() {
        num = 1;
        lock = new ReentrantLock();
    }


    public void first(Runnable printFirst) throws InterruptedException {
        lock.lock();
        try {
            // 不是1的时候，阻塞
            while (num != 1) {
                condition1.await();
            }
            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            num = 2;
            condition2.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {
        lock.lock();
        try {
            // 不是2的时候，阻塞
            while (num != 2) {
                condition2.await();
            }
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            num = 3;
            condition3.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void third(Runnable printThird) throws InterruptedException {
        lock.lock();
        try {
            // 不是3的时候，阻塞
            while (num != 3) {
                condition3.await();
            }
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
            num = 1;
            condition1.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}

/**
 * CountDownLatch
 * CountDownLatch这个类使一个线程等待其他线程各自执行完毕后再执行。
 * 是通过一个计数器来实现的，计数器的初始值是线程的数量。每当一个线程执行完毕后，计数器的值就-1，当计数器的值为0时，表示所有线程都执行完毕，然后在闭锁上等待的线程就可以恢复工作了
 */
class CountDownLatchFoo {

    /**
     * 调用await()方法的线程会被挂起，它会等待直到count值为0才继续执行
     * public void await() throws InterruptedException { };
     * 和await()类似，只不过等待一定的时间后count值还没变为0的话就会继续执行
     * public boolean await(long timeout, TimeUnit unit) throws InterruptedException { };
     * 将count值减1
     * public void countDown() { };
     */

    CountDownLatch latch1 = new CountDownLatch(1);
    CountDownLatch latch2 = new CountDownLatch(1);

    public CountDownLatchFoo() {

    }

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        // 唤醒线程2
        latch1.countDown();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        latch1.await();
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        // 唤醒线程3
        latch2.countDown();
    }

    public void third(Runnable printThird) throws InterruptedException {
        // latch2的值为0会执行下面的语句，否则会在此次阻塞
        latch2.await();
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}

/**
 * Semaphore
 * Semaphore是一个计数信号量。
 * 从概念上将，Semaphore包含一组许可证。
 * 如果有需要的话，每个acquire()方法都会阻塞，直到获取一个可用的许可证。
 * 每个release()方法都会释放持有许可证的线程，并且归还Semaphore一个可用的许可证。
 * 然而，实际上并没有真实的许可证对象供线程使用，Semaphore只是对可用的数量进行管理维护
 * 总结：如果线程要访问一个资源就必须先获得信号量。如果信号量内部计数器大于0，信号量减1，然后允许共享这个资源；否则，如果信号量的计数器等于0，信号量将会把线程置入休眠直至计数器大于0.当信号量使用完时，必须释放
 */
class SemaphoreFoo {

    Semaphore s1 = new Semaphore(0);
    Semaphore s2 = new Semaphore(0);

    public SemaphoreFoo() {

    }

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        // 释放后s1的值会变成1
        s1.release();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        // 没有会阻塞  当为1的时候，说明线程2可以拿到s2了
        s1.acquire();
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        // 释放后s2的值会变成1
        s2.release();
    }

    public void third(Runnable printThird) throws InterruptedException {
        // 0的时候拿不到，1的时候可以拿到
        s2.acquire();
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}

/**
 * volatile
 * 用一个volatile修饰类属性count
 */
class VolatileFoo {

    volatile int count = 1;

    public VolatileFoo() {

    }

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        count++;
    }

    public void second(Runnable printSecond) throws InterruptedException {
        while (count != 2) {
            ;
        }
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        count++;
    }

    public void third(Runnable printThird) throws InterruptedException {
        while (count != 3) {
            ;
        }
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}