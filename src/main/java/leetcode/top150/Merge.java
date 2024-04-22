package leetcode.top150;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Description
 * @Author xuefei
 * @Date 2024/4/22 22:53
 * @Version 1.0
 */
public class Merge {


    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) {
            return;
        }
        int l = 0;
        int r = 0;
        int[] array = new int[m + n];

        int i = 0;
        while (l < m && r < n) {
            array[i++] = nums1[l] <= nums2[r] ? nums1[l++] : nums2[r++];
        }
        while (l < m) {
            array[i++] = nums1[l++];
        }
        while (r < n) {
            array[i++] = nums2[r++];
        }
        System.arraycopy(array, 0, nums1, 0, array.length);
    }


    public void merge(int[] nums1, int m, int[] nums2, int n) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(a -> a));
        for (int i = 0; i < m; i++) {
            priorityQueue.add(nums1[i]);
        }
        for (int i = 0; i < n; i++) {
            priorityQueue.add(nums2[i]);
        }
        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = priorityQueue.poll();
        }
    }

}
