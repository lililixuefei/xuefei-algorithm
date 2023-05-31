package leetcode.basic.dp.basic.string;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @description: 单词拆分
 * @author: xuefei
 * @date: 2023/05/31 23:40
 */
public class WordBreak {

	public boolean wordBreak(String s, List<String> wordDict) {
		Set<String> wordDictSet = new HashSet(wordDict);
		boolean[] dp = new boolean[s.length() + 1];
		dp[0] = true;
		for (int i = 1; i <= s.length(); i++) {
			for (int j = 0; j < i; j++) {
				if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
					dp[i] = true;
					break;
				}
			}
		}
		return dp[s.length()];
	}


}
