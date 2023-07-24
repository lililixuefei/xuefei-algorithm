package leetcode.swordfingeroffer;

/**
 * @description: 剑指 Offer 46. 把数字翻译成字符串
 * @author: xuefei
 * @date: 2023/07/24 22:57
 */
public class TranslateNum {

	public int translateNum(int num) {

		return process(String.valueOf(num).toCharArray(), 0);

	}

	public int process(char[] str, int i) {
		if (i == str.length) {
			return 1;
		}
		// i没到最后，说明有字符
		if (str[i] == '0') { // 之前的决定有问题
			return 0;
		}
		// str[i] != '0'
		// 可能性一，i单转
		int ways = process(str, i + 1);
		if (i + 1 < str.length &&  str[i] != '0'  && (str[i] - '0') * 10 + str[i + 1] - '0' < 27) {
			ways += process(str, i + 2);
		}
		return ways;
	}

}
