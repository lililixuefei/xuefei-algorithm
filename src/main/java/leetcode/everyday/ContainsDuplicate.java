package leetcode.everyday;

import java.util.HashSet;
import java.util.Set;

/**
 * @description: 存在重复元素   https://leetcode.cn/problems/contains-duplicate/
 * @author: xuefei
 * @date: 2022/05/14 17:23
 */
public class ContainsDuplicate {

    public boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length == 1){
            return false;
        }

        Set<Integer> hashSet = new HashSet<>();
        for (int num : nums) {
            if (hashSet.contains(num)){
                return true;
            }
            hashSet.add(num);
        }
        return false;
    }
}
