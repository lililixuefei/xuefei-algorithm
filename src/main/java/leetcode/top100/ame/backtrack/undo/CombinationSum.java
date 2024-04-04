package leetcode.top100.ame.backtrack.undo;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description
 * @Author xuefei
 * @Date 2024/4/5 00:38
 * @Version 1.0
 */
public class CombinationSum {


	private List<List<Integer>> ans;
	private LinkedList<Integer> track;

	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		ans = new ArrayList<>();
		track = new LinkedList<>();
		process(candidates, 0, 0, target);
		return ans;
	}

	private void process(int[] candidates, int start, int sum, int target) {
		if (sum == target) {
			ans.add(new ArrayList<>(track));
			track.removeLast();
			return;
		}
		if (sum > target) {
			return;
		}
		for (int i = start; i < candidates.length; i++) {
			track.add(candidates[i]);
			process(candidates, i, sum + candidates[i], target);
			track.removeLast();
		}
	}

}
