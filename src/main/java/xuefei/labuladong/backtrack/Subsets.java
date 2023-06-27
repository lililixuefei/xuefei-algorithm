package xuefei.labuladong.backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @description: 输入一个无重复元素的数组nums，其中每个元素最多使用一次，请你返回nums的所有子集
 * @author: xuefei
 * @date: 2023/03/12 14:50
 */
public class Subsets {

	List<List<Integer>> res = new ArrayList<>();

	LinkedList track = new LinkedList();

	public List<List<Integer>> subsets(int[] nums) {
		backtrack(nums,0);
		return res;
	}

	public void backtrack(int[] nums,int start) {
		res.add(new ArrayList<>(track));
		for (int i = start; i < nums.length; i++) {
			track.add(nums[i]);
			backtrack(nums,i+1);
			track.removeLast();
		}
	}


}
