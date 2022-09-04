package me.arr;

import java.util.*;

/**
 * @description: 两个数组的交集
 * @author: xuefei
 * @date: 2022/09/05 01:14
 */
public class Intersection {

    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length < 1){
            return nums1;
        }
        if (nums2 == null || nums2.length < 1){
            return nums2;
        }
        Set<Integer> set1 = new HashSet<>();
        for (int i : nums1) {
            set1.add(i);
        }
        Set<Integer> set2= new HashSet<>();
        for (int i : nums2) {
            set2.add(i);
        }

        set1.retainAll(set2);

        int[] ans = new int[set1.size()];

        int i = 0;
        for (Integer num : set1) {
            ans[i++] = num;
        }
        return ans;
    }
}
