package leetcode.interviewgolden;

/**
 * @description: 稀疏数组搜索
 * @author: xuefei
 * @date: 2023/03/28 22:46
 */
public class FindString {

	public int findString_2(String[] words, String s) {
		if (words == null || words.length == 0) {
			return -1;
		}
		int left = 0;
		int right = words.length - 1;
		while (left <= right) {
			while (left <= right && words[left].length() == 0) {
				left++;
			}
			while (left <= right && words[right].length() == 0) {
				right--;
			}
			int mid = left + (right - left) / 2;
			while (mid < right && words[mid].length() == 0) {
				mid++;
			}
			if (words[mid].equals(s)) {
				return mid;
			} else if (words[mid].compareTo(s) > 0) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return -1;
	}


	public int findString_1(String[] words, String s) {
		for (int i = 0; i < words.length; i++) {
			if (words[i].equals(s)) {
				return i;
			}
		}
		return -1;
	}

}
