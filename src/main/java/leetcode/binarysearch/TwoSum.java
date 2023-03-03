package leetcode.binarysearch;

/**
 * @description: 排序数组中两个数字之和
 * @author: xuefei
 * @date: 2023/03/03 23:33
 */
public class TwoSum {

	public static void main(String[] args) {
		int[] nums = new int[]{1, 2, 4, 6, 10};
		twoSum(nums, 8);
	}

	public int[] twoSum_good(int[] numbers, int target) {
		int begin = 0;
		int end = numbers.length - 1;
		while (begin != end) {
			if (numbers[begin] + numbers[end] == target) {
				return new int[]{begin, end};
			} else if (numbers[begin] + numbers[end] > target) {
				end--;
			} else if (numbers[begin] + numbers[end] < target) {
				begin++;
			}
		}
		return new int[]{-1, -1};
	}

	public static int[] twoSum(int[] numbers, int target) {
		int[] ans = new int[2];
		for (int i = 0; i < numbers.length; i++) {
			int res = binarySearch(numbers, target - numbers[i], i + 1);
			if (res != -1) {
				ans[0] = i;
				ans[1] = res;
				return ans;
			}
		}
		return ans;
	}

	private static int binarySearch(int[] arr, int target, int i) {
		int left = i;
		int right = arr.length - 1;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (arr[mid] == target) {
				return mid;
			} else if (arr[mid] > target) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return -1;
	}

}
