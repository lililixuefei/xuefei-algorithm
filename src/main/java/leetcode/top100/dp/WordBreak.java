package leetcode.top100.dp;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Description 单词拆分
 * @Author xuefei
 * @Date 2023/12/24 15:23
 * @Version 1.0
 */
public class WordBreak {


	public boolean wordBreak(String s, List<String> wordDict) {
		Set<String> wordDictSet = new HashSet<>(wordDict);
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
