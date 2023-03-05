package leetcode.interviewgolden;

import java.util.Arrays;

/**
 * @description: 判定是否互为字符重排
 * @author: xuefei
 * @date: 2023/03/05 18:46
 */
public class CheckPermutation {

	public boolean CheckPermutation(String s1, String s2) {
		if (s1.length() != s2.length()){
			return false;
		}
		char[] s1CharArray = s1.toCharArray();
		char[] s2CharArray = s2.toCharArray();
		Arrays.sort(s1CharArray);
		Arrays.sort(s2CharArray);
		for (int i = 0; i < s1CharArray.length; i++) {
			if (s1CharArray[i] != s2CharArray[i]){
				return false;
			}
		}
		return true;
	}

}
