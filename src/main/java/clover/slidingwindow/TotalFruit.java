package clover.slidingwindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @description: 水果成篮
 * @author: xuefei
 * @date: 2023/03/20 23:09
 */
public class TotalFruit {

	public static void main(String[] args) {
		totalFruit(new int[]{0, 1, 2, 2});
	}

	public static int totalFruit(int[] fruits) {
		int n = fruits.length;
		Map<Integer, Integer> cnt = new HashMap<>();

		int left = 0;
		int ans = 0;
		for (int right = 0; right < n; ++right) {
			cnt.put(fruits[right], cnt.getOrDefault(fruits[right], 0) + 1);
			while (cnt.size() > 2) {
				cnt.put(fruits[left], cnt.get(fruits[left]) - 1);
				if (cnt.get(fruits[left]) == 0) {
					cnt.remove(fruits[left]);
				}
				++left;
			}
			ans = Math.max(ans, right - left + 1);
		}
		return ans;
	}
}
