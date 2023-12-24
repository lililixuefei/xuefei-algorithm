package leetcode.top100.hash;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @Description 最长连续序列
 * @Author xuefei
 * @Date 2023/10/26 23:57
 * @Version 1.0
 */
public class LongestConsecutive {

    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2};
        int[] nums2 = {1, 2, 0, 1};
        longestConsecutive(nums2);
    }

    public static int longestConsecutive(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }
        // 转化成哈希集合，方便快速查找是否存在某个元素
        Set<Integer> set = new HashSet<Integer>();
        for (int num : nums) {
            set.add(num);
        }
        int res = 0;
        for (int num : set) {
            if (set.contains(num - 1)) {
                // num 不是连续子序列的第一个，跳过
                continue;
            }
            // num 是连续子序列的第一个，开始向上计算连续子序列的长度
            int curNum = num;
            int curLen = 1;

            while (set.contains(curNum + 1)) {
                curNum += 1;
                curLen += 1;
            }
            // 更新最长连续序列的长度
            res = Math.max(res, curLen);
        }
        return res;
    }


    public static int longestConsecutive_me_r(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }
        nums = Arrays.stream(nums).distinct().toArray();
        Arrays.sort(nums);
        int ans = 1;
        int l = 0;
        int r = 1;
        int pre = 0;
        while (r < nums.length) {
            if (nums[r] - nums[pre] == 1) {
                pre = r;
                r++;
                ans = Math.max(ans, r - l);
            } else {
                l = r;
                pre = r;
                r++;
            }
        }
        return ans;
    }

}
