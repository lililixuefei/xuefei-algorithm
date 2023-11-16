package zuoshen.course.class05;

import java.util.TreeMap;

// 这道题直接在leetcode测评：
// https://leetcode.com/problems/count-of-range-sum/
public class Code01_CountOfRangeSum {


	public int countRangeSum2(int[] nums, int lower, int upper) {
		if(nums == null || nums.length == 0){
			return 0;
		}
		// key is the sum[i], value is the corresponding count
		// sum[i] - sum[j] in [lower, upper], transform to find how many sum[j] 在区间[sum[i] - high, sum[i] - lower]。
		TreeMap<Long, Integer> map = new TreeMap();
		long sum = 0;
		int cnt = 0;

		for(int i = 0; i < nums.length; i++){
			sum += nums[i];
			// sum[0, i]满足case
			if(sum >= lower && sum <= upper){
				cnt++;
			}
			// find sum[j] 的个数that lies in [sum[i] - high, sum[i] - lower]之间
			cnt += map.subMap(sum - upper, true, sum - lower, true).values().stream().mapToInt(Integer::valueOf).sum();

			map.put(sum, map.getOrDefault(sum, 0) + 1);
		}
		return cnt;
	}


	public static int countRangeSum(int[] nums, int lower, int upper) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		long[] sum = new long[nums.length];
		sum[0] = nums[0];
		for (int i = 1; i < nums.length; i++) {
			sum[i] = sum[i - 1] + nums[i];
		}
		return process(sum, 0, sum.length - 1, lower, upper);
	}

	public static int process(long[] sum, int L, int R, int lower, int upper) {
		if (L == R) {
			return sum[L] >= lower && sum[L] <= upper ? 1 : 0;
		}
		int M = L + ((R - L) >> 1);
		return process(sum, L, M, lower, upper) + process(sum, M + 1, R, lower, upper)
				+ merge(sum, L, M, R, lower, upper);
	}

	public static int merge(long[] arr, int L, int M, int R, int lower, int upper) {
		int ans = 0;
		int windowL = L;
		int windowR = L;
		// [windowL, windowR)
		for (int i = M + 1; i <= R; i++) {
			long min = arr[i] - upper;
			long max = arr[i] - lower;
			while (windowR <= M && arr[windowR] <= max) {
				windowR++;
			}
			while (windowL <= M && arr[windowL] < min) {
				windowL++;
			}
			ans += windowR - windowL;
		}
		long[] help = new long[R - L + 1];
		int i = 0;
		int p1 = L;
		int p2 = M + 1;
		while (p1 <= M && p2 <= R) {
			help[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
		}
		while (p1 <= M) {
			help[i++] = arr[p1++];
		}
		while (p2 <= R) {
			help[i++] = arr[p2++];
		}
		for (i = 0; i < help.length; i++) {
			arr[L + i] = help[i];
		}
		return ans;
	}

}
