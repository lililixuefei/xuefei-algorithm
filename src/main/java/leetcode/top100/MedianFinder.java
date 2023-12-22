package leetcode.top100;

import java.util.PriorityQueue;

/**
 * @Description 数据流的中位数
 * @Author xuefei
 * @Date 2023/12/22 23:01
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
			small.offer(num);
			big.offer(small.poll());
		} else {
			big.offer(num);
			small.offer(big.poll());
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
