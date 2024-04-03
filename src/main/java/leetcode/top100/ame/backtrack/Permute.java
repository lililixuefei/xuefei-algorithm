package leetcode.top100.ame.backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description
 * @Author xuefei
 * @Date 2024/4/3 22:22
 * @Version 1.0
 */
public class Permute {


	private List<List<Integer>> ans;
	private LinkedList<Integer> track;
	private boolean[] used;

	public List<List<Integer>> permute(int[] nums) {
		ans = new ArrayList<>();
		track = new LinkedList<>();
		used = new boolean[nums.length];
		process(nums);
		return ans;
	}

	private void process(int[] nums) {
		if (track.size() == nums.length) {
			ans.add(new ArrayList<>(track));
			return;
		}
		for (int i = 0; i < nums.length; i++) {
			if (used[i]) {
				continue;
			}
			used[i] = true;
			track.add(nums[i]);
			process(nums);
			used[i] = false;
			track.removeLast();
		}
	}


}
