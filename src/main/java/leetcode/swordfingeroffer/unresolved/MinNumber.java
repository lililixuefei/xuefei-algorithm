package leetcode.swordfingeroffer.unresolved;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @description: 剑指 Offer 45. 把数组排成最小的数
 * @author: xuefei
 * @date: 2023/07/22 19:30
 */
public class MinNumber {

	public static void main(String[] args) {

		int[] nums = {10, 2};

		System.out.println(minNumber(nums));

	}

	public static String minNumber(int[] nums) {
		int n = nums.length;
		String[] strs = new String[n];
		for (int i = 0; i < n; i++) {
			strs[i] = Integer.toString(nums[i]);
		}
		Arrays.sort(strs, (s1, s2) -> {
			// 看看那种拼接方式得到的数字更小，排前面
			// 不用转成 int 类型，因为字符串的比较算法和正整数的比较算法是一样的
			// 而且拼接字符串比较长，会导致 int 类型溢出
			return (s1 + s2).compareTo(s2 + s1);
		});

		return String.join("", strs);
	}


	public static String minNumber_wrong(int[] nums) {
		PriorityQueue<Long> priorityQueue = new PriorityQueue<>(nums.length, new Comparator<Long>() {
			@Override
			public int compare(Long o1, Long o2) {
				return ((Long.parseLong(o1 + "" + o2)) - Long.parseLong(o2 + "" + o1)) > 0 ? 1 : -1;
			}
		});
		for (int num : nums) {
			priorityQueue.add((long) num);
		}

		StringBuilder stringBuilder = new StringBuilder();
		for (int i = 0; i < nums.length; i++) {
			Integer num = priorityQueue.poll().intValue();
			stringBuilder.append(num);
		}
		return stringBuilder.toString();
	}

}
