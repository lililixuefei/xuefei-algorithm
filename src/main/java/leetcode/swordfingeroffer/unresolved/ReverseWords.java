package leetcode.swordfingeroffer.unresolved;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @description: 剑指 Offer 58 - I. 翻转单词顺序
 * @author: xuefei
 * @date: 2023/07/16 19:57
 */
public class ReverseWords {

	public String reverseWords(String s) {
		// 除去开头和末尾的空白字符
		s = s.trim();
		// 正则匹配连续的空白字符作为分隔符分割
		List<String> wordList = Arrays.asList(s.split("\\s+"));
		Collections.reverse(wordList);
		return String.join(" ", wordList);
	}

}
