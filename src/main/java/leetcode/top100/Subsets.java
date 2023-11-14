package leetcode.top100;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description 子集
 * @Author xuefei
 * @Date 2023/11/14 22:58
 * @Version 1.0
 */
public class Subsets {


    List<List<Integer>> ans;
    LinkedList<Integer> path;

    public List<List<Integer>> subsets(int[] nums) {
        ans = new ArrayList<>();
        path = new LinkedList<>();
        process(nums, 0);
        return ans;
    }

    private void process(int[] nums, int i) {
        ans.add(new ArrayList<>(path));
        for (int j = i; j < nums.length; j++) {
            path.add(nums[j]);
            process(nums, j + 1);
            path.removeLast();
        }
    }


}
