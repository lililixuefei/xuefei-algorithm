package leetcode.top100.ame.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Description
 * @Author xuefei
 * @Date 2024/4/3 22:05
 * @Version 1.0
 */
public class MedianFinder {

	private PriorityQueue<Integer> small;
	private PriorityQueue<Integer> big;

	public MedianFinder() {
		small = new PriorityQueue<>();
		big = new PriorityQueue<>((o1, o2) -> o2 - o1);
	}

	public void addNum(int num) {
		if (small.size() >= big.size()) {
			small.add(num);
			big.add(small.poll());
		} else {
			big.add(num);
			small.add(big.poll());
		}

	}

	public double findMedian() {
		if (small.size() > big.size()) {
			return small.peek();
		} else if (small.size() < big.size()) {
			return big.peek();
		} else {
			return (small.peek() + big.peek()) / 2.0;
		}
	}

}

