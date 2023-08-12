package xuefei.done.interviewgolden.nodone;

import java.util.Arrays;

/**
 * @description: 合并排序的数组
 * @author: xuefei
 * @date: 2023/03/12 22:24
 */
public class Merge {


	public void merge_good(int[] A, int m, int[] B, int n) {
		int pa = m - 1;
		int pb = n - 1;
		int tail = m + n - 1;
		int cur;
		while (pa >= 0 || pb >= 0) {
			if (pa == -1) {
				cur = B[pb--];
			} else if (pb == -1) {
				cur = A[pa--];
			} else if (A[pa] > B[pb]) {
				cur = A[pa--];
			} else {
				cur = B[pb--];
			}
			A[tail--] = cur;
		}
	}


	public void merge_2(int[] A, int m, int[] B, int n) {
		int pa = 0;
		int pb = 0;
		int[] sorted = new int[m + n];
		int cur;
		while (pa < m || pb < n) {
			if (pa == m) {
				cur = B[pb++];
			} else if (pb == n) {
				cur = A[pa++];
			} else if (A[pa] < B[pb]) {
				cur = A[pa++];
			} else {
				cur = B[pb++];
			}
			sorted[pa + pb - 1] = cur;
		}
		for (int i = 0; i != m + n; ++i) {
			A[i] = sorted[i];
		}
	}


	public void merge_1(int[] A, int m, int[] B, int n) {
		for (int i = 0; i != n; ++i) {
			A[m + i] = B[i];
		}
		Arrays.sort(A);
	}


	public void merge_me(int[] A, int m, int[] B, int n) {
		for (int i = A.length - 1; i >= 0; i--) {
			if (n > 0) {
				A[i] = B[--n];
			}
		}
		Arrays.sort(A);
	}

}
