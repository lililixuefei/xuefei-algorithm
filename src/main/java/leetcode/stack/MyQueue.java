package leetcode.stack;

import java.util.Stack;

/**
 * @description: 用栈实现队列
 * @author: xuefei
 * @date: 2023/02/23 23:24
 */
public class MyQueue {

    public Stack<Integer> stackPush;
    public Stack<Integer> stackPop;

    public MyQueue() {
        stackPush = new Stack<>();
        stackPop = new Stack<>();
    }

    private void pushToPop() {
        if (stackPop.empty()) {
            while (!stackPush.empty()) {
                stackPop.push(stackPush.pop());
            }
        }
    }

    public void push(int x) {
        stackPush.push(x);
        pushToPop();
    }

    public int pop() {
        pushToPop();
        return stackPop.pop();
    }

    public int peek() {
        pushToPop();
        return stackPop.peek();
    }

    public boolean empty() {
        return stackPush.empty() && stackPop.empty();
    }
}
