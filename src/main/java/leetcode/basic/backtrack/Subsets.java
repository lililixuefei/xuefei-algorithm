package leetcode.basic.backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @description: 子集
 * @author: xuefei
 * @date: 2023/03/09 23:13
 */
public class Subsets {

	List<List<Integer>> res = new ArrayList<>();

	LinkedList<Integer> track = new LinkedList<>();

	public List<List<Integer>> subsets(int[] nums) {
		subsets(nums, 0);
		return res;
	}

	public void subsets(int[] nums, int start) {
		res.add(new ArrayList<>(track));
		for (int i = start; i < nums.length; i++) {
			track.add(nums[i]);
			subsets(nums, i + 1);
			track.removeLast();
		}
	}

}
