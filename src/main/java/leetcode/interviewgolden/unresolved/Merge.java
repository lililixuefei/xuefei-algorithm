package leetcode.interviewgolden.unresolved;

/**
 * @Description 合并排序的数组
 * @Author xuefei
 * @Date 2023/9/14 23:48
 * @Version 1.0
 */
public class Merge {

    public static void main(String[] args) {
        Merge merge = new Merge();
        int[] A = {4, 0, 0, 0, 0, 0};
        int[] B = {1, 2, 3, 5, 6};
        merge.merge(A, 1, B, 5);
    }

    public void merge(int[] A, int m, int[] B, int n) {
        int[] help = new int[m + n];
        int p1 = 0, p2 = 0, i = 0;
        while (p1 < m && p2 < n) {
            help[i++] = A[p1] <= B[p2] ? A[p1++] : B[p2++];
        }
        while (p1 < m) {
            help[i++] = A[p1++];
        }
        while (p2 < n) {
            help[i++] = B[p2++];
        }
        for (i = 0; i < m + n; i++) {
            A[i] = help[i];
        }
    }


    private void swap(int[] arr, int l, int r) {
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
    }

}
