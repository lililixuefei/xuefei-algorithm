package leetcode.swordfingeroffer;

/**
 * @description: 剑指 Offer 50. 第一个只出现一次的字符
 * @author: xuefei
 * @date: 2023/07/17 23:13
 */
public class FirstUniqChar {

		public char firstUniqChar(String s) {
			if (s == null || s.length() < 1) {
				return ' ';
			}
			int[] ans = new int[26];
			for (int i = 0; i < s.length(); i++) {
				ans[s.charAt(i) - 'a']++;
			}
			for (int i = 0; i < s.length(); i++) {
				if (ans[s.charAt(i) - 'a'] == 1){
					return s.charAt(i);
				}
			}
			return ' ';
		}

}
