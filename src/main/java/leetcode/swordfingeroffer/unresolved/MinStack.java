package leetcode.swordfingeroffer.unresolved;

import java.util.Stack;

/**
 * @description: 剑指 Offer 30. 包含min函数的栈
 * @author: xuefei
 * @date: 2023/08/11 23:22
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
        if (stackMin.empty() || x <= min()) {
            stackMin.push(x);
        }
        stackData.push(x);
    }

    public void pop() {
        int value = stackData.pop();
        if (value == min()) {
            stackMin.pop();
        }
    }

    public int top() {
        return stackData.peek();
    }

    public int min() {
        return stackMin.peek();
    }

}