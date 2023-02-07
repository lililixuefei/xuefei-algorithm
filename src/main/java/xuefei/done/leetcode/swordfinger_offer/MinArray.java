package xuefei.done.leetcode.swordfinger_offer;

/**
 * @description: 剑指 Offer 11. 旋转数组的最小数字
 * @author: xuefei
 * @date: 2022/11/13 13:40
 */
public class MinArray {


    public int minArray1(int[] numbers) {
        int l = 0;
        int r = numbers.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (numbers[mid] < numbers[r]) {
                r = mid;
            } else if (numbers[mid] > numbers[r]) {
                l = mid + 1;
            } else {
                r -= 1;
            }
        }
        return numbers[l];
    }

    public int minArray2(int[] numbers) {
        int minNum = Integer.MAX_VALUE;
        for (int number : numbers) {
            minNum = Math.min(minNum, number);
        }
        return minNum;
    }
}
