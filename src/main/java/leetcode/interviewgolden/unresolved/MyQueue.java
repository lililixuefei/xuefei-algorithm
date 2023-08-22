package leetcode.interviewgolden.unresolved;

import java.util.LinkedList;

/**
 * @description: 化栈为队
 * @author: xuefei
 * @date: 2023/08/22 23:31
 */
public class MyQueue {

    LinkedList<Integer> inStack;
    LinkedList<Integer> outStack;

    /**
     * Initialize your data structure here.
     */
    public MyQueue() {
        inStack = new LinkedList<>();
        outStack = new LinkedList<>();
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        inStack.push(x);
        if (outStack.isEmpty()) {
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        if (!outStack.isEmpty()) {
            return outStack.pop();
        }
        while (!inStack.isEmpty()) {
            outStack.push(inStack.pop());
        }
        return outStack.pop();
    }

    /**
     * Get the front element.
     */
    public int peek() {
        if (!outStack.isEmpty()) {
            return outStack.peek();
        }
        while (!inStack.isEmpty()) {
            outStack.push(inStack.pop());
        }
        return outStack.isEmpty() ? -1 : outStack.peek();
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return outStack.isEmpty() && inStack.isEmpty();

    }

}
