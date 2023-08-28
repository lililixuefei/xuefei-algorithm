package leetcode.onequestion.unresolved;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 汇总区间
 * @author: xuefei
 * @date: 2023/08/26 00:23
 */
public class SummaryRanges {

    // 输入：nums = [0,1,2,4,5,7]
    // 输出：["0->2","4->5","7"]

    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        int i = 0;
        int n = nums.length;
        while (i < n) {
            int low = i;
            i++;
            while (i < n && nums[i] == nums[i - 1] + 1) {
                i++;
            }
            int high = i - 1;
            StringBuilder temp = new StringBuilder(Integer.toString(nums[low]));
            if (low < high) {
                temp.append("->");
                temp.append(nums[high]);
            }
            res.add(temp.toString());
        }
        return res;
    }

}
