package leetcode.onequestion.resolved;

/**
 * @description: 合并两个有序数组
 * @author: xuefei
 * @date: 2023/08/13 01:26
 */
public class Merge {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums2.length < 1) {
            return;
        }
        int[] temp = new int[m + n];

        int p = 0;

        int i = 0;
        int j = 0;

        while (i < m && j < n) {
            temp[p++] = nums1[i] <= nums2[j] ? nums1[i++] : nums2[j++];
        }

        while (i < m) {
            temp[p++] = nums1[i++];
        }
        while (j < n) {
            temp[p++] = nums2[j++];
        }

        for (int k = 0; k < temp.length; k++) {
            nums1[k] = temp[k];
        }
    }

}
