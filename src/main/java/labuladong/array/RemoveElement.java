package labuladong.array;

/**
 * @Description
 * @Author xuefei
 * @Date 2023/8/7 10:45 AM
 * @Version 1.0
 */
public class RemoveElement {

	int removeElement(int[] nums, int val) {
		int fast = 0, slow = 0;
		while (fast < nums.length) {
			if (nums[fast] != val) {
				nums[slow] = nums[fast];
				slow++;
			}
			fast++;
		}
		return slow;
	}

}
