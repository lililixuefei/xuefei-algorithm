package leetcode.top100.binarysearch;

/**
 * @Description
 * @Author xuefei
 * @Date 2024/3/24 20:13
 * @Version 1.0
 */
public class FindMin {

	public static void main(String[] args) {
		FindMin finder = new FindMin();

		// 案例1: 旋转后的数组
		int[] nums1 = {3, 4, 5, 1, 2};
		System.out.println(finder.findMin(nums1)); // 输出应为1

		// 案例2: 没有旋转的数组
		int[] nums2 = {1, 2, 3, 4, 5};
		System.out.println(finder.findMin(nums2)); // 输出应为1

		// 案例3: 包含重复元素的旋转数组
		int[] nums3 = {2, 2, 2, 0, 1};
		System.out.println(finder.findMin(nums3)); // 输出应为0

		// 案例4: 只包含一个元素的数组
		int[] nums4 = {1};
		System.out.println(finder.findMin(nums4)); // 输出应为1
	}

	public int findMin(int[] nums) {
		int low = 0;
		int high = nums.length - 1;
		while (low < high) {
			int pivot = low + (high - low) / 2;
			if (nums[pivot] < nums[high]) {
				high = pivot;
			} else {
				low = pivot + 1;
			}
		}
		return nums[low];
	}

}
