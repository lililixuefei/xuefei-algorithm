package leetcode.swordfingeroffer.resolved;

/**
 * @description: 剑指 Offer 66. 构建乘积数组
 * @author: xuefei
 * @date: 2023/08/09 21:35
 */
public class ConstructArr {

    public int[] constructArr(int[] a) {

        int n = a.length;
        if (n < 2) {
            return new int[0];
        }

        int[] preProduct = new int[n];
        int[] sufProduct = new int[n];

        preProduct[0] = 1;
        sufProduct[n - 1] = 1;

        for (int i = 1; i < n; i++) {
            preProduct[i] = preProduct[i - 1] * a[i - 1];
        }

        for (int i = n - 2; i >= 0; i--) {
            sufProduct[i] = sufProduct[i + 1] * a[i + 1];
        }

        int[] constructArr = new int[n];

        for (int i = 0; i < n; i++) {
            constructArr[i] = preProduct[i] * sufProduct[i];
        }

        return constructArr;
    }

}
