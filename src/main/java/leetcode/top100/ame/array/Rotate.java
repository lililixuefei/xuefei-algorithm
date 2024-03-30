package leetcode.top100.ame.array;

/**
 * @Description
 * @Author xuefei
 * @Date 2024/3/30 19:56
 * @Version 1.0
 */
public class Rotate {

	public void rotate(int[] nums, int k) {
		int n = nums.length;
		int[] newArray = new int[n];
		for (int i = 0; i < n; i++) {
			int p = (i + k) % n;
			newArray[p] = nums[i];
		}
		for (int i = 0; i < newArray.length; i++) {
			nums[i] = newArray[i];
		}
	}

}
