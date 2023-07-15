package leetcode.onequestion.unresolved;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description: 四数之和
 * @author: xuefei
 * @date: 2023/07/15 22:42
 */
public class FourSum {

	public static void main(String[] args) {
		FourSum fourSum = new FourSum();
		int[] nums = {1000000000, 1000000000, 1000000000, 1000000000};
		fourSum.fourSum(nums, -294967296);

		int a = -1294967296;
		int b = 1000000000;

		System.out.println(a - b);

	}


	public List<List<Integer>> fourSum(int[] nums, int target) {
		Arrays.sort(nums);
		int n = nums.length;
		List<List<Integer>> ans = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			List<List<Integer>> tuples = threeSum(nums, i + 1, target - nums[i]);
			for (List<Integer> tuple : tuples) {
				tuple.add(nums[i]);
				ans.add(tuple);
			}
			// 跳过第一个数字重复的情况，否则会出现重复结果
			while (i < n - 1 && nums[i] == nums[i + 1]) {
				i++;
			}
		}
		return ans;
	}


	public List<List<Integer>> threeSum(int[] nums, int start, long target) {

		List<List<Integer>> ans = new ArrayList<>();

		int n = nums.length;

		for (int i = start; i < n; i++) {
			List<List<Integer>> tuples = twoSum(nums, i + 1, target - nums[i]);
			for (List<Integer> tuple : tuples) {
				tuple.add(nums[i]);
				ans.add(tuple);
			}
			// 跳过第一个数字重复的情况，否则会出现重复结果
			while (i < n - 1 && nums[i] == nums[i + 1]) {
				i++;
			}
		}

		return ans;
	}


	public List<List<Integer>> twoSum(int[] nums, int start, long target) {

		List<List<Integer>> ans = new ArrayList<>();

		int n = nums.length;


		int lo = start, hi = n - 1;
		while (lo < hi) {
			int sum = nums[lo] + nums[hi];
			int left = nums[lo], right = nums[hi];
			if (sum < target) {
				while (lo < hi && nums[lo] == left) {
					lo++;
				}
			} else if (sum > target) {
				while (lo < hi && nums[hi] == right) {
					hi--;
				}
			} else {
				List<Integer> cur = new ArrayList<>();
				cur.add(nums[lo]);
				cur.add(nums[hi]);
				ans.add(cur);
				while (lo < hi && nums[lo] == left) {
					lo++;
				}
				while (lo < hi && nums[hi] == right) {
					hi--;
				}
			}
		}

//		int l = start;
//		int r = n - 1;
//		while (l < r) {
//			int sum = nums[l] + nums[r];
//
//			if (sum < target) {
//				l++;
//			} else if (sum > target) {
//				r--;
//			} else {
//				if (l == 0 || nums[l - 1] != nums[l]) {
//					List<Integer> cur = new ArrayList<>();
//					cur.add(nums[l]);
//					cur.add(nums[r]);
//					ans.add(cur);
//				}
//				l++;
//			}
//		}
		return ans;
	}


}
