package me.arr;

/**
 * @description: 加一
 * @author: xuefei
 * @date: 2022/09/05 00:55
 */
public class PlusOne {

    public static void main(String[] args) {
        int[] digits = {9};
        plusOne(digits);
    }

    public static int[] plusOne(int[] digits) {
        if (digits == null || digits.length < 1) {
            return digits;
        }
        int length = digits.length - 1;
        int carry = 1;
        for (int i = length; i >= 0; i--) {
            int curNum = digits[i];
            curNum = curNum + carry;
            if (curNum != 10) {
                digits[i] = curNum;
                return digits;
            } else {
                digits[i] = 0;
                carry = 1;
            }
        }

        if (digits[0] == 0) {
            int[] ans = new int[digits.length + 1];
            ans[0] = 1;
            for (int i = 1; i < ans.length; i++) {
                ans[i] = digits[i - 1];
            }
            return ans;
        } else {
            return digits;
        }
    }
}
