package leetcode.onequestion.unresolved;


/**
 * @description: 修车的最少时间
 * @author: xuefei
 * @date: 2023/09/07 00:02
 */
public class RepairCars {

    public long repairCars(int[] ranks, int cars) {
        int minR = ranks[0];
        for (int r : ranks) {
            minR = Math.min(minR, r);
        }
        long left = 0;
        long right = (long) minR * cars * cars;
        while (left + 1 < right) { // 开区间
            long mid = (left + right) >> 1;
            long s = 0;
            for (int r : ranks) {
                s += Math.sqrt(mid / r);
            }
            if (s >= cars) {
                right = mid; // 满足要求
            } else {
                left = mid;
            }
        }
        return right; // 最小的满足要求的值
    }

}
