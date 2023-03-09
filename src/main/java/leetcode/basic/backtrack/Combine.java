package leetcode.basic.backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @description: 组合
 * @author: xuefei
 * @date: 2023/03/09 23:28
 */
public class Combine {


	List<List<Integer>> res = new ArrayList<>();

	LinkedList<Integer> track = new LinkedList<>();

	public List<List<Integer>> combine(int n, int k) {
		combine(n, k, 1);
		return res;
	}

	public void combine(int n, int k, int start) {
		if (track.size() == k) {
			res.add(new ArrayList<>(track));
			return;
		}

		for (int i = start; i < n; i++) {
			track.add(i);
			combine(n, k, i + 1);
			track.removeLast();
		}
	}

}
