package leetcode.swordfingeroffer.unresolved;

import java.util.LinkedList;

/**
 * @description: 剑指 Offer 59 - II. 队列的最大值
 * @author: xuefei
 * @date: 2023/08/11 23:05
 */
public class MaxQueue {

    LinkedList<Integer> queue1;

    LinkedList<Integer> queue2;


    public MaxQueue() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    public int max_value() {
        if (queue2.isEmpty()) {
            return -1;
        }
        return queue2.peek();
    }

    public void push_back(int value) {
        queue1.offer(value);
        while (!queue2.isEmpty() && queue2.peekLast() < value) {
            queue2.pollLast();
        }
        queue2.offer(value);
    }


    public int pop_front() {
        if (queue1.isEmpty()) {
            return -1;
        }
        Integer value = queue1.poll();
        if (value.equals(queue2.peekFirst())) {
            queue2.poll();
        }
        return value;
    }

}
