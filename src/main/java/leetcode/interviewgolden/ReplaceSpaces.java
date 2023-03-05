package leetcode.interviewgolden;

/**
 * @description: URL化
 * @author: xuefei
 * @date: 2023/03/05 18:49
 */
public class ReplaceSpaces {

	public String replaceSpaces(String S, int length) {
		if (S.length() > length) {
			S = S.substring(0, length);
		}
		return S.replace(" ","%20");
	}

}
