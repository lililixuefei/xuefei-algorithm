package labuladong.backtrack;


import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description
 * @Author xuefei
 * @Date 2023/3/9 7:58 下午
 * @Version 1.0
 */
public class PermuteUnique {

	static List<List<Integer>> res = new LinkedList<>();
	static LinkedList<Integer> track = new LinkedList<>();
	static boolean[] used;

	public static void main(String[] args) {
		int[] nums = new int[]{1, 1, 3};
		List<List<Integer>> permute = permuteUnique(nums);

		for (List<Integer> integers : permute) {
			String res = StringUtils.join(integers, ",");
			System.out.println(res);
		}
	}

	public static List<List<Integer>> permuteUnique(int[] nums) {
		// 先排序，让相同的元素靠在一起
		Arrays.sort(nums);
		used = new boolean[nums.length];
		backtrack(nums);
		return res;
	}

	static void backtrack(int[] nums) {
		if (track.size() == nums.length) {
			res.add(new LinkedList(track));
			return;
		}

		for (int i = 0; i < nums.length; i++) {
			if (used[i]) {
				continue;
			}
			// 新添加的剪枝逻辑，固定相同的元素在排列中的相对位置
			if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
				continue;
			}
			track.add(nums[i]);
			used[i] = true;
			backtrack(nums);
			track.removeLast();
			used[i] = false;
		}
	}

}
