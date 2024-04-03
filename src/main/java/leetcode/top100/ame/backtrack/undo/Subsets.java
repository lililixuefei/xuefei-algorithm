package leetcode.top100.ame.backtrack.undo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description
 * @Author xuefei
 * @Date 2024/4/3 22:33
 * @Version 1.0
 */
public class Subsets {


	private List<List<Integer>> ans;
	private LinkedList<Integer> track;

	public List<List<Integer>> subsets(int[] nums) {
		ans = new ArrayList<>();
		track = new LinkedList<>();
		process(nums, 0);
		return ans;
	}


	private void process(int[] nums, int k) {
		ans.add(new ArrayList<>(track));
		for (int i = k; i < nums.length; i++) {
			track.add(nums[i]);
			process(nums, i + 1);
			track.removeLast();
		}
	}

}
