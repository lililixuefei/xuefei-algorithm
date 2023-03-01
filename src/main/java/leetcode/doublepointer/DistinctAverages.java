package leetcode.doublepointer;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @description: 不同的平均值数目
 * @author: xuefei
 * @date: 2023/03/01 23:08
 */
public class DistinctAverages {

	public int distinctAverages(int[] nums) {
		Arrays.sort(nums);
		int i = 0;
		int j = nums.length - 1;
		Set<Double> set = new HashSet<>();
		while (i < j) {
			double ans = ((double) nums[i] + (double) nums[j]) / 2;
			set.add(ans);
			i++;
			j--;
		}
		return set.size();
	}

}
