package leetcode.basic.binarysearch;


/**
 * @description: 山峰数组的顶部
 * @author: xuefei
 * @date: 2023/03/03 23:19
 */
public class PeakIndexInMountainArray {

	public static void main(String[] args) {
		int[] arr = new int[]{3,5,3,2,0};
		System.out.println(peakIndexInMountainArray_me2(arr));
	}

	public static int peakIndexInMountainArray_me2(int[] arr) {
		int left = 0;
		int right = arr.length - 1;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {
				return mid;
			} else if (arr[mid] < arr[mid - 1] && arr[mid] > arr[mid + 1]) {
				right = mid;
			} else {
				left = mid;
			}
		}
		return -1;
	}

	public int peakIndexInMountainArray_me1(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > arr[i + 1]) {
				return i;
			}
		}
		return -1;
	}

}
