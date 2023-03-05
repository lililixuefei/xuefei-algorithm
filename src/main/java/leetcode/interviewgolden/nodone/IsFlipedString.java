package leetcode.interviewgolden.nodone;

/**
 * @description: 字符串轮转
 * @author: xuefei
 * @date: 2023/03/05 20:22
 */
public class IsFlipedString {

	public boolean isFlipedString(String s1, String s2) {
		return s1.length() == s2.length() && (s1 + s1).contains(s2);
	}

}
