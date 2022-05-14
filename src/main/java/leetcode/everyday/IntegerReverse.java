package leetcode.everyday;

/**
 * @description: 整数反转   https://leetcode.cn/problems/reverse-integer/
 * @author: xuefei
 * @date: 2022/05/14 16:30
 */
public class IntegerReverse {

    public static void main(String[] args) {
        System.out.println(reverse(-2147483648));
    }


    public static int reverse(int x) {
        if (x == 0 || x / 10 == 0) {
            return x;
        }

        long longX = x;


        boolean m = false;
        if (longX < 0) {
            m = true;
            longX = -longX;
            if (longX > Integer.MAX_VALUE) {
                return 0;
            }
        }

        long reverseX = 0;

        while (longX >= 10) {
            // 余数
            long remainder = longX % 10;

            reverseX = reverseX * 10 + remainder;

            // 商
            longX = longX / 10;
        }
        reverseX = reverseX * 10 + longX;

        if (reverseX > Integer.MAX_VALUE) {
            return 0;
        }


        if (m) {
            return -(int) reverseX;
        }
        return (int) reverseX;
    }
}
