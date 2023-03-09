package leetcode.basic.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @description: 组合总和 II
 * @author: xuefei
 * @date: 2023/03/09 23:59
 */
public class CombinationSum2 {

	long sum = 0;

	List<List<Integer>> res = new ArrayList<>();

	LinkedList<Integer> track = new LinkedList<>();

	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		Arrays.sort(candidates);
		combinationSum2(candidates,target,0);
		return res;
	}

	public void combinationSum2(int[] candidates, int target, int start) {
		if (sum == target){
			res.add(new ArrayList<>(track));
			return;
		}

		if (sum > target){
			return;
		}

		for (int i = start; i < candidates.length; i++) {
			if (i > start && candidates[i] == candidates[i-1]){
				continue;
			}
			sum += candidates[i];
			track.add(candidates[i]);
			combinationSum2(candidates, target, i + 1);
			sum -= candidates[i];
			track.removeLast();

		}
	}

}
