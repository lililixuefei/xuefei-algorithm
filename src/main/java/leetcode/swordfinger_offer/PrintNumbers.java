package leetcode.swordfinger_offer;

import java.util.Arrays;

/**
 * @description: 剑指 Offer 17. 打印从1到最大的n位数
 * @author: xuefei
 * @date: 2022/11/13 19:24
 */
public class PrintNumbers {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(printNumbers(1)));
    }

    public static int[] printNumbers(int n) {
        int maxNum = (int) Math.pow(10, n);
        int[] ans = new int[maxNum - 1];
        for (int i = 0; i < maxNum - 1; i++) {
            ans[i] = i + 1;
        }
        return ans;
    }
}
