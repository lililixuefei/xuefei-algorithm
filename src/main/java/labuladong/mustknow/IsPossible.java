package labuladong.mustknow;

import java.util.HashMap;

/**
 * @Description 分割数组为连续子序列
 * @Author xuefei
 * @Date 2023/12/3 17:09
 * @Version 1.0
 */
public class IsPossible {


	/**
	 * 检查序列是否可以被分成长度至少为 3 的连续子序列
	 * 每个子序列中不同的整数数量要相同
	 *
	 * @param nums 检查的序列
	 * @return 序列能够被组成子序列返回 true，否则返回 false
	 */
	public boolean isPossible(int[] nums) {

		// 维护每个数在 nums 数组中出现的次数
		HashMap<Integer, Integer> freq = new HashMap<>();
		// 维护每个数作为结尾的连续子序列的需求量
		HashMap<Integer, Integer> need = new HashMap<>();

		// 遍历 nums 数组统计每个数在 nums 数组中出现的次数
		for (int v : nums) {
			freq.put(v, freq.getOrDefault(v, 0) + 1);
		}

		for (int v : nums) {
			// 如果 v 已经被用到其他子序列中则无法再被用到
			if (freq.get(v) == 0) {
				continue;
			}
			// 尝试将 v 接到之前的某个序列后面
			if (need.containsKey(v) && need.get(v) > 0) {
				// v 可以接到之前的某个序列后面
				freq.put(v, freq.get(v) - 1);
				need.put(v, need.get(v) - 1);
				need.put(v + 1, need.getOrDefault(v + 1, 0) + 1);
			} else if (freq.containsKey(v) && freq.get(v) > 0 && freq.containsKey(v + 1) && freq.get(v + 1) > 0 && freq.containsKey(v + 2) && freq.get(v + 2) > 0) {
				// 第二种情况，新建一个长度为 3 的子序列 [v, v+1, v+2]
				freq.put(v, freq.get(v) - 1);
				freq.put(v + 1, freq.get(v + 1) - 1);
				freq.put(v + 2, freq.get(v + 2) - 1);
				need.put(v + 3, need.getOrDefault(v + 3, 0) + 1);
			} else {
				// 两种情况都不符合，则无法分配
				return false;
			}
		}
		return true;
	}

}