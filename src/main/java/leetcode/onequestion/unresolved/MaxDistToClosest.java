package leetcode.onequestion.unresolved;

/**
 * @description: 到最近的人的最大距离
 * @author: xuefei
 * @date: 2023/08/22 22:08
 */
public class MaxDistToClosest {

    public int maxDistToClosest(int[] seats) {
        int ans = 0;
        int count = 0;
        int n = seats.length;
        for (int i = 0; i < n && seats[i] == 0; i++) {
            ans++;
        }

        for (int i = ans + 1; i < n; i++) {
            if (seats[i] == 0) {
                count++;
            } else {
                ans = Math.max(ans, (count + 1) / 2);
                count = 0;

            }
        }
        return Math.max(ans, count);
    }

}
