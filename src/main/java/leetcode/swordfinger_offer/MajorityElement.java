package leetcode.swordfinger_offer;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 剑指 Offer 39. 数组中出现次数超过一半的数字
 * @author: xuefei
 * @date: 2022/11/13 19:42
 */
public class MajorityElement {

    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{1, 2, 3, 2, 2, 2, 5, 4, 2}));
    }

    public static int majorityElement(int[] nums) {
        int count = 0;
        Integer candidate = null;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += ((num == candidate) ? 1 : -1);
        }

        return candidate;
    }


    public static int majorityElement2(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                Integer count = map.get(num);
                map.put(num, ++count);
            } else {
                map.put(num, 1);
            }
        }
        int ans = 0;
        int count = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            if (count < value) {
                count = value;
                ans = key;
            }
        }
        return ans;
    }
}
