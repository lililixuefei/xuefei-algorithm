package xuefei.done.interviewgolden;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @description: 最小K个数
 * @author: xuefei
 * @date: 2023/03/15 22:44
 */
public class SmallestK {


	public int[] smallestK_PQ(int[] arr, int k) {
		PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
		for (int i : arr) {
			priorityQueue.add(i);
		}
		int[] smallestK = new int[k];
		for (int i = 0; i < k; i++) {
			smallestK[i] = priorityQueue.poll();
		}
		return smallestK;
	}


	public int[] smallestK_sort(int[] arr, int k) {
		Arrays.sort(arr);
		int[] smallestK = new int[k];
		for (int i = 0; i < k; i++) {
			smallestK[i] = arr[i];
		}
		return smallestK;
	}

}
