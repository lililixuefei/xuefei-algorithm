package labuladong.interval;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Description
 * @Author xuefei
 * @Date 2023/10/14 19:19
 * @Version 1.0
 */
public class FindMinArrowShots {

    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) {
            return 0;
        }
        // 按 end 升序排序
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] point1, int[] point2) {
                if (point1[1] > point2[1]) {
                    return 1;
                } else if (point1[1] < point2[1]) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });

        // 至少有一个区间不相交
        int count = 1;
        // 排序后，第一个区间就是 x
        int x_end = points[0][1];
        for (int[] point : points) {
            int start = point[0];
            if (start > x_end) {
                // 找到下一个选择的区间了
                count++;
                x_end = point[1];
            }
        }
        return count;
    }

}
