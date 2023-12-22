package leetcode.top100.undo;

/**
 * @Description 寻找重复数
 * @Author xuefei
 * @Date 2023/12/22 23:13
 * @Version 1.0
 */
public class FindDuplicate {

	public int findDuplicate(int[] nums) {
		int slow = 0;
		int fast = 0;
		slow = nums[slow];
		fast = nums[nums[fast]];
		while (slow != fast) {
			slow = nums[slow];
			fast = nums[nums[fast]];
		}
		int pre1 = 0;
		int pre2 = slow;
		while (pre1 != pre2) {
			pre1 = nums[pre1];
			pre2 = nums[pre2];
		}
		return pre1;
	}


}
