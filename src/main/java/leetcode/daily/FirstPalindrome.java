package leetcode.daily;

/**
 * @description: 找出数组中的第一个回文字符串
 * @author: xuefei
 * @date: 2023/02/26 19:38
 */
public class FirstPalindrome {

	public String firstPalindrome(String[] words) {

		for (String word : words) {
			if (isPalindrome(word)){
				return word;
			}
		}
		return "";

	}

	private boolean isPalindrome(String word) {
		int i = 0;
		int j = word.length() - 1;
		while (i < j){
			if (word.charAt(i++) != word.charAt(j--)){
				return false;
			}
		}
		return true;
	}

}
