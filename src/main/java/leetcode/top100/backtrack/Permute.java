package leetcode.top100.backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description 全排列
 * @Author xuefei
 * @Date 2023/11/14 22:53
 * @Version 1.0
 */
public class Permute {

    List<List<Integer>> ans;
    LinkedList<Integer> path;

    boolean[] used;

    public List<List<Integer>> permute(int[] nums) {
        ans = new ArrayList<>();
        path = new LinkedList<>();
        used = new boolean[nums.length];
        process(nums);
        return ans;
    }

    private void process(int[] nums) {
        if (path.size() == nums.length) {
            ans.add(new ArrayList<>(path));
            return;
        }

        for (int j = 0; j < nums.length; j++) {
            if (used[j]) {
                continue;
            }
            used[j] = true;
            path.add(nums[j]);
            process(nums);
            used[j] = false;
            path.removeLast();
        }
    }


}
