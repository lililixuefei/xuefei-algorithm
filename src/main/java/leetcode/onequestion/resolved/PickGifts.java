package leetcode.onequestion.resolved;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Description 从数量最多的堆取走礼物
 * @Author xuefei
 * @Date 2023/10/28 19:57
 * @Version 1.0
 */
public class PickGifts {

    public long pickGifts(int[] gifts, int k) {
        if (gifts == null || gifts.length == 0) {
            return 0L;
        }

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(gifts.length, (o1, o2) -> o2 - o1);
        for (int gift : gifts) {
            priorityQueue.add(gift);
        }

        long ans = 0;
        for (int i = 0; i < k; i++) {
            Integer gift = priorityQueue.peek();
            if (gift == null || gift == 1) {
                break;
            }
            gift = priorityQueue.poll();
            double sqrt = Math.sqrt(gift);
            priorityQueue.add((int) sqrt);
        }
        for (Integer gift : priorityQueue) {
            ans += gift;
        }
        return ans;

    }

}
