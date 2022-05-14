package leetcode.everyday;

/**
 * @description: 在区间范围内统计奇数数目   https://leetcode.cn/problems/count-odd-numbers-in-an-interval-range/
 * @author: xuefei
 * @date: 2022/05/14 18:06
 */
public class CountOdds {

    public static void main(String[] args) {
        System.out.println(countOdds(3, 15));
    }

    public static int countOdds(int low, int high) {

        boolean isLowOdd = low % 2 == 1;
        boolean isHighOdd = high % 2 == 1;

        if (isLowOdd && isHighOdd) {
            return (high - low + 2) / 2;
        }

        if (!isLowOdd && !isHighOdd) {
            return (high - low) / 2;
        }

        return (high - low + 1) / 2;
    }
}
