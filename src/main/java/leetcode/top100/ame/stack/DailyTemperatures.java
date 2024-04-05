package leetcode.top100.ame.stack;

import java.util.Stack;

/**
 * @Description
 * @Author xuefei
 * @Date 2024/4/5 18:40
 * @Version 1.0
 */
public class DailyTemperatures {


	public int[] dailyTemperatures(int[] temperatures) {
		Stack<Integer> stack = new Stack<>();
		int[] ans = new int[temperatures.length];
		for (int i = temperatures.length - 1; i >= 0; i--) {
			while (!stack.isEmpty() && temperatures[stack.peek()] <= temperatures[i]) {
				stack.pop();
			}
			ans[i] = stack.isEmpty() ? 0 : stack.peek() - i;
			stack.push(i);
		}
		return ans;
	}

}
