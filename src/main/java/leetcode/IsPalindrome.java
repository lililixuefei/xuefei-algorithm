package leetcode;

import java.util.Stack;

/**
 * @description: 回文数   https://leetcode-cn.com/problems/palindrome-number/
 * @author: xuefei
 * @date: 2022/05/02 20:15
 */
public class IsPalindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome(1001));
    }

    public static boolean isPalindrome(int x) {
        // 特殊情况：
        // 如上所述，当 x < 0 时，x 不是回文数。
        // 同样地，如果数字的最后一位是 0，为了使该数字为回文，
        // 则其第一位数字也应该是 0
        // 只有 0 满足这一属性
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int revertedNumber = 0;
        while (x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }

        // 当数字长度为奇数时，我们可以通过 revertedNumber/10 去除处于中位的数字。
        // 例如，当输入为 12321 时，在 while 循环的末尾我们可以得到 x = 12，revertedNumber = 123，
        // 由于处于中位的数字不影响回文（它总是与自己相等），所以我们可以简单地将其去除。
        return x == revertedNumber || x == revertedNumber / 10;
    }

    public boolean isPalindromeWay3(int x) {
        String reversedStr = (new StringBuilder(x + "")).reverse().toString();
        return (x + "").equals(reversedStr);
    }


    public static boolean isPalindromeWay2(int x) {
        String line = String.valueOf(x);
        int leftIndex = 0, rightIndex = line.length() - 1;
        while (leftIndex <= rightIndex) {
            char leftC = line.charAt(leftIndex++);
            char rightC = line.charAt(rightIndex--);
            if (leftC != rightC) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPalindromeWay1(int x) {
        String s1 = String.valueOf(x);

        Stack<Character> stack = new Stack();

        for (int i = 0; i < s1.length(); i++) {
            stack.push(s1.charAt(i));
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        String s2 = sb.toString();

        return s1.equals(s2);
    }
}
