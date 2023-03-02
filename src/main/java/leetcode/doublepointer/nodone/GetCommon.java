package leetcode.doublepointer.nodone;

import java.util.*;

/**
 * @description: 最小公共值
 * @author: xuefei
 * @date: 2023/03/03 00:05
 */
public class GetCommon {

	/**
	 * 双指针
	 *
	 * @param nums1
	 * @param nums2
	 * @return
	 */
	public int getCommon(int[] nums1, int[] nums2) {
		int i = 0;
		int j = 0;
		while (i < nums1.length && j < nums2.length) {
			if (nums1[i] < nums2[j]) {
				i++;
			} else if (nums1[i] > nums2[j]) {
				j++;
			} else {
				return nums1[i];
			}
		}
		return -1;
	}


	public int getCommon_me(int[] nums1, int[] nums2) {
		Set<Integer> set = new HashSet<>();
		for (int num : nums1) {
			set.add(num);
		}
		for (int num : nums2) {
			if (set.contains(num)) {
				return num;
			}
		}
		return -1;
	}

}
