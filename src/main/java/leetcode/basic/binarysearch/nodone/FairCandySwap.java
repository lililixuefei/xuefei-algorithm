package leetcode.basic.binarysearch.nodone;

import java.util.Arrays;

/**
 * @description: 公平的糖果交换
 * @author: xuefei
 * @date: 2023/03/05 14:30
 */
public class FairCandySwap {

	public static void main(String[] args) {
		int[] a = new int[]{1, 2, 5};
		int[] b = new int[]{2, 4};

		fairCandySwap(a, b);
	}

	public static int[] fairCandySwap(int[] A, int[] B) {
		int[] ans = new int[2];
		int sumA = 0;
		int sumB = 0;
		for (int i : A) {
			sumA += i;
		}
		for (int j : B) {
			sumB += j;
		}
		Arrays.sort(A);
		Arrays.sort(B);
		int temp = sumA - (sumA + sumB) / 2;
		int i = 0;
		int j = 0;
		while (i < A.length && j < B.length) {
			if (A[i] - B[j] == temp) {
				ans[0] = A[i];
				ans[1] = B[j];
				break;
			} else if (A[i] - B[j] > temp) {
				j++;
			} else if (A[i] - B[j] < temp) {
				i++;
			}
		}
		return ans;
	}

}
