package leetcode.study_plan.binary_search;

/**
 * @description: 有效的完全平方数   https://leetcode.cn/problems/valid-perfect-square/
 * @author: xuefei
 * @date: 2022/05/16 22:50
 */
public class IsPerfectSquare {

    public static void main(String[] args) {

    }

    public boolean isPerfectSquare(int num) {
        int left = 0, right = num;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            long square = (long) mid * mid;
            if (square < num) {
                left = mid + 1;
            } else if (square > num) {
                right = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
