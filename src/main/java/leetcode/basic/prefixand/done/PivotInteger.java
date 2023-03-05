package leetcode.basic.prefixand.done;

/**
 * @description: 找出中枢整数
 * @author: xuefei
 * @date: 2023/02/21 22:37
 */
public class PivotInteger {

    public static void main(String[] args) {
        System.out.println(pivotInteger(8));
    }

    public static int pivotInteger(int n) {
        int[] pre = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            pre[i] = pre[i - 1] + i;
        }

        for (int i = 1; i < pre.length; i++) {
           if (pre[i - 1] == pre[n] - pre[i]){
               return i;
           }
        }
        return -1;
    }
}
