package test;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.LockSupport;

/**
 * @description: 测试
 * @author: xuefei
 * @date: 2021/12/23 23:09
 */
public class Test {

    private static final Map<Integer, Integer> CACHE = new HashMap<Integer, Integer>();


    public static void main(String[] args) throws InterruptedException {
        Test test = new Test();
        test.test002();
        System.out.println(CACHE);
    }

    public void test002() {
        CACHE.put(1,2);
    }

    private static void test001() throws InterruptedException {
        Thread helloThread = new Thread(() -> {
            System.out.println("hello");
            LockSupport.park();
            System.out.println("world");
            LockSupport.park();
            System.out.println("java");
        }, "helloThread");

        Thread.sleep(1000);
        helloThread.start();
        LockSupport.unpark(helloThread);
    }
}
