package leetcode.swordfingeroffer;

import java.util.Stack;

/**
 * @description: 剑指 Offer 09. 用两个栈实现队列
 * @author: xuefei
 * @date: 2023/07/24 22:37
 */
public class CQueue {

	Stack<Integer> stackIn;

	Stack<Integer> stackOut;


	public CQueue() {
		stackIn = new Stack<>();
		stackOut = new Stack<>();
	}

	public void appendTail(int value) {
		stackIn.push(value);
	}

	public int deleteHead() {
		if (!stackOut.isEmpty()) {
			return stackOut.pop();
		}
		while (stackIn.isEmpty()) {
			stackOut.push(stackIn.pop());
		}
		if (stackOut.isEmpty()) {
			return -1;
		}
		Integer curValue = stackOut.pop();
		if (curValue == null) {
			return -1;
		}
		return curValue;
	}

}
