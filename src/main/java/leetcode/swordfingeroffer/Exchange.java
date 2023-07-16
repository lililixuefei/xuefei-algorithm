package leetcode.swordfingeroffer;

/**
 * @description: 剑指 Offer 21. 调整数组顺序使奇数位于偶数前面
 * @author: xuefei
 * @date: 2023/07/16 19:34
 */
public class Exchange {

	public static void main(String[] args) {
		int[] nums = {1, 2, 3, 4};
		exchange(nums);
	}


	public static int[] exchange2(int[] nums) {
		// 维护 nums[0..slow) 都是奇数
		int fast = 0, slow = 0;
		while (fast < nums.length) {
			if (nums[fast] % 2 == 1) {
				// fast 遇到奇数，把 nums[fast] 换到 nums[slow]
				int temp = nums[slow];
				nums[slow] = nums[fast];
				nums[fast] = temp;
				slow++;
			}
			fast++;
		}
		return nums;
	}


	public static int[] exchange(int[] nums) {
		if (nums == null || nums.length < 2) {
			return nums;
		}
		int l = 0;
		int r = nums.length - 1;
		while (l <= r) {
			if (nums[l] % 2 == 1) {
				l++;
				continue;
			}
			if (nums[r] % 2 == 0) {
				r--;
				continue;
			}
			swap(nums, l, r);
		}
		return nums;
	}


	private static void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

}
