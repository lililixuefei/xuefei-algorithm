package leetcode.swordfingeroffer.unresolved;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @description: 剑指 Offer 49. 丑数
 * @author: xuefei
 * @date: 2023/08/03 22:39
 */
public class NthUglyNumber {

    public int nthUglyNumber(int n) {
        int[] factors = {2, 3, 5};
        Set<Long> seen = new HashSet<>();
        PriorityQueue<Long> heap = new PriorityQueue<>();
        seen.add(1L);
        heap.offer(1L);
        int ugly = 0;
        for (int i = 0; i < n; i++) {
            long curr = heap.poll();
            ugly = (int) curr;
            for (int factor : factors) {
                long next = curr * factor;
                if (seen.add(next)) {
                    heap.offer(next);
                }
            }
        }
        return ugly;
    }

}
