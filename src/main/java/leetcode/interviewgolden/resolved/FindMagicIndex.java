package leetcode.interviewgolden.resolved;

/**
 * @description: 魔术索引
 * @author: xuefei
 * @date: 2023/08/27 16:11
 */
public class FindMagicIndex {

    public int findMagicIndex(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == i) {
                return i;
            }
        }
        return -1;
    }

    public int findMagicIndex2(int[] nums) {
        int flag = 0;
        while (flag < nums.length) {
            if (nums[flag] == flag) {
                return flag;
            } else if (nums[flag] > flag) {
                flag = nums[flag];
            } else {
                flag++;
            }
        }
        return -1;
    }


}
