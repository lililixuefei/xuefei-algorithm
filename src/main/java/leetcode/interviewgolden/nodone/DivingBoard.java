package leetcode.interviewgolden.nodone;

import java.util.*;

/**
 * @description: 跳水板
 * @author: xuefei
 * @date: 2023/03/12 22:56
 */
public class DivingBoard {

	public static void main(String[] args) {
		DivingBoard divingBoard = new DivingBoard();
		divingBoard.divingBoard_wrong(1, 1, 10);
	}

	public int[] divingBoard(int shorter, int longer, int k) {
		if (k == 0) {
			return new int[0];
		}
		if (shorter == longer) {
			return new int[]{shorter * k};
		}
		int[] lengths = new int[k + 1];
		for (int i = 0; i <= k; i++) {
			lengths[i] = shorter * (k - i) + longer * i;
		}
		return lengths;
	}


	// -------------------------------------------------------------------------------------


	List<Integer> res = new ArrayList<>();

	LinkedList<Integer> track = new LinkedList<>();

	int length = 0;

	public int[] divingBoard_wrong(int shorter, int longer, int k) {
		if (k == 0) {
			return new int[0];
		}
		int[] nums = new int[]{shorter, longer};
		backtrack(nums, k);

		return res.stream().mapToInt(Integer::intValue).toArray();

	}

	public void backtrack(int[] nums, int k) {

		if (track.size() == k) {
			res.add(length);
			return;
		}

		for (int i = 0; i < nums.length; i++) {
			length += nums[i];
			track.add(nums[i]);
			backtrack(nums, k);
			track.removeLast();
			length -= nums[i];
		}
	}

}
