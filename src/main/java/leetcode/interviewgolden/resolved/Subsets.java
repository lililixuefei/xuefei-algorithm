package leetcode.interviewgolden.resolved;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @description: 幂集
 * @author: xuefei
 * @date: 2023/08/27 21:44
 */
public class Subsets {


    List<List<Integer>> ans = new ArrayList<>();

    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> subsets(int[] nums) {
        backtrack(nums, 0, path);
        return ans;
    }

    private void backtrack(int[] nums, int i, LinkedList<Integer> path) {
        ans.add(new ArrayList<>(path));
        for (int k = i; k < nums.length; k++) {
            path.add(nums[k]);
            backtrack(nums, k + 1, path);
            path.removeLast();
        }
    }

}
