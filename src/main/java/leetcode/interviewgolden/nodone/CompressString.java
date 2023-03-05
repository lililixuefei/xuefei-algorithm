package leetcode.interviewgolden.nodone;

/**
 * @description: 字符串压缩
 * @author: xuefei
 * @date: 2023/03/05 19:31
 */
public class CompressString {

	public static void main(String[] args) {
		System.out.println(compressString("aabcccccaa"));
	}

	public String compressString_official(String S) {
		if (S.length() == 0) { // 空串处理
			return S;
		}
		StringBuffer ans = new StringBuffer();
		int cnt = 1;
		char ch = S.charAt(0);
		for (int i = 1; i < S.length(); ++i) {
			if (ch == S.charAt(i)) {
				cnt++;
			} else {
				ans.append(ch);
				ans.append(cnt);
				ch = S.charAt(i);
				cnt = 1;
			}
		}
		ans.append(ch);
		ans.append(cnt);
		return ans.length() >= S.length() ? S : ans.toString();
	}

	public static String compressString(String S) {
		if (S.length() <= 2) {
			return S;
		}
		int l = 0;
		StringBuilder stringBuilder = new StringBuilder();
		int i = 0;
		for (; i < S.length(); i++) {
			if (S.charAt(i) != S.charAt(l)) {
				int count = i - l;
				stringBuilder.append(S.charAt(l)).append(count);
				l = i;
			}
		}
		if (i == S.length()) {
			int count = i - l;
			stringBuilder.append(S.charAt(l)).append(count);
		}
		return stringBuilder.toString().length() < S.length() ? stringBuilder.toString() : S;
	}
}
