package leetcode.onequestion.unresolved;

/**
 * @description: H 指数 2
 * @author: xuefei
 * @date: 2023/10/30 18:50
 */
public class HIndex2 {

    public int hIndex2(int[] citations) {
        // 在区间 (left, right] 内询问
        int n = citations.length;
        int left = 0;
        int right = n;
        while (left < right) { // 区间不为空
            // 循环不变量：
            // left 的回答一定为「是」
            // right+1 的回答一定为「否」
            int mid = (left + right + 1) >>> 1; // 保证 mid 在二分区间内
            // 引用次数最多的 mid 篇论文，引用次数均 >= mid
            if (citations[n - mid] >= mid) {
                left = mid; // 询问范围缩小到 (mid, right]
            } else {
                right = mid - 1; // 询问范围缩小到 (left, mid-1]
            }
        }
        // 根据循环不变量，left 现在是最大的回答为「是」的数
        return left;
    }

    public int hIndex(int[] citations) {
        int count = 0;
        for (int i = citations.length - 1; i >= 0; i--) {
            if (citations[i] > count) {
                count++;
            }
        }
        return count;
    }

}
