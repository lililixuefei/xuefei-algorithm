package leetcode.swordfingeroffer.unresolved;

/**
 * @description: 剑指 Offer 33. 二叉搜索树的后序遍历序列
 * @author: xuefei
 * @date: 2023/08/02 23:32
 */
public class VerifyPostorder {

    public boolean verifyPostorder(int[] postorder) {
        return recur(postorder, 0, postorder.length - 1);
    }

    boolean recur(int[] postorder, int i, int j) {
        if (i >= j) {
            return true;
        }
        int p = i;
        while (postorder[p] < postorder[j]) {
            p++;
        }
        int m = p;
        while (postorder[p] > postorder[j]) {
            p++;
        }
        return p == j && recur(postorder, i, m - 1) && recur(postorder, m, j - 1);
    }
}
