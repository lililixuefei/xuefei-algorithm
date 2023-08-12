package xuefei.done.interviewgolden;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @description: 栈的最小值
 * @author: xuefei
 * @date: 2023/04/02 12:14
 */
public class MinStack {

	public Deque<Integer> stackData;

	public Deque<Integer> stackMin;

	/**
	 * initialize your data structure here.
	 */
	public MinStack() {
		stackData = new LinkedList<>();
		stackMin = new LinkedList<>();
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
