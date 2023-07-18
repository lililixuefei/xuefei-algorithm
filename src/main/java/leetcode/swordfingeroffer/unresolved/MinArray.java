package leetcode.swordfingeroffer.unresolved;

/**
 * @description: 剑指 Offer 11. 旋转数组的最小数字
 * @author: xuefei
 * @date: 2023/07/18 23:09
 */
public class MinArray {

	public int minArray(int[] numbers) {
		int l = 0;
		int r = numbers.length - 1;
		while (l <= r) {
			int mid = l + (r - l) / 2;
			if (numbers[mid] < numbers[r]) {
				r = mid;
			} else if (numbers[mid] > numbers[r]) {
				l = mid + 1;
			} else {
				r -= 1;
			}
		}
		return numbers[l];
	}

}
