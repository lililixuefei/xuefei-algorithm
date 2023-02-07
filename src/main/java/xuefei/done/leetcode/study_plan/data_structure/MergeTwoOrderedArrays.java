package xuefei.done.leetcode.study_plan.data_structure;

/**
 * @description: 合并两个有序数组   https://leetcode.cn/problems/merge-sorted-array/
 * @author: xuefei
 * @date: 2022/05/15 20:40
 */
public class MergeTwoOrderedArrays {

    public static void main(String[] args) {
//        int[] nums1 = {1, 2, 3, 0, 0, 0};
//        int[] nums2 = {2, 5, 6};
//        merge(nums1, 3, nums2, 3);


        int[] nums1 = {-1, 0, 0, 3, 3, 3, 0, 0, 0};
        int[] nums2 = {1, 2, 2};
        merge(nums1, 6, nums2, 3);
        for (int j : nums1) {
            System.out.println(j);
        }
    }


    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = 0, p2 = 0;
        int[] sorted = new int[m + n];
        int cur;
        while (p1 < m || p2 < n) {
            if (p1 == m) {
                cur = nums2[p2++];
            } else if (p2 == n) {
                cur = nums1[p1++];
            } else if (nums1[p1] < nums2[p2]) {
                cur = nums1[p1++];
            } else {
                cur = nums2[p2++];
            }
            sorted[p1 + p2 - 1] = cur;
        }
        for (int i = 0; i != m + n; ++i) {
            nums1[i] = sorted[i];
        }
    }


    public static void merge1(int[] nums1, int m, int[] nums2, int n) {
        int nums1Length = nums1.length;
        int[] copyNums1 = new int[nums1Length];
        int[] copyNums2 = new int[nums1Length];

        for (int i = 0; i < nums1Length; i++) {
            if (i < m) {
                copyNums1[i] = nums1[i];
            } else {
                copyNums1[i] = Integer.MAX_VALUE;
            }
            if (i < n) {
                copyNums2[i] = nums2[i];
            } else {
                copyNums2[i] = Integer.MAX_VALUE;
            }
        }

        int index1 = 0;
        int index2 = 0;
        for (int i = 0; i < nums1Length; i++) {
            int num1 = copyNums1[index1];
            int num2 = copyNums2[index2];
            if (num1 == Integer.MAX_VALUE) {
                index1++;
                index2++;
                nums1[i] = num2;
            } else if (num2 == Integer.MAX_VALUE) {
                index1++;
                index2++;
                nums1[i] = num1;
            } else if (num1 <= num2) {
                index1++;
                nums1[i] = num1;
            } else {
                index2++;
                nums1[i] = num2;
            }
        }
    }
}
