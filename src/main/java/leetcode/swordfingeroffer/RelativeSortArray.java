package leetcode.swordfingeroffer;


/**
 * @description: 数组相对排序
 * @author: xuefei
 * @date: 2023/03/07 22:58
 */
public class RelativeSortArray {

	public static void main(String[] args) {

		int[] arr1 = new int[]{2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19};
		int[] arr2 = new int[]{2, 1, 4, 3, 9, 6};
		relativeSortArray(arr1, arr2);
	}

	public static int[] relativeSortArray(int[] arr1, int[] arr2) {
		int[] count = new int[1001];
		for (int i : arr1) {
			count[i]++;
		}
		int[] ans = new int[arr1.length];
		int j = 0;
		for (int i : arr2) {
			int num = count[i];
			count[i] = 0;
			int limit = j + num;
			while (j < limit) {
				ans[j++] = i;
			}
		}
		for (int i = 0; i < count.length; i++) {
			while (count[i] != 0) {
				ans[j++] = i;
				count[i]--;
			}
		}
		return ans;
	}

}
