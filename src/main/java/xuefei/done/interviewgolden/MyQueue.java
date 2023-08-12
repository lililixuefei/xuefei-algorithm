package xuefei.done.interviewgolden;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @description: 化栈为队
 * @author: xuefei
 * @date: 2023/04/02 12:17
 */
public class MyQueue {

	public Deque<Integer> stackPush;
	public Deque<Integer> stackPop;

	public MyQueue() {
		stackPush = new LinkedList<>();
		stackPop = new LinkedList<>();
	}

	private void pushToPop() {
		if (stackPop.isEmpty()) {
			while (!stackPush.isEmpty()) {
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
		return stackPush.isEmpty() && stackPop.isEmpty();
	}

}
