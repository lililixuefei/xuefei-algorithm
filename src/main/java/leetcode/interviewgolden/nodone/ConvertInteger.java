package leetcode.interviewgolden.nodone;

/**
 * @description: 整数转换
 * @author: xuefei
 * @date: 2023/03/11 17:18
 */
public class ConvertInteger {

	public static void main(String[] args) {
		convertInteger_me(100000, 1);
	}

	public int convertInteger_good(int A, int B) {
		int temp = A ^ B;
		int count = 0;
		while (temp != 0) {
			temp &= (temp - 1);
			count++;
		}
		return count;
	}

	public static int convertInteger_me(int A, int B) {
		String aBinaryString = Integer.toBinaryString(A);
		String bBinaryString = Integer.toBinaryString(B);
		System.out.println(aBinaryString);
		System.out.println(bBinaryString);

		int i = Math.abs(aBinaryString.length() - bBinaryString.length());

		String supplement = "";
		for (int k = 0; k < i; k++) {
			supplement += "0";
		}
		if (aBinaryString.length() < bBinaryString.length()) {
			aBinaryString = supplement + aBinaryString;
		} else {
			bBinaryString = supplement + bBinaryString;
		}

		int step = 0;
		for (int k = 0; k < aBinaryString.length(); k++) {
			if (aBinaryString.charAt(k) != bBinaryString.charAt(k)) {
				step++;
			}
		}
		return step;
	}

}
