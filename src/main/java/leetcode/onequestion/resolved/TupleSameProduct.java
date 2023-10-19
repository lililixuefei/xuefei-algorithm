package leetcode.onequestion.resolved;

import java.util.*;

/**
 * @description: 同积元组
 * @author: xuefei
 * @date: 2023/10/19 10:21
 */
public class TupleSameProduct {

    public static void main(String[] args) {
        int[] nums = {2, 3, 4, 6, 8, 12};
//        int[] nums = {1, 2, 4, 5, 10};
        System.out.println(tupleSameProduct(nums));
    }

    public static int tupleSameProduct(int[] nums) {
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                // 乘积
                int product = nums[i] * nums[j];
                Integer productCount = map.get(product);
                if (productCount == null) {
                    map.put(product, 1);
                } else {
                    ans += (productCount * 8);
                    map.put(product, productCount + 1);
                }
            }
        }
        return ans;
    }


}
