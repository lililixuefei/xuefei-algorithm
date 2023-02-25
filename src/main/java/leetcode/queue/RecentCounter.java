package leetcode.queue;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 写一个 RecentCounter 类来计算特定时间范围内最近的请求。
 * @author: xuefei
 * @date: 2023/02/25 19:00
 */
public class RecentCounter {

	private final List<Integer> list;

	public RecentCounter() {
		list = new ArrayList<>();
	}

	public int ping(int t) {
		addPing(t);
		return recentCount(t);
	}

	private int recentCount(int t) {
		int i = t - 3000;
		int count = 0;
		for (int j = list.size() - 1; j >= 0; j--) {
			Integer value = list.get(j);
			if (value <= t && value >= i) {
				count++;
			}
		}
		return count;
	}

	private void addPing(int t) {
		list.add(t);
	}
}
