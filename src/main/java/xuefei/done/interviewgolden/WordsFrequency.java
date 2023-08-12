package xuefei.done.interviewgolden;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 单词频率
 * @author: xuefei
 * @date: 2023/03/13 23:16
 */
public class WordsFrequency {

	private Map<String, Integer> wordCount;

	public WordsFrequency(String[] book) {
		wordCount = new HashMap<>();
		for (String s : book) {
			wordCount.put(s, wordCount.getOrDefault(s, 0) + 1);
		}
	}

	public int get(String word) {
		return wordCount.getOrDefault(word, 0);
	}

}
