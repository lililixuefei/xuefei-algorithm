package leetcode.basic.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @description: 子集 II
 * @author: xuefei
 * @date: 2023/03/09 23:22
 */
public class SubsetsWithDup {


	List<List<Integer>> res = new ArrayList<>();

	LinkedList<Integer> track = new LinkedList<>();


	public List<List<Integer>> subsetsWithDup(int[] nums) {
		Arrays.sort(nums);
		subsets(nums,0);
		return res;
	}

	public void subsets(int[] nums, int start) {
		res.add(new ArrayList<>(track));
		for (int i = start; i < nums.length; i++) {
			if (i > start && nums[i] == nums[i-1]){
				continue;
			}

			track.add(nums[i]);
			subsets(nums, i + 1);
			track.removeLast();
		}
	}

}
