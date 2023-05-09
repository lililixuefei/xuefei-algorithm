package zuoshen.daily;

/**
 * @description: 最大回文数字
 * @author: xuefei
 * @date: 2023/05/09 23:27
 */
public class MaxPalindromeNumber {

	public static void main(String[] args) {
		System.out.println(maxPalindromeNumber("39878"));
	}

	/**
	 * 给点一个字符串s，只包含0-9h这些字符，你可以使用s中的字符，目的是拼出一个最大的回文数，使用数字的个数不能超过s中包含的个数
	 * 39878   898
	 * 00900   9
	 * 54321   5
	 *
	 * @param num
	 * @return
	 */
	public static String maxPalindromeNumber(String num) {
		// 定义暂存数组
		int[] dig = new int[10];
		StringBuilder s = new StringBuilder();
		// 统计各个数字出现的次数
		for (int i = 0; i < num.length(); i++) {
			dig[num.charAt(i) - '0']++;
		}
		// 从9开始遍历各个数字
		for (int i = 9; i >= 0; i--) {
			// 如果是偶数个，依次一个i，0最后填入
			if ((dig[i] > 0 && dig[i] % 2 == 0 && i != 0) || (i == 0 && s.length() != 0 && dig[i] > 0 && dig[i] % 2 == 0)) {
				while (dig[i] != 0) {
					s.append(i);
					dig[i] -= 2;
				}
			}
			// 如果是奇数个，依次填入i，直到为1，0最后填入
			if ((dig[i] > 1 && dig[i] % 2 == 1 && i != 0) || (i == 0 && s.length() != 0 && dig[i] > 1 && dig[i] % 2 == 1)) {
				while (dig[i] != 1) {
					s.append(i);
					dig[i] -= 2;
				}
			}
		}
		// 反转字符串
		StringBuilder sReverse = new StringBuilder(s).reverse();
		// 填入单个的数字
		for (int i = 9; i >= 0; i--) {
			if (dig[i] == 1) {
				s.append(i);
				break;
			}
		}
		// 加上之前反转的字符串
		s.append(sReverse);
		return s.length() == 0 ? "0" : s.toString();
	}

}
