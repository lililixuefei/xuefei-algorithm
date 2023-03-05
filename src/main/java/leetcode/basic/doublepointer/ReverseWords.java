package leetcode.basic.doublepointer;

/**
 * @description: 反转字符串中的单词 III
 * @author: xuefei
 * @date: 2023/03/01 22:32
 */
public class ReverseWords {

	public String reverseWords(String s) {
		String[] partitions = s.split(" ");
		StringBuilder stringBuilder = new StringBuilder();

		for (int i = 0; i < partitions.length; i++) {
			if (i < partitions.length - 1) {
				stringBuilder.append(reverseStr(partitions[i])).append(" ");
			} else {
				stringBuilder.append(reverseStr(partitions[i]));
			}
		}

		return stringBuilder.toString();
	}

	private String reverseStr(String str) {
		int i = 0;
		int j = str.length() - 1;
		char[] charArray = str.toCharArray();

		while (i < j) {
			char temp = charArray[i];
			charArray[i++] = charArray[j];
			charArray[j--] = temp;
		}
		return String.valueOf(charArray);
	}

}
