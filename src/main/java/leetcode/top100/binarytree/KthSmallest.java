package leetcode.top100.binarytree;

import labuladong.binarytree.TreeNode;

/**
 * @Description 二叉搜索树中第K小的元素
 * @Author xuefei
 * @Date 2023/11/5 23:37
 * @Version 1.0
 */
public class KthSmallest {

    int kthSmallest(TreeNode root, int k) {
        // 利用 BST 的中序遍历特性
        traverse(root, k);
        return res;
    }

    // 记录结果
    int res = 0;
    // 记录当前元素的排名
    int rank = 0;

    void traverse(TreeNode root, int k) {
        if (root == null) {
            return;
        }
        traverse(root.left, k);
        /* 中序遍历代码位置 */
        rank++;
        if (k == rank) {
            // 找到第 k 小的元素
            res = root.val;
            return;
        }
        traverse(root.right, k);
    }

}
