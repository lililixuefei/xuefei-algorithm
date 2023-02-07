package xuefei.done.leetcode.study_plan.binary_search;

/**
 * @description: 猜数字大小   https://leetcode.cn/problems/guess-number-higher-or-lower/
 * @author: xuefei
 * @date: 2022/05/14 17:20
 */
public class GuessNumber {

//    public int guessNumber(int n) {
//        int left = 1, right = n;
//        // 循环直至区间左右端点相同
//        while (left < right) {
//            // 防止计算时溢出
//            int mid = left + (right - left) / 2;
//            if (guess(mid) <= 0) {
//                // 答案在区间 [left, mid] 中
//                right = mid;
//            } else {
//                // 答案在区间 [mid+1, right] 中
//                left = mid + 1;
//            }
//        }
//        // 此时有 left == right，区间缩为一个点，即为答案
//        return left;
//    }
}
