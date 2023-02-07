package xuefei.done.leetcode.study_plan.binary_search;

/**
 * @description: x 的平方根   https://leetcode.cn/problems/sqrtx/
 * @author: xuefei
 * @date: 2022/05/17 23:31
 */
public class MySqrt {

    public static void main(String[] args) {

    }

    public int mySqrt(int x) {
        int l = 0, r = x, ans = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if ((long) mid * mid <= x) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }


    public int mySqrt1(int x) {
        return (int) Math.pow(x, 0.5);
    }
}
