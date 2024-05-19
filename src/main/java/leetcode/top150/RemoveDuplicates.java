package leetcode.top150;

import java.util.LinkedHashSet;

/**
 * @Description
 * @Author xuefei
 * @Date 2024/4/22 23:15
 * @Version 1.0
 */
public class RemoveDuplicates {


    // 1 1 2
    public int removeDuplicates2(int[] nums) {
        if (nums.length == 1) {
            return 1;
        }
        int l = 0;
        int r = 1;
        while (r < nums.length) {
            if (nums[l] != nums[r]) {
                l++;
                swap(nums, l, r);
            }
            r++;
        }
        return l + 1;
    }

    private void swap(int[] nums, int l, int r) {
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }


    public int removeDuplicates(int[] nums) {
        LinkedHashSet<Integer> set = new LinkedHashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int i = 0;
        for (Integer num : set) {
            nums[i] = num;
        }
        return set.size();

    }

}
