package leetcode.basic.binarysearch;

import java.util.Arrays;

/**
 * @description: 礼盒的最大甜蜜度
 * @author: xuefei
 * @date: 2023/03/27 22:20
 */
public class MaximumTastiness {


	public int maximumTastiness(int[] price, int k) {
		Arrays.sort(price);
		if (k == 2) {
			return price[price.length - 1] - price[0];
		}
		int l = 0;
		int r = (price[price.length - 1] - price[0]) / (k - 1) + 1;
		while (l + 1 < r) {
			int c = l + (r - l) / 2;
			if (check(price, c, k)) {
				l = c;
			} else {
				r = c;
			}
		}
		return l;
	}

	private boolean check(int[] price, int c, int k) {
		int count = 1;
		int pre = price[0];
		for (int i = 1; i < price.length; i++) {
			if (price[i] >= pre + c) {
				++count;
				pre = price[i];
			}
			if (count == k) {
				return true;
			}
		}
		return false;
	}


}
