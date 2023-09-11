package labuladong.array;

/**
 * @Description
 * @Author xuefei
 * @Date 2023/8/7 10:50 AM
 * @Version 1.0
 */
public class IsPalindrome {

	boolean isPalindrome(String s) {
		// 一左一右两个指针相向而行
		int left = 0, right = s.length() - 1;
		while (left < right) {
			if (s.charAt(left) != s.charAt(right)) {
				return false;
			}
			left++;
			right--;
		}
		return true;
	}

}
