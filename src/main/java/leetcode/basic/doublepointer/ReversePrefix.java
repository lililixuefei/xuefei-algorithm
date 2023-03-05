package leetcode.basic.doublepointer;


/**
 * @description: 反转单词前缀
 * @author: xuefei
 * @date: 2023/02/28 22:39
 */
public class ReversePrefix {

	public static void main(String[] args) {
		System.out.println(reversePrefix("abcefd", 'z'));
	}

	public static String reversePrefix(String word, char ch) {
		char[] wordBytes = word.toCharArray();
		int i = 0;
		int j = 0;
		for (; i < wordBytes.length; i++) {
			if (wordBytes[i] == ch) {
				break;
			}
		}
		if (i == wordBytes.length) {
			return word;
		}

		while (j < i) {
			char temp = wordBytes[j];
			wordBytes[j++] = wordBytes[i];
			wordBytes[i--] = temp;
		}
		return String.valueOf(wordBytes);
	}

}
