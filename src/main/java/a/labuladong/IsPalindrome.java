package a.labuladong;

/**
 * @description: 验证回文串
 * @author: xuefei
 * @date: 2022/07/12 22:59
 */
public class IsPalindrome {

    public boolean isPalindrome(String s) {
        // 一左一右两个指针相向而行
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                ++left;
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                --right;
            }
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
