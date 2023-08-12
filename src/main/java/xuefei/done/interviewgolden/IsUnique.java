package xuefei.done.interviewgolden;

import java.util.Arrays;

/**
 * @description: 判定字符是否唯一
 * @author: xuefei
 * @date: 2023/03/05 18:43
 */
public class IsUnique {

	public boolean isUnique(String astr) {
		char[] charArray = astr.toCharArray();
		Arrays.sort(charArray);

		for (int i = 1; i < charArray.length; i++) {
			if (charArray[i] == charArray[i - 1]){
				return false;
			}
		}
		return true;
	}

}
