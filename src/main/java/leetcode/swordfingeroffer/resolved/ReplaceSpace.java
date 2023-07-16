package leetcode.swordfingeroffer.resolved;

/**
 * @description: 剑指 Offer 05. 替换空格
 * @author: xuefei
 * @date: 2023/07/16 16:41
 */
public class ReplaceSpace {

	public String replaceSpace(String s) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == ' ') {
				sb.append("%20");
			} else {
				sb.append(c);
			}
		}
		return sb.toString();
	}

}
