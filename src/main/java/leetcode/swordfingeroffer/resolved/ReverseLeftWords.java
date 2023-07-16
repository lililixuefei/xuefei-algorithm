package leetcode.swordfingeroffer.resolved;

/**
 * @description: 剑指 Offer 58 - II. 左旋转字符串
 * @author: xuefei
 * @date: 2023/07/16 16:47
 */
public class ReverseLeftWords {

	public String reverseLeftWords(String s, int n) {

//		return s.substring(n) + s.substring(0, n);

		char[] chars = s.toCharArray();
		StringBuilder stringBuilder = new StringBuilder();
		for (int i = n; i < chars.length; i++) {
			stringBuilder.append(chars[i]);
		}

		for (int i = 0; i < n; i++) {
			stringBuilder.append(chars[i]);
		}
		return stringBuilder.toString();

	}

}
