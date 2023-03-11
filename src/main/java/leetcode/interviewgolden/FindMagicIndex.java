package leetcode.interviewgolden;

/**
 * @description: 魔术索引
 * @author: xuefei
 * @date: 2023/03/11 17:03
 */
public class FindMagicIndex {

	public int findMagicIndex(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == i) {
				return i;
			}
		}
		return -1;
	}

}
