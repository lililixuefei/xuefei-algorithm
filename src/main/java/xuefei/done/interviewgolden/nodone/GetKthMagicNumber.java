package xuefei.done.interviewgolden.nodone;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @description: 第 k 个数
 * @author: xuefei
 * @date: 2023/03/12 22:40
 */
public class GetKthMagicNumber {

	public static void main(String[] args) {
		System.out.println(getKthMagicNumber(11));
	}

	public static int getKthMagicNumber(int k) {
		int[] factors = {3, 5, 7};
		PriorityQueue<Long> heap = new PriorityQueue<>();
		Set<Long> seen = new HashSet<>();
		seen.add(1L);
		heap.offer(1L);
		int magic = 0;
		for (int i = 0; i < k; i++) {
			long curr = heap.poll();
			magic = (int) curr;
			for (int factor : factors) {
				long next = curr * factor;
				if (seen.add(next)) {
					heap.offer(next);
				}
			}
		}
		return magic;
	}

}
