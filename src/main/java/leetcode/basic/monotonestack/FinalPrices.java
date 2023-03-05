package leetcode.basic.monotonestack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @description: 商品折扣后的最终价格
 * @author: xuefei
 * @date: 2023/02/24 22:20
 */
public class FinalPrices {

	public static void main(String[] args) {
		int[] nums = new int[]{8, 4, 6, 2, 3};
		finalPrices(nums);
	}

	public static int[] finalPrices(int[] prices) {
		int[] ans = new int[prices.length];
		Deque<Integer> stack = new LinkedList<>();
		for (int i = 0; i < prices.length; i++) {
			while (!stack.isEmpty() && prices[stack.peek()] >= prices[i]) {
				int cur = stack.pop();
				ans[cur] = prices[cur] - prices[i];
			}
			stack.push(i);
		}
		while (!stack.isEmpty()) {
			int cur = stack.pop();
			ans[cur] = prices[cur];
		}
		return ans;
	}

}
