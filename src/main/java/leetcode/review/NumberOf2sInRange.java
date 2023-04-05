package leetcode.review;

/**
 * @description: 2出现的次数
 * @author: xuefei
 * @date: 2023/04/05 21:08
 */
public class NumberOf2sInRange {

	public int numberOf2sInRange(int n) {
		int ans = 0;
		int count;
		int rest;
		for (int i = 1; i <= n; i *= 10) {
			count = (n / (i * 10)) * i;
			rest = Math.min(Math.max(n % (i * 10) - (i * 2 - 1), 0), i);
			ans += (count + rest);
		}
		return ans;
	}


}
