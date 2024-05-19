package leetcode.top100.ame.binarysearch;

/**
 * @Description
 * @Author xuefei
 * @Date 2024/4/23 22:27
 * @Version 1.0
 */
public class FindMedianSortedArrays {

    public static void main(String[] args) {
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};
        findMedianSortedArrays(nums1, nums2);
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[] nums = new int[m + n];
        int i = 0;
        int p0 = 0;
        int p1 = 0;
        while (p0 < m && p1 < n) {
            nums[i++] = nums1[p0] <= nums2[p1] ? nums1[p0++] : nums2[p1++];
        }
        while (p0 < m) {
            nums[i++] = nums1[p0++];
        }
        while (p1 < n) {
            nums[i++] = nums2[p1++];
        }
        if (nums.length % 2 == 0) {
            return (nums[nums.length / 2] + nums[nums.length / 2 - 1]) / 2.0;
        } else {
            return (nums[nums.length / 2]);
        }
    }

}
