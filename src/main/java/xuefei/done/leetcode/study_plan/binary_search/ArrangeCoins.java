package xuefei.done.leetcode.study_plan.binary_search;

/**
 * @description: 排列硬币   https://leetcode.cn/problems/arranging-coins/
 * @author: xuefei
 * @date: 2022/05/19 23:44
 */
public class ArrangeCoins {

    public static void main(String[] args) {
        System.out.println(arrangeCoins(1804289383));
    }


    public static int arrangeCoins(int n) {
        int left = 1, right = n;
        while (left < right) {
            int mid = (right - left + 1) / 2 + left;
            if ((long) mid * (mid + 1) <= (long) 2 * n) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}
