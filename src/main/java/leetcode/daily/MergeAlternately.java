package leetcode.daily;

/**
 * @description: 交替合并字符串
 * @author: xuefei
 * @date: 2023/02/26 19:33
 */
public class MergeAlternately {

	public String mergeAlternately(String word1, String word2) {

		int i = 0;
		int j = 0;
		StringBuilder stringBuilder = new StringBuilder();
		while (i < word1.length() && j < word2.length()){
			stringBuilder.append(word1.charAt(i++));
			stringBuilder.append(word2.charAt(j++));
		}
		while (i < word1.length()){
			stringBuilder.append(word1.charAt(i++));
		}

		while (j < word2.length()){
			stringBuilder.append(word2.charAt(j++));
		}
		return stringBuilder.toString();
	}

}
