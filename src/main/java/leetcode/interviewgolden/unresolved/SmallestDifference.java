package leetcode.interviewgolden.unresolved;

import java.util.Arrays;

/**
 * @Description 最小差
 * @Author xuefei
 * @Date 2023/9/16 14:49
 * @Version 1.0
 */
public class SmallestDifference {

    public static void main(String[] args) {
        int[] a = {-2147483648, 1};
        int[] b = {2147483647, 0};
        smallestDifference(a, b);
    }

    public static int smallestDifference(int[] a, int[] b) {

        Arrays.sort(a);
        Arrays.sort(b);

        double value = Double.MAX_VALUE;

        int i = 0;
        int j = 0;

        while (i < a.length && j < b.length) {
            if (a[i] <= b[j]) {
                value = Math.min(value, (double) b[j] - (double) a[i]);
                i++;
            } else if (a[i] > b[j]) {
                value = Math.min(value, (double) a[i] - (double) b[j]);
                j++;
            }
        }
        return (int) value;
    }

}
