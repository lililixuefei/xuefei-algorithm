package xuefei.done.interviewgolden;

import java.util.HashSet;
import java.util.Set;

/**
 * @description: 消失的数字
 * @author: xuefei
 * @date: 2023/04/01 21:38
 */
public class MissingNumber {

	public int missingNumber(int[] nums) {
		Set<Integer> set = new HashSet<>();
		int n = nums.length;
		for (int i = 0; i < n; i++) {
			set.add(nums[i]);
		}
		int missing = -1;
		for (int i = 0; i <= n; i++) {
			if (!set.contains(i)) {
				missing = i;
				break;
			}
		}
		return missing;
	}

}
