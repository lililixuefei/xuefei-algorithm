package study.wushixiong.firstweek;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @description: 最小栈
 * @author: xuefei
 * @date: 2022/06/19 23:16
 */
public class MinStack {

    Deque<Integer> xStack;
    Deque<Integer> minStack;

    public MinStack() {
        xStack = new LinkedList<>();
        minStack = new LinkedList<>();
        minStack.push(Integer.MAX_VALUE);
    }

    public void push(int x) {
        xStack.push(x);
        minStack.push(Math.min(minStack.peek(), x));
    }

    public void pop() {
        xStack.pop();
        minStack.pop();
    }

    public int top() {
        return xStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
