package leetcode.basic.dp.basic.knapsack;

import java.util.LinkedList;
import java.util.List;

/**
 * @description: 组合总和 Ⅳ
 * @author: xuefei
 * @date: 2023/06/28 23:02
 */
public class CombinationSum4 {

    List<List<Integer>> res = new LinkedList<>();
    // 记录回溯的路径
    LinkedList<Integer> track = new LinkedList<>();
    // 记录 track 中的路径和
    int trackSum = 0;

    public static void main(String[] args) {
        CombinationSum4 combinationSum4 = new CombinationSum4();
        int[] nums = {4,2,1};
        System.out.println(combinationSum4.combinationSum4(nums, 32));
    }

    public int combinationSum4(int[] nums, int target) {
        if (nums.length == 0) {
            return 0;
        }
        backtrack(nums, target);
        return res.size();
    }

    // 回溯算法主函数
    void backtrack(int[] nums, int target) {
        // base case，找到目标和，记录结果
        if (trackSum == target) {
            res.add(new LinkedList<>(track));
            return;
        }
        // base case，超过目标和，停止向下遍历
        if (trackSum > target) {
            return;
        }

        // 回溯算法标准框架
        for (int i = 0; i < nums.length; i++) {
            // 选择 nums[i]
            trackSum += nums[i];
            track.add(nums[i]);
            // 递归遍历下一层回溯树
            // 同一元素可重复使用，注意参数
            backtrack(nums, target);
            // 撤销选择 nums[i]
            trackSum -= nums[i];
            track.removeLast();
        }
    }

}
