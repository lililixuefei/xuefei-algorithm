package leetcode.basic.binarysearch;


/**
 * @description: 袋子里最少数目的球
 * @author: xuefei
 * @date: 2023/03/27 23:52
 */
public class MinimumSize {


	public int minimumSize(int[] nums, int maxOperations) {
		long l = 1;
		long r = 1000000000;
		long ret = 0;
		while (l <= r) {
			long mid = (l + r) / 2;
			if (check(nums, mid, maxOperations)) {
				r = mid - 1;
				ret = mid;
			} else {
				l = mid + 1;
			}
		}
		return (int) ret;
	}

	public boolean check(int[] nums, long cost, int maxOperations) {
		long ans = 0;
		for (int cur : nums) {
			if (cur % cost == 0) {
				ans += cur / cost - 1;
			} else {
				ans += cur / cost;
			}
		}
		return ans <= maxOperations;
	}
}
