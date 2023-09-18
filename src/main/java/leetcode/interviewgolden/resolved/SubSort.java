package leetcode.interviewgolden.resolved;

import java.util.Arrays;

/**
 * @Description 部分排序
 * @Author xuefei
 * @Date 2023/9/18 23:14
 * @Version 1.0
 */
public class SubSort {

    public static void main(String[] args) {
        int[] array = {1, 3, 9, 7, 5};
        subSort(array);
    }

    public int[] subSort2(int[] array) {
        if (array == null || array.length == 0) {
            return new int[]{-1, -1};
        }
        int last = -1;
        int first = -1;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int len = array.length;
        for (int i = 0; i < len; i++) {
            if (array[i] < max) {
                last = i;
            } else {
                max = Math.max(max, array[i]);
            }

            if (array[len - 1 - i] > min) {
                first = len - 1 - i;
            } else {
                min = Math.min(min, array[len - 1 - i]);
            }
        }
        return new int[]{first, last};
    }


    public static int[] subSort(int[] array) {
        int[] arrayTemp = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            arrayTemp[i] = array[i];
        }
        Arrays.sort(arrayTemp);

        int left = -1;
        int right = -1;

        for (int i = 0; i < array.length; i++) {
            if (array[i] != arrayTemp[i]) {
                left = i;
                break;
            }
        }
        for (int i = array.length; i > 0; i--) {
            if (array[i] != arrayTemp[i]) {
                right = i;
                break;
            }
        }
        return new int[]{left, right};
    }

}
