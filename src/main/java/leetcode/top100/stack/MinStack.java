package leetcode.top100.stack;

import java.util.Stack;

/**
 * @Description
 * @Author xuefei
 * @Date 2024/3/24 19:46
 * @Version 1.0
 */
public class MinStack {

    public Stack<Integer> stackData;
    public Stack<Integer> stackMin;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        stackData = new Stack<>();
        stackMin = new Stack<>();
    }

    public void push(int x) {
        if (stackMin.isEmpty() || x <= getMin()) {
            stackMin.push(x);
        }
        stackData.push(x);
    }

    public void pop() {
        int value = stackData.pop();
        if (value == getMin()) {
            stackMin.pop();
        }
    }

    public int top() {
        return stackData.peek();
    }

    public int getMin() {
        return stackMin.peek();
    }

}
