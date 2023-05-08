package leetcode.basic.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 汇总区间
 * @author: xuefei
 * @date: 2023/05/08 23:24
 */
public class SummaryRanges {

	public static void main(String[] args) {
		int[] nums = new int[]{0, 2, 3, 4, 6, 8, 9};
		int[] nums2 = new int[]{0, 1, 2, 4, 5, 7};
//		System.out.println(summaryRanges(nums));
		System.out.println(summaryRanges(nums2));
	}

	public static List<String> summaryRanges(int[] nums) {
		List<String> res = new ArrayList<>();
		// i 初始指向第 1 个区间的起始位置
		int i = 0;
		for (int j = 0; j < nums.length; j++) {
			// j 向后遍历，直到不满足连续递增(即 nums[j] + 1 != nums[j + 1])
			// 或者 j 达到数组边界，则当前连续递增区间 [i, j] 遍历完毕，将其写入结果列表。
			if (j + 1 == nums.length || nums[j] + 1 != nums[j + 1]) {
				// 将当前区间 [i, j] 写入结果列表
				StringBuilder sb = new StringBuilder();
				sb.append(nums[i]);
				if (i != j) {
					sb.append("->").append(nums[j]);
				}
				res.add(sb.toString());
				// 将 i 指向更新为 j + 1，作为下一个区间的起始位置
				i = j + 1;
			}
		}
		return res;
	}


	public static List<String> summaryRanges_wrong(int[] nums) {
		List<String> summaryRanges = new ArrayList<>();
		int l = 0;
		int r = 1;
		while (r < nums.length) {
			if (nums[r] - nums[l] == 1) {
				r++;
			} else {
				String ans;
				if (r - l == nums[r] - nums[l]) {
					ans = nums[l] + "->" + nums[r];
					r++;
					l = r;
					r++;
				} else {
					ans = String.valueOf(nums[l]);
					l = r;
					r++;
				}
				summaryRanges.add(ans);
			}
		}
		if (r == nums.length) {
			summaryRanges.add(nums[l] + "->" + nums[nums.length - 1]);
		}

		return summaryRanges;
	}

}
