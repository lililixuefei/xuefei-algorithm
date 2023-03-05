package leetcode.interviewgolden;

/**
 * @description: 字符串压缩
 * @author: xuefei
 * @date: 2023/03/05 19:31
 */
public class CompressString {

	public static void main(String[] args) {
		System.out.println(compressString("aabcccccaa"));
	}

	public static String compressString(String S) {
		if(S.length() <= 2){
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
