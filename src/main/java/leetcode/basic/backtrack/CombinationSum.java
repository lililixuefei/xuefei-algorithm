package leetcode.basic.backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @description: 组合总和
 * @author: xuefei
 * @date: 2023/03/09 23:38
 */
public class CombinationSum {

	long sum = 0;

	List<List<Integer>> res = new ArrayList<>();

	LinkedList<Integer> track = new LinkedList<>();


	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		combinationSum(candidates, target, 0);
		return res;
	}

	public void combinationSum(int[] candidates, int target, int start) {
		if (sum == target) {
			res.add(new ArrayList<>(track));
			return;
		}
		if (sum > target) {
			return;
		}

		for (int i = start; i < candidates.length; i++) {
			sum += candidates[i];
			track.add(candidates[i]);
			combinationSum(candidates, target, i);
			sum -= candidates[i];
			track.removeLast();
		}
	}

}
