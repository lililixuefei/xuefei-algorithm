package leetcode.swordfingeroffer.resolved;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @description: 剑指 Offer 40. 最小的k个数
 * @author: xuefei
 * @date: 2023/07/20 23:28
 */
public class GetLeastNumbers {

	public int[] getLeastNumbers2(int[] arr, int k) {

		PriorityQueue<Integer> heap = new PriorityQueue<>();
		for (int i : arr) {
			heap.add(i);
		}
		int[] ans = new int[k];
		for (int i = 0; i < k; i++) {
			ans[i] = heap.poll();
		}
		return ans;
	}

	public int[] getLeastNumbers1(int[] arr, int k) {
		Arrays.sort(arr);
		int[] ans = new int[k];
		for (int i = 0; i < k; i++) {
			ans[i] = arr[i];
		}
		return ans;
	}

}
